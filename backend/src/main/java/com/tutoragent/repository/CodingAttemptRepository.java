package com.tutoragent.repository;

import com.tutoragent.entity.CodingAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodingAttemptRepository extends JpaRepository<CodingAttempt, Long> {
    List<CodingAttempt> findByUserId(Long userId);
}
