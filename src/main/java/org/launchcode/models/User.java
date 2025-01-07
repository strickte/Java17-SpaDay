package org.launchcode.models;

import java.time.LocalDate;

public class User {
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private int id;
    private LocalDate dateRegistered;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = nextId;
        this.dateRegistered = LocalDate.now();
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
