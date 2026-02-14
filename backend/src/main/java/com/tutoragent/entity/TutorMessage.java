package com.tutoragent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "tutor_message")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TutorMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String mode;
    private String role;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
