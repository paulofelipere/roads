package com.example.roads.controllers;

import com.example.roads.entities.CadastroSeguimento;
import com.example.roads.entities.Rodovia;
import com.example.roads.services.CadastroSeguimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CadastroSeguimentoController {

    @Autowired
    private CadastroSeguimentoService cadastroSeguimentoService;

    @GetMapping("getCadastroSeguimento")
    public List<CadastroSeguimento> getCadastroSeguimento() {
        return cadastroSeguimentoService.getCadastroSeguimento();
    }

    @PostMapping("addCadastroSeguimento")
    public CadastroSeguimento saveCadastroSeguimento(@RequestBody CadastroSeguimento cadastroSeguimento) {
        return cadastroSeguimentoService.saveCadastroSeguimento(cadastroSeguimento);
    }

    @PostMapping("deleteCadastroSeguimento")
    public CadastroSeguimento deleteCadastroSeguimento(@RequestBody CadastroSeguimento cadastroSeguimento) {
        return cadastroSeguimentoService.deleteCadastroSeguimento(cadastroSeguimento);
    }

    @PostMapping("findCadastroSeguimentoById")
    public CadastroSeguimento findCadastroSeguimentoById(@RequestBody Long id) {
        return cadastroSeguimentoService.findCadastroSeguimentoById(id);
    }

    @PostMapping("updateCadastroSeguimento")
    public CadastroSeguimento updateCadastroSeguimento(@RequestBody CadastroSeguimento cadastroSeguimento) {
        return cadastroSeguimentoService.updateCadastroSeguimento(cadastroSeguimento);

    }
}
