package com.tutoragent.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

public class PlatformDtos {
    @Data @NoArgsConstructor @AllArgsConstructor public static class CodeRunRequest { @NotBlank private String code; @NotBlank private String problemId; }
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor public static class CodeRunResponse { boolean passed; int score; long executionMs; List<String> tests; String output; }
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor public static class DashboardResponse { int readiness; double accuracy; double avgTime; List<String> weakTopics; }
    @Data @NoArgsConstructor @AllArgsConstructor public static class MockRequest { private String company; private List<String> answers; }
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor public static class MockResponse { int score; String feedback; List<String> weakTopics; }
    @Data @NoArgsConstructor @AllArgsConstructor public static class TutorRequest { private String mode; @NotBlank private String prompt; }
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor public static class TutorResponse { String answer; List<String> dailyPlan; List<String> weakTopics; }
}
