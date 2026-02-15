package com.tutoragent.repository;

import com.tutoragent.entity.LevelProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelProgressRepository extends JpaRepository<LevelProgress, Long> {
    List<LevelProgress> findByUserIdOrderByLevelNumberAsc(Long userId);
}
