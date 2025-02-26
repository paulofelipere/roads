package com.example.roads.controllers;

import com.example.roads.entities.UserLogin;
import com.example.roads.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "req/signup", consumes = "application/json")
    public UserLogin createUser(@RequestBody UserLogin user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userLoginRepository.save(null);

    }
}
