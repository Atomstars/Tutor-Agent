package com.tutoragent.service;

import com.tutoragent.dto.PlatformDtos;
import com.tutoragent.entity.MockInterviewResult;
import com.tutoragent.repository.MockInterviewResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockInterviewService {
    private final MockInterviewResultRepository repo;
    public MockInterviewService(MockInterviewResultRepository repo) { this.repo = repo; }

    public PlatformDtos.MockResponse evaluate(String userId, PlatformDtos.MockRequest req) {
        int coverage = req.getAnswers() == null ? 0 : req.getAnswers().stream().mapToInt(a -> Math.min(a.length(), 100)).sum() / Math.max(req.getAnswers().size(), 1);
        int score = Math.min(100, 50 + coverage / 2);
        String feedback = "Focus on STAR method, edge cases, JVM internals, and SQL optimization for " + (req.getCompany() == null ? "target companies" : req.getCompany());
        List<String> weak = List.of("Multithreading", "SQL joins", "Spring bean lifecycle");
        repo.save(MockInterviewResult.builder().userId(userId).company(req.getCompany()).score(score).feedback(feedback).build());
        return PlatformDtos.MockResponse.builder().score(score).feedback(feedback).weakTopics(weak).build();
    }
}
