package com.example.roads.controllers;

import com.example.roads.entities.Rodovia;
import com.example.roads.servicies.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* Aqui ficarao todos os endpoints da aplicação */
@RestController
public class RodoviaController {

    @Autowired
    private RoadService roadService;

    @GetMapping("sayhello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("getRodovias")
    public List<Rodovia> getRodovias(){
        return roadService.getRodovias();
    }

    @PostMapping("addTipoRodovia")
    public Rodovia SaveRodovia(@RequestBody Rodovia rodovia){
        return roadService.saveRodovia(rodovia);
    }

}