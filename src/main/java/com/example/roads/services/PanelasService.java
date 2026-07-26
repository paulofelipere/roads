package com.example.roads.services;

import com.example.roads.entities.Panelas;
import com.example.roads.repositories.PanelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelasService {
    private static final double PESO_ALTO = 1.0;
    private static final double PESO_MEDIO = 0.80;
    private static final double PESO_BAIXO = 0.70;
    private static final int QUANTIDADE_ALTA = 5;
    private static final int QUANTIDADE_MEDIA = 2;

    @Autowired PanelasRepository panelasRepository;

    public PanelasService(){

    }

    public List<Panelas> getPanelas() {
        return panelasRepository.findAll();
    }

    public Panelas savePanelas(Panelas panelas) {
        frequenciaPanelas(panelas);
        panelasRepository.save(panelas);
        return panelas;
    }

    public Panelas deletePanelas(Panelas panelas) {
        panelasRepository.delete(panelas);
        return panelas;
    }

    public Panelas findPanelasById(Long id) {
        return panelasRepository.findById(id).get();
    }

    public Panelas updatePanelas(Panelas panelas) {
        frequenciaPanelas(panelas);
        panelasRepository.save(panelas);
        return panelas;
    }

    public void frequenciaPanelas(Panelas panelas) {
        int quantidadeKm = panelas.getQuantidade();

        if (quantidadeKm >= QUANTIDADE_ALTA) {
            panelas.setCodigo("A");
            panelas.setGravidade(3);
        } else if (quantidadeKm > QUANTIDADE_MEDIA && quantidadeKm < QUANTIDADE_ALTA) {
            panelas.setCodigo("M");
            panelas.setGravidade(2);
        } else {
            panelas.setCodigo("B");
            panelas.setGravidade(1);
        }

        pesoFpr(panelas);
        pesoPpr(panelas);
    }

    public void pesoFpr(Panelas panelas) {
        int quantidadeKm = panelas.getQuantidade();
        if (quantidadeKm >= QUANTIDADE_ALTA) {
            panelas.setFpr(PESO_ALTO);
        } else if (quantidadeKm > QUANTIDADE_MEDIA && quantidadeKm < QUANTIDADE_ALTA) {
            panelas.setFpr(PESO_MEDIO);
        } else {
            panelas.setFpr(PESO_BAIXO);
        }
    }

    public void pesoPpr(Panelas panelas) {
        int gravidade = panelas.getGravidade();
        if (gravidade == 3) {
            panelas.setPpr(PESO_ALTO);
        } else if (gravidade == 2) {
            panelas.setPpr(PESO_MEDIO);
        } else {
            panelas.setPpr(PESO_BAIXO);
        }
    }

}
