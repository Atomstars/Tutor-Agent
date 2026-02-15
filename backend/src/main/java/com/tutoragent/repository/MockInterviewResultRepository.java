package com.tutoragent.repository;

import com.tutoragent.entity.MockInterviewResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MockInterviewResultRepository extends JpaRepository<MockInterviewResult, Long> {
    List<MockInterviewResult> findByUserId(Long userId);
}
