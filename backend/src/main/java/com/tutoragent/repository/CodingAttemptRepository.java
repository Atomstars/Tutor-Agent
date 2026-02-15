package com.tutoragent.repository;

import com.tutoragent.entity.CodingAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CodingAttemptRepository extends MongoRepository<CodingAttempt, String> {
    List<CodingAttempt> findByUserId(String userId);
}
