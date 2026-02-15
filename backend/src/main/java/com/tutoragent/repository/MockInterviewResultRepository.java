package com.tutoragent.repository;

import com.tutoragent.entity.MockInterviewResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MockInterviewResultRepository extends MongoRepository<MockInterviewResult, String> {
    List<MockInterviewResult> findByUserId(String userId);
}
