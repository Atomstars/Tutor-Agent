package com.tutoragent.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "level_progress")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LevelProgress {
    @Id
    private String id;
    private String userId;
    private int levelNumber;
    private boolean theoryCompleted;
    private boolean codingCompleted;
    private int completionPercent;
}
