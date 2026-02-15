package com.tutoragent.controller;

import com.tutoragent.dto.PlatformDtos;
import com.tutoragent.service.*;
import com.tutoragent.util.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlatformController {
    private final AuthService authService;
    private final LearningService learning;
    private final CodingService coding;
    private final MockInterviewService mock;
    private final AnalyticsService analytics;
    private final TutorService tutor;

    public PlatformController(AuthService authService, LearningService learning, CodingService coding, MockInterviewService mock, AnalyticsService analytics, TutorService tutor) {
        this.authService = authService; this.learning = learning; this.coding = coding; this.mock = mock; this.analytics = analytics; this.tutor = tutor;
    }

    @GetMapping("/levels") public List<Map<String,Object>> levels() { return learning.getLevels(authService.userIdByEmail(SecurityUtil.email())); }
    @PostMapping("/coding/run") public PlatformDtos.CodeRunResponse run(@Valid @RequestBody PlatformDtos.CodeRunRequest req) { return coding.execute(authService.userIdByEmail(SecurityUtil.email()), req); }
    @PostMapping("/mock/submit") public PlatformDtos.MockResponse mock(@RequestBody PlatformDtos.MockRequest req) { return mock.evaluate(authService.userIdByEmail(SecurityUtil.email()), req); }
    @GetMapping("/analytics/dashboard") public PlatformDtos.DashboardResponse dashboard() { return analytics.dashboard(authService.userIdByEmail(SecurityUtil.email())); }
    @GetMapping("/tutor/history") public List<?> tutorHistory() { return tutor.history(authService.userIdByEmail(SecurityUtil.email())); }
    @PostMapping("/tutor/chat") public PlatformDtos.TutorResponse tutorChat(@Valid @RequestBody PlatformDtos.TutorRequest req) { return tutor.respond(authService.userIdByEmail(SecurityUtil.email()), req); }

    @PostMapping("/company/focus")
    public Map<String,Object> companyFocus(@RequestBody Map<String,String> req) {
        String company = req.getOrDefault("company", "Generic");
        return Map.of("company", company, "priority", List.of("DSA in Java", "Concurrency", "SQL"), "checklist", List.of("Revise collections", "2 mocks", "Behavioral prep"));
    }
}
