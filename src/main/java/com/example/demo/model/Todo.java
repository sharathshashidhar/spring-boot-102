package com.example.demo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by sshashidhar on 15/07/18.
 */
public class Todo {
    @Id
    private String id;
    private String todo;
    private boolean isComplete;

    public Todo(String todo, boolean isComplete) {
        this.todo = todo;
        this.isComplete = isComplete;
    }

    public Todo() {
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

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
