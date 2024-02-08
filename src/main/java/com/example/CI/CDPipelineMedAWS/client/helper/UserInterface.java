package com.example.CI.CDPipelineMedAWS.client.helper;

import com.example.CI.CDPipelineMedAWS.model.TodoDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayTodos(List<TodoDTO> todos) {
        if (!todos.isEmpty()) {
            displayMessage("Alla todos:");
            for (TodoDTO todo : todos) {
                displayMessage(todo.toString());
            }
        } else {
            displayMessage("Inga todos hittades.");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
