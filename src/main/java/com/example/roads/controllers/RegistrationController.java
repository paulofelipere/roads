/*package com.example.roads.controllers;

import com.example.roads.entities.UserLogin;
import com.example.roads.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signup", consumes = "application/json")
    public UserLogin createUser(@RequestBody UserLogin user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return loginRepository.save(user);
    }
}*/
