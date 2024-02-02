package com.example.CI.CDPipelineMedAWS;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.repository.TodoRepository;
import com.example.CI.CDPipelineMedAWS.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Test
    public void testGetAllTodos() {
        // Mocka data och verifiera att rätt metod anropas
        when(todoRepository.findAll()).thenReturn(Arrays.asList(new TodoDTO(), new TodoDTO()));
        List<TodoDTO> result = todoService.getAllTodos();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTodoById() {
        // Mocka data och verifiera att rätt metod anropas
        String todoId = "1";
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(new TodoDTO()));
        Optional<TodoDTO> result = todoService.getTodoById(todoId);
        assertTrue(result.isPresent());
    }

    @Test
    public void testSaveTodo() {
        // Mocka data och verifiera att rätt metod anropas
        TodoDTO todoToSave = new TodoDTO("uppgift", "Beskrivning", false, "Användare");
        when(todoRepository.save(todoToSave)).thenReturn(todoToSave);
        TodoDTO result = todoService.saveTodo(todoToSave);
        assertEquals(todoToSave, result);
    }

    @Test
    public void testUpdateTodoById() {
        // Mocka data och verifiera att rätt metod anropas
        String todoId = "1";
        TodoDTO updatedTodo = new TodoDTO("Uppdaterad Uppgift", "Uppdaterad Beskrivning", true, "Uppdaterad Användare");
        when(todoRepository.existsById(todoId)).thenReturn(true);
        when(todoRepository.save(updatedTodo)).thenReturn(updatedTodo);
        TodoDTO result = todoService.updateTodoById(todoId, updatedTodo);
        assertEquals(updatedTodo, result);
    }

    @Test
    public void testDeleteTodoById() {
        // Mocka data och verifiera att rätt metod anropas
        String todoId = "1";
        when(todoRepository.existsById(todoId)).thenReturn(true);
        todoService.deleteTodoById(todoId);
        verify(todoRepository, times(1)).deleteById(todoId);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDeleteTodoByIdNotFound() {
        // Mocka data för att simulera "hittades inte"
        String todoId = "1";
        when(todoRepository.existsById(todoId)).thenReturn(false);
        todoService.deleteTodoById(todoId);
    }
}
