package com.example.roads.services;


import com.example.roads.entities.Trincas;
import com.example.roads.repositories.TrincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrincasService {
    @Autowired TrincasRepository trincasRepository;

    public TrincasService(){
    }

    public List<Trincas> getTrincas(){return trincasRepository.findAll();}

    public Trincas saveTrincas(Trincas trincas){
        frequenciaTrincas(trincas);
        trincasRepository.save(trincas);
        return trincas;
    }

    public Trincas findTrincasById(Long id){
        return trincasRepository.findById(id).get();}

    public Trincas updateTrincas(Trincas trincas){
        frequenciaTrincas(trincas);
        trincasRepository.save(trincas);
        return trincas;
    }
    public void frequenciaTrincas(Trincas trincas) {
        double quantidadeKm = trincas.getQuantidadeTrincas();
        if (quantidadeKm >= 0.5) {
            trincas.setCodigoTrinca("A");
            /* panelas.setGravidade(3);*/
            System.out.println("Frequencia Alta!");
        } else if (quantidadeKm > 0.2 && quantidadeKm < 0.5) {
            trincas.setCodigoTrinca("M");
            /*panelas.setGravidade(2);*/
            System.out.println("Frequencia Média!");
        } else {
            trincas.setCodigoTrinca("B");
            System.out.println("Frequencia baixa");
        }

    }
}
