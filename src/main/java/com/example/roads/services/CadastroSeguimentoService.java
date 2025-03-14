package com.example.roads.services;

import com.example.roads.entities.CadastroSeguimento;
import com.example.roads.entities.Rodovia;
import com.example.roads.repositories.CadastroSeguimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroSeguimentoService {
    @Autowired CadastroSeguimentoRepository cadastroSeguimentoRepository;

    public CadastroSeguimentoService(){

    }
    public List<CadastroSeguimento> getCadastroSeguimento() {
        return cadastroSeguimentoRepository.findAll();
    }

    public CadastroSeguimento saveCadastroSeguimento(CadastroSeguimento cadastroSeguimento) {
        cadastroSeguimentoRepository.save(cadastroSeguimento);
        return cadastroSeguimento;
    }

    public CadastroSeguimento deleteCadastroSeguimento(CadastroSeguimento cadastroSeguimento) {
        cadastroSeguimentoRepository.delete(cadastroSeguimento);
        return cadastroSeguimento;
    }

    public CadastroSeguimento findCadastroSeguimentoById(Long id) {
        return cadastroSeguimentoRepository.findById(id).get();
    }

    public CadastroSeguimento updateCadastroSeguimento(CadastroSeguimento cadastroSeguimento) {
        cadastroSeguimentoRepository.save(cadastroSeguimento);
        return cadastroSeguimento;
    }

}
