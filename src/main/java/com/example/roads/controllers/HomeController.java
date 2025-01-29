package com.example.roads.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Aqui ficara todos os endpoints da aplicação */
    @RestController
    public class HomeController {

        @GetMapping("sayhello")
        public String sayHello(){
            return "Hello World";
        }
    }
