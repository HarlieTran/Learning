package com.example.Assignment2.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Assignment2.Model.User;

@Service
public class UserService {

    private final String hardcodedUsername = "admin";
    private final String hardcodedPassword = "password";

    // Temporary in-memory list for storing users
    private List<User> users = new ArrayList<>();

    // Contructor to add hardcoded user for testing purposes
    public UserService() {
        User testUser = new User();
        testUser.setUsername(hardcodedUsername);
        testUser.setPassword(hardcodedPassword);
        users.add(testUser);
    }

    // Authenticate user
    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
    }

    // Check if the username already exists
    public boolean isUsernameTaken (String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }
}
