package com.tutoragent.repository;

import com.tutoragent.entity.TutorMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorMessageRepository extends JpaRepository<TutorMessage, Long> {
    List<TutorMessage> findByUserIdOrderByCreatedAtAsc(Long userId);
}
