package com.tutoragent.repository;

import com.tutoragent.entity.LevelProgress;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LevelProgressRepository extends MongoRepository<LevelProgress, String> {
    List<LevelProgress> findByUserIdOrderByLevelNumberAsc(String userId);
}
