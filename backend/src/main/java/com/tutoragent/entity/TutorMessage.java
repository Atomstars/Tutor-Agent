package com.tutoragent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "tutor_message")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TutorMessage {
    @Id
    private String id;
    private String userId;
    private String mode;
    private String role;
    private String content;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
