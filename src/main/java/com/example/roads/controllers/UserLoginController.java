package com.example.roads.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
    @GetMapping("/req/login")
    public String login(){
        return "login"; // This should match the name of your HTML template
    }

    @GetMapping("/req/signup")
    public String signup(){
        return "signup";
    }
}