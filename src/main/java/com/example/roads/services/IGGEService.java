package com.example.roads.services;

import com.example.roads.repositories.CadastroSeguimentoRepository;
import com.example.roads.repositories.IggeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IGGEService {
    @Autowired
    CadastroSeguimentoRepository cadastroSeguimentoRepository;

    @Autowired
    IggeRepository iggeRepository;
}
