package com.example.CI.CDPipelineMedAWS.repository;


import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoDTO, String> {
}
