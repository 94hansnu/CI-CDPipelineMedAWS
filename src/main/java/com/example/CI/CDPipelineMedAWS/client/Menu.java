package com.example.CI.CDPipelineMedAWS.client;

import com.example.CI.CDPipelineMedAWS.client.helper.MenuHelper;
import com.example.CI.CDPipelineMedAWS.client.helper.UserInterface;
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

    private final MenuHelper menuHelper;

    public Menu(MenuHelper menuHelper) {
        this.menuHelper = menuHelper;
    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            menuHelper.displayMainMenu();
            String choice = menuHelper.getUserChoice();

            switch (choice) {
                case "1":
                    menuHelper.displayAllTodos();
                    break;
                case "2":
                    menuHelper.addTodo();
                    break;
                case "3":
                    menuHelper.updateTodo();
                    break;
                case "4":
                    menuHelper.deleteTodo();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    menuHelper.displayMessage("Ogiltigt val. Försök igen.");
            }
        }
        menuHelper.displayMessage("Tack för att du använde Todo-applikationen!");
    }
}

