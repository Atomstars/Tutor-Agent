package com.tutoragent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "level_progress")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LevelProgress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private int levelNumber;
    private boolean theoryCompleted;
    private boolean codingCompleted;
    private int completionPercent;
}
