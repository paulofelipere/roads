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
            /* panelas.setGravidade(3);*/
            System.out.println("Frequencia Alta!");
        } else if (quantidadeKm > 2 && quantidadeKm < 5) {
            remendos.setCodigoRemendos("M");
            /*panelas.setGravidade(2);*/
            System.out.println("Frequencia Média!");
        } else {
            remendos.setCodigoRemendos("B");
            /* panelas.setGravidade(1);*/

            System.out.println("Frequencia baixa");
        }
    }

    public void fatorFpr(Remendos remendos) {
        int quantidadeKm = remendos.getQuantidade();
        if (quantidadeKm >= 5) {
            remendos.setGravidade(3);
            System.out.println("Frequencia Alta!");
        } else if (quantidadeKm > 2 && quantidadeKm < 5) {
            remendos.setGravidade(2);
            System.out.println("Frequencia Média!");
        } else {
            remendos.setGravidade(1);
            System.out.println("Frequencia baixa");
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

