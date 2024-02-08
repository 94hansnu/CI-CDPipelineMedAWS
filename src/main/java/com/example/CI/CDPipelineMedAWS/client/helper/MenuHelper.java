package com.example.CI.CDPipelineMedAWS.client.helper;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MenuHelper {
    @Autowired
    private TodoService todoService;

    @Autowired
    private UserInterface userInterface;

    public void displayMessage(String message) {
        userInterface.displayMessage(message);
    }
    public void displayMainMenu() {
        userInterface.displayMessage("Välkommen till Todo-applikationen!");
        userInterface.displayMessage("1. Visa alla todos");
        userInterface.displayMessage("2. Lägg till en ny todo");
        userInterface.displayMessage("3. Uppdatera en todo");
        userInterface.displayMessage("4. Ta bort en todo");
        userInterface.displayMessage("5. Avsluta");
    }

    public String getUserChoice() {
        return userInterface.getUserInput("Ange ditt val: ");
    }

    public void displayAllTodos() {
        List<TodoDTO> allTodos = todoService.getAllTodos();
        userInterface.displayTodos(allTodos);
    }

    public void addTodo() {
        String todo = userInterface.getUserInput("Ange todo: ");
        String description = userInterface.getUserInput("Ange beskrivning: ");
        boolean completed = Boolean.parseBoolean(userInterface.getUserInput("Är det avslutat? (true/false): "));
        String assignedTo = userInterface.getUserInput("Tilldelad till: ");

        TodoDTO newTodo = new TodoDTO(todo, description, completed, assignedTo);
        TodoDTO savedTodo = todoService.saveTodo(newTodo);
        userInterface.displayMessage("Ny todo sparad: " + savedTodo);
    }

    public void updateTodo() {
        String id = userInterface.getUserInput("Ange ID för todo som ska uppdateras: ");
        Optional<TodoDTO> todoOptional = todoService.getTodoById(id);
        if (todoOptional.isPresent()) {
            TodoDTO existingTodo = todoOptional.get();
            userInterface.displayMessage("Uppdatera todo med ID: " + id);
            String todo = userInterface.getUserInput("Ange ny todo: ");
            String description = userInterface.getUserInput("Ange ny beskrivning: ");
            boolean completed = Boolean.parseBoolean(userInterface.getUserInput("Är det avslutat? (true/false): "));
            String assignedTo = userInterface.getUserInput("Tilldelad till: ");

            existingTodo.setTodo(todo);
            existingTodo.setDescription(description);
            existingTodo.setCompleted(completed);
            existingTodo.setAssignedTo(assignedTo);

            TodoDTO updatedTodo = todoService.updateTodoById(id, existingTodo);
            userInterface.displayMessage("Todo uppdaterad: " + updatedTodo);
        } else {
            userInterface.displayMessage("Todo med ID " + id + " hittades inte.");
        }
    }

    public void deleteTodo() {
        String id = userInterface.getUserInput("Ange ID för todo som ska tas bort: ");
        try {
            todoService.deleteTodoById(id);
            userInterface.displayMessage("Todo med ID " + id + " har tagits bort.");
        } catch (EmptyResultDataAccessException e) {
            userInterface.displayMessage("Todo med ID " + id + " hittades inte.");
        }
    }
}
