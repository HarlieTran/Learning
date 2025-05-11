package com.example.Assignment2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Assignment2.Model.User;
import com.example.Assignment2.Service.UserService;

import jakarta.validation.Valid;

@Controller
public class SignUpController {

    private final UserService userService;

    // Constructor-based dependency injection
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    // Show the sign-up form
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup"; // Stay on the form to display validation errors
        }

        // Check if username is already taken
        if (userService.isUsernameTaken(user.getUsername())) {
            model.addAttribute("error", "Username is already taken!");
            return "signup"; // Stay on signup page if username is not available
        }

        // Register the new user
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful! Please log in.");
        
        return "signup";
    }
}
