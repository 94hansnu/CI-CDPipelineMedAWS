package com.example.CI.CDPipelineMedAWS.repository;


import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends MongoRepository<TodoDTO, String> {
}
