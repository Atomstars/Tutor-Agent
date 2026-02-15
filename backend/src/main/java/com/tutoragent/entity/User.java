package com.tutoragent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id
    private String id;
    private String email;
    private String passwordHash;
    private String fullName;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
