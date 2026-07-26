package com.example.roads.services;

import com.example.roads.entities.Trincas;
import com.example.roads.repositories.TrincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrincasService {
    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    TrincasRepository trincasRepository;

    public TrincasService() {
    }


    public List<Trincas> getTrincas() {
        return trincasRepository.findAll();
    }

    public Trincas saveTrincas(Trincas trincas) {
        calculoTrincas(trincas);
        return trincasRepository.save(trincas);
    }

    public Trincas findTrincasById(Long id) {
        return trincasRepository.findById(id).get();
    }

    public Trincas updateTrincas(Trincas trincas) {
        calculoTrincas(trincas);
        return trincasRepository.save(trincas);
    }

    public void calculoTrincas(Trincas trincas) {
        int quantidadeTrincas = trincas.getQuantidadeTrincas();

        // Classificação por faixa conforme a DNIT 008/2003.
        if (quantidadeTrincas >= LIMIAR_ALTA) {
            trincas.setCodigoTrinca("A");
            trincas.setGravidadeTrincas(3);
        } else if (quantidadeTrincas > LIMIAR_MEDIA && quantidadeTrincas < LIMIAR_ALTA) {
            trincas.setCodigoTrinca("M");
            trincas.setGravidadeTrincas(2);
        } else {
            trincas.setCodigoTrinca("B");
            trincas.setGravidadeTrincas(1);
        }

        pesoFt(trincas);
        calculoPt(trincas);
    }

    public void pesoFt(Trincas trincas) {
        String codigo = trincas.getCodigoTrinca();
        if ("A".equals(codigo)) {
            trincas.setFt(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            trincas.setFt(FATOR_MEDIO);
        } else {
            trincas.setFt(FATOR_BAIXO);
        }
    }

    private void calculoPt(Trincas trincas) {
        int gravidade = trincas.getGravidadeTrincas();
        if (gravidade == 3) {
            trincas.setPt(FATOR_ALTO);
        } else if (gravidade == 2) {
            trincas.setPt(FATOR_MEDIO);
        } else {
            trincas.setPt(FATOR_BAIXO);
        }
    }
}