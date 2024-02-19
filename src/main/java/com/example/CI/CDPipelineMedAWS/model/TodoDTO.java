package com.example.CI.CDPipelineMedAWS.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document (collection="todos")
public class TodoDTO {

    @MongoId
    private String id;
    private String todo;
    private String description;
    private boolean completed;
    private String assignedTo;


    public TodoDTO(String todo, String description, boolean completed, String assignedTo) {
        this.todo = todo;
        this.description = description;
        this.completed = completed;
        this.assignedTo = assignedTo;
    }

    public TodoDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id='" + id + '\'' +
                ", todo='" + todo + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
