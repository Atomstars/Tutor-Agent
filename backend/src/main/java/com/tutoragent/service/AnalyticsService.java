package com.tutoragent.service;

import com.tutoragent.dto.PlatformDtos;
import com.tutoragent.entity.CodingAttempt;
import com.tutoragent.entity.MockInterviewResult;
import com.tutoragent.repository.CodingAttemptRepository;
import com.tutoragent.repository.MockInterviewResultRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AnalyticsService {
    private final CodingAttemptRepository attempts;
    private final MockInterviewResultRepository mocks;
    public AnalyticsService(CodingAttemptRepository attempts, MockInterviewResultRepository mocks) { this.attempts = attempts; this.mocks = mocks; }

    public PlatformDtos.DashboardResponse dashboard(Long userId) {
        List<CodingAttempt> c = attempts.findByUserId(userId);
        List<MockInterviewResult> m = mocks.findByUserId(userId);
        double accuracy = c.stream().mapToInt(a -> a.isPassed() ? 1 : 0).average().orElse(0) * 100;
        double avgTime = c.stream().mapToLong(CodingAttempt::getExecutionMs).average().orElse(0);
        int mockAvg = (int) m.stream().mapToInt(MockInterviewResult::getScore).average().orElse(0);
        int readiness = (int) Math.min(100, accuracy * 0.5 + (100 - Math.min(avgTime / 30, 100)) * 0.2 + mockAvg * 0.3);
        List<String> weak = c.stream().filter(a -> !a.isPassed()).map(CodingAttempt::getProblemId).distinct().sorted(Comparator.naturalOrder()).limit(5).toList();
        return PlatformDtos.DashboardResponse.builder().accuracy(accuracy).avgTime(avgTime).readiness(readiness).weakTopics(weak).build();
    }
}
