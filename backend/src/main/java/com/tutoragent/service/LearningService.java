package com.tutoragent.service;

import com.tutoragent.entity.LevelProgress;
import com.tutoragent.repository.LevelProgressRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LearningService {
    private static final List<String> LEVELS = List.of("Java Fundamentals","OOPS","Collections","Exception Handling","Multithreading","Java 8","JDBC","Spring Boot Basics","SQL","Advanced Interview Mode");
    private final LevelProgressRepository progressRepository;

    public LearningService(LevelProgressRepository progressRepository) { this.progressRepository = progressRepository; }
    public List<Map<String,Object>> getLevels(String userId) {
        Map<Integer, LevelProgress> map = new HashMap<>();
        progressRepository.findByUserIdOrderByLevelNumberAsc(userId).forEach(p -> map.put(p.getLevelNumber(), p));
        List<Map<String,Object>> out = new ArrayList<>();
        for (int i=1;i<=LEVELS.size();i++) {
            LevelProgress p = map.getOrDefault(i, LevelProgress.builder().levelNumber(i).completionPercent(0).theoryCompleted(false).codingCompleted(false).build());
            out.add(Map.of("level", i, "title", LEVELS.get(i-1), "completion", p.getCompletionPercent(), "theory", p.isTheoryCompleted(), "coding", p.isCodingCompleted()));
        }
        return out;
    }
}
