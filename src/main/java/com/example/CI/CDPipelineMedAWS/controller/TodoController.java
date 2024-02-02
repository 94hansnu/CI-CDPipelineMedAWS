package com.example.CI.CDPipelineMedAWS.controller;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        if (!todos.isEmpty()) {
            return new ResponseEntity<>(todos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No todos found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable String id) {
        Optional<TodoDTO> todo = todoService.getTodoById(id);
        return todo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TodoDTO> saveTodo(@RequestBody TodoDTO todo) {
        TodoDTO savedTodo = todoService.saveTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody TodoDTO updatedTodo) {
        try {
            TodoDTO result = todoService.updateTodoById(id, updatedTodo);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Todo not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable String id) {
        try {
            todoService.deleteTodoById(id);
            return new ResponseEntity<>("Todo deleted successfully with id: " + id, HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Todo not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

}
