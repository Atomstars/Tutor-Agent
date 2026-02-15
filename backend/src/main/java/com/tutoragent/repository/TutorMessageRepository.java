package com.tutoragent.repository;

import com.tutoragent.entity.TutorMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TutorMessageRepository extends MongoRepository<TutorMessage, String> {
    List<TutorMessage> findByUserIdOrderByCreatedAtAsc(String userId);
}
