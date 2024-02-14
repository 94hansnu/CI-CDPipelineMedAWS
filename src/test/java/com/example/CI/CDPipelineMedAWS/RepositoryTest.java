/*package com.example.CI.CDPipelineMedAWS;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testSaveAndFindById() {
        // Skapa en TodoDTO och spara den i databasen
        TodoDTO todoToSave = new TodoDTO("Uppgift", "Beskrivning", false, "Användare");
        TodoDTO savedTodo = todoRepository.save(todoToSave);

        // Hämta TodoDTO från databasen med samma ID
        Optional<TodoDTO> foundTodo = todoRepository.findById(savedTodo.getId());

        // Verifiera att TodoDTO hittades och att dess attribut är korrekta
        assertTrue(foundTodo.isPresent());
        assertEquals("Uppgift", foundTodo.get().getTodo());
        assertEquals("Beskrivning", foundTodo.get().getDescription());
        assertFalse(foundTodo.get().isCompleted());
        assertEquals("Användare", foundTodo.get().getAssignedTo());
    }
}
*/