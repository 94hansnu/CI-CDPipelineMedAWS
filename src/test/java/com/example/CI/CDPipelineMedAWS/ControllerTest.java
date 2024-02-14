/*package com.example.CI.CDPipelineMedAWS;

import com.example.CI.CDPipelineMedAWS.controller.TodoController;
import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoService todoService;

    @Test
    public void testGetAllTodos() {
        // Mocka serviceanrop och verifiera att rätt svar returneras
        when(todoService.getAllTodos()).thenReturn(Arrays.asList(new TodoDTO(), new TodoDTO()));
        ResponseEntity<?> result = todoController.getAllTodos();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody() instanceof List);
        assertEquals(2, ((List<?>) result.getBody()).size());
    }

    @Test
    public void testGetTodoById() {
        // Mocka serviceanrop och verifiera att rätt svar returneras
        String todoId = "1";
        when(todoService.getTodoById(todoId)).thenReturn(Optional.of(new TodoDTO()));
        ResponseEntity<?> result = todoController.getTodoById(todoId);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody() instanceof TodoDTO);
    }

    @Test
    public void testSaveTodo() {
        // Mocka serviceanrop och verifiera att rätt svar returneras
        TodoDTO todoToSave = new TodoDTO("Uppgift", "Beskrivning", false, "Användare");
        when(todoService.saveTodo(todoToSave)).thenReturn(todoToSave);
        ResponseEntity<TodoDTO> result = todoController.saveTodo(todoToSave);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(todoToSave, result.getBody());
    }

    @Test
    public void testUpdateTodo() {
        // Mocka serviceanrop och verifiera att rätt svar returneras
        String todoId = "1";
        TodoDTO updatedTodo = new TodoDTO("Uppdaterad Uppgift", "Uppdaterad Beskrivning", true, "Uppdaterad Användare");
        when(todoService.updateTodoById(todoId, updatedTodo)).thenReturn(updatedTodo);
        ResponseEntity<?> result = todoController.updateTodo(todoId, updatedTodo);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody() instanceof TodoDTO);
    }

    @Test
    public void testDeleteTodoById() {
        // Mocka serviceanrop och verifiera att rätt svar returneras
        String todoId = "1";
        ResponseEntity<?> result = todoController.deleteTodoById(todoId);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    @Test
    public void testDeleteTodoByIdNotFound() {
        // Mocka serviceanrop och verifiera att rätt svar returneras vid "hittades inte"-scenariot
        String todoId = "1";
        doThrow(new EmptyResultDataAccessException(1)).when(todoService).deleteTodoById(todoId);
        ResponseEntity<?> result = todoController.deleteTodoById(todoId);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }
}*/
