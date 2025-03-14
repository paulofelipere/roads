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

    @GetMapping("getRodovia")
    public List<CadastroSeguimento> getRodovia() {
        return cadastroSeguimentoService.getCadastroSeguimento();
    }

    @PostMapping("addSeguimento")
        public CadastroSeguimento addSeguimento(@RequestBody CadastroSeguimento seguimento) {
            return cadastroSeguimentoService.saveCadastroSeguimento(seguimento);
    }

    @PostMapping("deleteSeguimento")
        public CadastroSeguimento deleteSeguimento(@RequestBody CadastroSeguimento seguimento) {
           return cadastroSeguimentoService.deleteCadastroSeguimento(seguimento);
    }
    @PostMapping("updateSeguimento")
        public CadastroSeguimento updateSeguimento(@RequestBody CadastroSeguimento seguimento) {
           return cadastroSeguimentoService.updateCadastroSeguimento(seguimento);
    }


}
