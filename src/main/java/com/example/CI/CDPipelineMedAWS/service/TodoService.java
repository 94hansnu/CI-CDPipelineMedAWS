package com.example.CI.CDPipelineMedAWS.service;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public List<TodoDTO> getAllTodos() {
        List<TodoDTO> todos = todoRepo.findAll();
        return todos;
    }

    public Optional<TodoDTO> getTodoById(String id) {
        Optional<TodoDTO> todo = todoRepo.findById(id);
        return todo;
    }
    public TodoDTO saveTodo(TodoDTO todo) {
        TodoDTO savedTodo = todoRepo.save(todo);
        return savedTodo;
    }

    public TodoDTO updateTodoById(String id, TodoDTO updatedTodo) {
        if (!todoRepo.existsById(id)) {
            throw new EmptyResultDataAccessException("Todo not found with id " + id, 1);
        }

        updatedTodo.setId(id);
        TodoDTO result = todoRepo.save(updatedTodo);
        return result;
    }

    public void deleteTodoById(String id) {
        if (!todoRepo.existsById(id)) {
            throw new EmptyResultDataAccessException("Todo not found with id " + id, 1);
        }
        todoRepo.deleteById(id);
    }
}
