package com.example.roads.controllers;

import com.example.roads.entities.Rodovia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Aqui ficarao todos os endpoints da aplicação */
    @RestController
    public class HomeController {

        @GetMapping("sayhello")
        public String sayHello(){
            return "Hello World";
        }
        @GetMapping("getrodovias")
        public Rodovia getRodovia(){
            ///
        }


    }
