package com.example.roads.controllers;

import com.example.roads.entities.Rodovia;
import com.example.roads.services.RodoviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RodoviaController {

    @Autowired
    private RodoviaService roadService;

    @GetMapping("sayhello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("getRodovias")
    public List<Rodovia> getRodovias(){
        return roadService.getRodovias();
    }

    @PostMapping("addRodovia")
    public Rodovia saveRodovia(@RequestBody Rodovia rodovia){
        return roadService.saveRodovia(rodovia);
    }
    @DeleteMapping("deleteRodovia")
    public Rodovia deleteRodovia(@RequestBody Rodovia rodovia){
       return roadService.deleteRodovia(rodovia);
    }
}