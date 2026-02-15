package com.tutoragent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "mock_interview_result")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MockInterviewResult {
    @Id
    private String id;
    private String userId;
    private String company;
    private int score;
    private String feedback;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
