package com.example.CI.CDPipelineMedAWS.client;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import com.example.CI.CDPipelineMedAWS.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private TodoService todoService;

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running =true;

        while(running){
            System.out.println("Välkommen till Todo-applikationen!");
            System.out.println("1. Visa alla todos");
            System.out.println("2. Lägg till en ny todo");
            System.out.println("3. Uppdatera en todo");
            System.out.println("4. Ta bort en todo");
            System.out.println("5. Avsluta");

            System.out.print("Ange ditt val: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<TodoDTO> allTodos = todoService.getAllTodos();
                    displayAllTodos(allTodos);
                    break;
                case "2":
                    addTodo();
                    break;
                case "3":
                    updateTodo();
                    break;
                case "4":
                    deleteTodo();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
        System.out.println("Tack för att du använde Todo-applikationen!");
        scanner.close();
    }

    private void displayAllTodos(List<TodoDTO> todos) {
        if (!todos.isEmpty()) {
            System.out.println("Alla todos:");
            for (TodoDTO todo : todos) {
                System.out.println(todo);
            }
        } else {
            System.out.println("Inga todos hittades.");
        }
    }
    private void addTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lägg till en ny todo: ");
        System.out.println("Ange todo: ");
        String todo = scanner.nextLine();
        System.out.print("Ange beskrivning: ");
        String description = scanner.nextLine();
        System.out.print("Är det avslutat? (true/false): ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Tilldelad till: ");
        String assignedTo = scanner.nextLine();

        TodoDTO newTodo = new TodoDTO(todo, description, completed, assignedTo);
        TodoDTO savedTodo = todoService.saveTodo(newTodo);
        System.out.println("Ny todo sparad: " + savedTodo);
    }
    private void updateTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange ID för todo som ska uppdateras: ");
        String id = scanner.nextLine();
        Optional<TodoDTO> todoOptional = todoService.getTodoById(id);
        if (todoOptional.isPresent()) {
            TodoDTO existingTodo = todoOptional.get();
            System.out.println("Uppdatera todo med ID: " + id);
            System.out.print("Ange ny todo: ");
            String todo = scanner.nextLine();
            System.out.print("Ange ny beskrivning: ");
            String description = scanner.nextLine();
            System.out.print("Är det avslutat? (true/false): ");
            boolean completed = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Tilldelad till: ");
            String assignedTo = scanner.nextLine();

            existingTodo.setTodo(todo);
            existingTodo.setDescription(description);
            existingTodo.setCompleted(completed);
            existingTodo.setAssignedTo(assignedTo);

            TodoDTO updatedTodo = todoService.updateTodoById(id, existingTodo);
            System.out.println("Todo uppdaterad: " + updatedTodo);
        } else {
            System.out.println("Todo med ID " + id + " hittades inte.");
        }
    }

    private void deleteTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange ID för todo som ska tas bort: ");
        String id = scanner.nextLine();
        try {
            todoService.deleteTodoById(id);
            System.out.println("Todo med ID " + id + " har tagits bort.");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Todo med ID " + id + " hittades inte.");
        }

    }

}
