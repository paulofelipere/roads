package com.example.roads.services;

import com.example.roads.entities.Trincas;
import com.example.roads.repositories.TrincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrincasService {
    @Autowired
    TrincasRepository trincasRepository;

    public TrincasService() {
    }

    public List<Trincas> getTrincas() {
        return trincasRepository.findAll();
    }

    public Trincas saveTrincas(Trincas trincas) {
        calculoTrincas(trincas);
        trincasRepository.save(trincas);
        return trincas;
    }

    public Trincas findTrincasById(Long id) {
        return trincasRepository.findById(id).get();
    }

    public Trincas updateTrincas(Trincas trincas) {
        calculoTrincas(trincas);
        trincasRepository.save(trincas);
        return trincas;
    }


    public void tipoTrincas(Trincas trincas) {} // função para adcionar o tipo da trinca

    public void calculoTrincas(Trincas trincas) {
        int quantidade = trincas.getQuantidadeTrincas();

        if (quantidade >= 5) {
            trincas.setCodigoTrinca("A");
            trincas.setGravidadeTrincas(3);
        } else if (quantidade > 2 && quantidade < 5) {
            trincas.setCodigoTrinca("M");
            trincas.setGravidadeTrincas(2);
        } else {
            trincas.setCodigoTrinca("B");
            trincas.setGravidadeTrincas(1);
        }


        int gravidade = trincas.getGravidadeTrincas();
        if (gravidade == 3) {
            trincas.setPt(0.65);
        } else if (gravidade == 2) {
            trincas.setPt(0.45);
        } else {
            trincas.setPt(0.30);
        }
    }
}