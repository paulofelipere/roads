package com.example.roads.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    @GetMapping("/login")
    public String login(){
        return  "login";
    }
    @GetMapping("/req/signup")
    public String signup(){
        return "signup";
    }

}
