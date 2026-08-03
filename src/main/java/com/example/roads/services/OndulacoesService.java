package com.example.roads.services;

import com.example.roads.entities.Ondulacoes;
import com.example.roads.repositories.OndulacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class OndulacoesService {

    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    OndulacoesRepository ondulacoesRepository;

    public OndulacoesService(){

    }

    public List<Ondulacoes> getOndulacoes(){
        return  ondulacoesRepository.findAll();
    }

    public Ondulacoes saveOndulacoes(Ondulacoes ondulacoes){
        calculoOndulacoes(ondulacoes);
        return ondulacoesRepository.save(ondulacoes);

    }
    public Ondulacoes findOndulacoesById(Long id){
        return  ondulacoesRepository.findById(id).get();
    }

    public Ondulacoes updateOndulacoes(Ondulacoes ondulacoes){
        calculoOndulacoes(ondulacoes);
        return ondulacoesRepository.save(ondulacoes);
    }

    public  void calculoOndulacoes(Ondulacoes ondulacoes){
        double porcetagemOndulacoesKm = ondulacoes.getPorcetagemOnduacoesKm();

        if (porcetagemOndulacoesKm >= LIMIAR_ALTA){
            ondulacoes.setCodigoOndulacao("A");
            ondulacoes.setGravidadeOndulacoes(3);
        }else if(porcetagemOndulacoesKm >= LIMIAR_MEDIA){
            ondulacoes.setCodigoOndulacao("B");
            ondulacoes.setGravidadeOndulacoes(2);
        }else {
            ondulacoes.setCodigoOndulacao("C");
            ondulacoes.setGravidadeOndulacoes(1);
        }

    }

    public void pesoFoap(Ondulacoes ondulacoes){
        String codigo = ondulacoes.getCodigoOndulacao();
        if ("A".equals(codigo)) {
            ondulacoes.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            ondulacoes.setFoap(FATOR_MEDIO);
        } else {
            ondulacoes.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Ondulacoes ondulacoes) {
        int gravidade = ondulacoes.getGravidadeOndulacoes();
        if (gravidade == 3) {
            ondulacoes.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            ondulacoes.setPoap(FATOR_MEDIO);
        } else {
            ondulacoes.setPoap(FATOR_BAIXO);
        }
    }
}
