package com.example.lawyerfinderapp.models;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

    public User(int id, String firstname, String lastname, String email, String role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }

    // Getters
    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}
