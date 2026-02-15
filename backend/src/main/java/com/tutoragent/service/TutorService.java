package com.tutoragent.service;

import com.tutoragent.dto.PlatformDtos;
import com.tutoragent.entity.TutorMessage;
import com.tutoragent.repository.TutorMessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorMessageRepository repo;
    @Value("${app.ai.provider:openai}") private String provider;
    public TutorService(TutorMessageRepository repo) { this.repo = repo; }

    public List<TutorMessage> history(String userId) { return repo.findByUserIdOrderByCreatedAtAsc(userId); }

    public PlatformDtos.TutorResponse respond(String userId, PlatformDtos.TutorRequest req) {
        repo.save(TutorMessage.builder().userId(userId).mode(req.getMode()).role("user").content(req.getPrompt()).build());
        String answer = "Analogy first: Think of Java threads like kitchen staff sharing stations. Structured answer (" + req.getMode() + "): " + req.getPrompt() + " -> explain core concept, real example, pitfalls, interview framing. Provider=" + provider + " (Ollama supported by config).";
        repo.save(TutorMessage.builder().userId(userId).mode(req.getMode()).role("assistant").content(answer).build());
        return PlatformDtos.TutorResponse.builder().answer(answer).weakTopics(List.of("Exception propagation", "Collections tuning")).dailyPlan(List.of("Morning: 30m Java 8 streams", "Afternoon: 2 coding questions", "Night: 1 mock round")).build();
    }
}
