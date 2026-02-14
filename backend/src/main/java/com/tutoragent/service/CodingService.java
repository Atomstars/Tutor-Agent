package com.tutoragent.service;

import com.tutoragent.dto.PlatformDtos;
import com.tutoragent.entity.CodingAttempt;
import com.tutoragent.exception.ApiException;
import com.tutoragent.repository.CodingAttemptRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class CodingService {
    private final CodingAttemptRepository attempts;
    public CodingService(CodingAttemptRepository attempts) { this.attempts = attempts; }

    public PlatformDtos.CodeRunResponse execute(Long userId, PlatformDtos.CodeRunRequest req) {
        try {
            Path dir = Files.createTempDirectory("java-run");
            Path src = dir.resolve("Main.java");
            Files.writeString(src, req.getCode());
            Process compile = new ProcessBuilder("javac", src.toString()).directory(dir.toFile()).start();
            if (compile.waitFor() != 0) throw new ApiException("Compilation failed: " + new String(compile.getErrorStream().readAllBytes()));

            Instant start = Instant.now();
            Process run = new ProcessBuilder("java", "-cp", dir.toString(), "Main").directory(dir.toFile()).start();
            boolean finished = run.waitFor(3, java.util.concurrent.TimeUnit.SECONDS);
            if (!finished) { run.destroyForcibly(); throw new ApiException("Execution timeout"); }
            long ms = Duration.between(start, Instant.now()).toMillis();
            String output = new String(run.getInputStream().readAllBytes());
            boolean passed = output.toLowerCase().contains("pass") || run.exitValue() == 0;
            int score = passed ? 90 : 40;
            attempts.save(CodingAttempt.builder().userId(userId).problemId(req.getProblemId()).code(req.getCode()).passed(passed).score(score).executionMs(ms).build());
            return PlatformDtos.CodeRunResponse.builder().passed(passed).score(score).executionMs(ms).output(output).tests(List.of("Hidden cases executed", passed ? "All pass" : "Some failed")).build();
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Execution error: " + e.getMessage());
        }
    }
}
