package com.example.roads.services;

import com.example.roads.entities.Exsudacao;
import com.example.roads.repositories.ExsudacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExsudacaoService {
    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    private ExsudacaoRepository exsudacaoRepository;

    public ExsudacaoService(){

    }

    public List<Exsudacao> getExsudacoes(){return exsudacaoRepository.findAll();}

    public Exsudacao saveExsudacao(Exsudacao exsudacao){
        calculoExsudacao(exsudacao);
        return exsudacaoRepository.save(exsudacao);
    }
    public Exsudacao findExsudacaoById(long id){
        return exsudacaoRepository.findById(id).get();
    }
    public Exsudacao updateExsudacao(Exsudacao exsudacao){
        calculoExsudacao(exsudacao);
        return exsudacaoRepository.save(exsudacao);
    }

    public void calculoExsudacao(Exsudacao exsudacao){
        double porcetagemExsudacaoKm = exsudacao.getPorcetagemExsudacaoKm();

        if (porcetagemExsudacaoKm >= LIMIAR_ALTA){
            exsudacao.setCodigoExsudacao("A");
            exsudacao.setGravidadeExsudacao(3);
        }else if(porcetagemExsudacaoKm >= LIMIAR_MEDIA){
            exsudacao.setCodigoExsudacao("B");
            exsudacao.setGravidadeExsudacao(2);
        }else {
            exsudacao.setCodigoExsudacao("C");
            exsudacao.setGravidadeExsudacao(1);
        }
    }

    public void pesoFoap(Exsudacao exsudacao){
        String codigo = exsudacao.getCodigoExsudacao();
        if ("A".equals(codigo)) {
            exsudacao.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            exsudacao.setFoap(FATOR_MEDIO);
        } else {
            exsudacao.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Exsudacao exsudacao) {
        int gravidade = exsudacao.getGravidadeExsudacao();
        if (gravidade == 3) {
            exsudacao.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            exsudacao.setPoap(FATOR_MEDIO);
        } else {
            exsudacao.setPoap(FATOR_BAIXO);
        }
    }
}