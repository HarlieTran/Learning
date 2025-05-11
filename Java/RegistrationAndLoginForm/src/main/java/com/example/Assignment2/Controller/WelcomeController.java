package com.example.Assignment2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    
    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }
}
