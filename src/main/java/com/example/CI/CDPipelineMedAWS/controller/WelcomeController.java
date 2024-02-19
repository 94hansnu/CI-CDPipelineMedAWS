package com.example.CI.CDPipelineMedAWS.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("")
    public String welcome(){
        return "Välkommen till Todo applikationen! ";
    }
}
