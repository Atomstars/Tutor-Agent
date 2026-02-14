package com.tutoragent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "mock_interview_result")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MockInterviewResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String company;
    private int score;
    @Column(columnDefinition = "TEXT")
    private String feedback;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
