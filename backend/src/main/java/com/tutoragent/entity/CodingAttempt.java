package com.tutoragent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "coding_attempt")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CodingAttempt {
    @Id
    private String id;
    private String userId;
    private String problemId;
    private String code;
    private boolean passed;
    private int score;
    private long executionMs;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
