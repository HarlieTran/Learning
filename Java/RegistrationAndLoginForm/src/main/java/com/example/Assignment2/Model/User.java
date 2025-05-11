package com.example.Assignment2.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username is required")
    @Size(min = 4, message = "Username must be at least 4 characters long")
    private String username;

    @NotBlank(message = "Full name is required")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Full Name must contain only letters and spaces")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 9, message = "Password must be more than 8 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$", message = "Password must contain at least one capital letter and one special character")
    private String password;

    // Constructor
    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public User(String username, String fullName, String email, String password ) {
        setUsername(username);
        setFullName(fullName);
        setEmail(email);
        setPassword(password);
    }

    public User() {
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
