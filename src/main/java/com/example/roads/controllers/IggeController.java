package com.example.roads.controllers;

import com.example.roads.dto.IggeResultado;
import com.example.roads.services.IGGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IggeController {

    @Autowired
    private IGGEService iggeService;

    @GetMapping("calcularIgge/{seguimentoId}")
    public IggeResultado calcularIgge(@PathVariable Long seguimentoId) {
        return iggeService.calcularIgge(seguimentoId);
    }

    @PostMapping("salvarIgge/{seguimentoId}")
    public IggeResultado calcularESalvarIgge(@PathVariable Long seguimentoId) {
        return iggeService.calcularESalvarIgge(seguimentoId);
    }
}
