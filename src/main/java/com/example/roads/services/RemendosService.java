package com.example.roads.services;


import com.example.roads.entities.Remendos;
import com.example.roads.repositories.RemendosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemendosService {

    @Autowired
    RemendosRepository remendosRepository;

    public RemendosService() {
    }

    public List<Remendos> getRemendos() {
        return remendosRepository.findAll();
    }

    public Remendos saveRemendos(Remendos remendos) {
        frequenciaRemendos(remendos);
        remendosRepository.save(remendos);
        return remendos;
    }

    public Remendos findRemendosById(Long id) {
        return remendosRepository.findById(id).get();
    }

    public Remendos updateRemendos(Remendos remendos) {
        frequenciaRemendos(remendos);
        remendosRepository.save(remendos);
        return remendos;
    }
    public void frequenciaRemendos(Remendos remendos) {
        int quantidadeKm = remendos.getQuantidade();
        if (quantidadeKm >= 5) {
            remendos.setCodigoRemendos("A");
            remendos.setGravidade(3);

        } else if (quantidadeKm > 2 && quantidadeKm < 5) {
            remendos.setCodigoRemendos("M");
            remendos.setGravidade(2);

        } else {
            remendos.setCodigoRemendos("B");
            remendos.setGravidade(1);

        }
        pesoFpr(remendos);
        pesoPpr(remendos);
    }

    public void pesoFpr(Remendos remendos) {
        int quantidade = remendos.getQuantidade();
        if (quantidade >= 5) {
            remendos.setFpr(1);
        } else if (quantidade > 2 && quantidade < 5) {
            remendos.setFpr(0.80);
        } else {
            remendos.setFpr(0.70);
        }
    }

    public void pesoPpr(Remendos remendos) {
        int gravidade =  remendos.getGravidade();
        if (gravidade == 3) {
            remendos.setPpr(1);
        } else if (gravidade == 2) {
            remendos.setPpr(0.80);
        } else {
            remendos.setPpr(0.70);
        }
    }
}

