package com.tutoragent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "coding_attempt")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CodingAttempt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String problemId;
    @Column(columnDefinition = "TEXT")
    private String code;
    private boolean passed;
    private int score;
    private long executionMs;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
