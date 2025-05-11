package com.example.Assignment2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Assignment2.Model.User;
import com.example.Assignment2.Service.UserService;


@Controller
public class LoginController {

    private final UserService userService;
    private static final String LOGIN_ERROR_MESSAGE = "Invalid username or password";


    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage(User user) {
        return "login"; // Returns the Thymeleaf template login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        
        // Check input values
        if (username.isEmpty() || password.isEmpty()){
            model.addAttribute("error", "Username and password are required!");
            return "login";
        }
        
        // Authenticate input values
        if (userService.authenticate(username, password)) {
            return "redirect:/items"; // Redirects to item listing if login is successful
        }

        // Errors
        model.addAttribute("error", LOGIN_ERROR_MESSAGE);
        return "login";
    }
}
