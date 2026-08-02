package com.example.roads.services;

import com.example.roads.entities.Afundamento;
import com.example.roads.entities.Exsudacao;
import com.example.roads.repositories.AfundamentoRepository;
import com.example.roads.repositories.ExsudacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfundamentoService {

    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    private ExsudacaoRepository exsudacaoRepository;
    @Autowired
    private AfundamentoRepository afundamentoRepository;

    public AfundamentoService(){
    }

    public List<Afundamento> getAfundamentos(){return afundamentoRepository.findAll();}

    public Afundamento saveAfundamento(Afundamento afundamento){
        calculoAfundamento(afundamento);
        return afundamentoRepository.save(afundamento);
    }

    public Afundamento findAfundamentoById(Long id){
        return afundamentoRepository.findById(id).get();
    }

    public Afundamento updateAfundamento(Afundamento afundamento){
        calculoAfundamento(afundamento);
        return afundamentoRepository.save(afundamento);
    }

    public void calculoAfundamento(Afundamento afundamento){
        double porcetagemExsudacaoKm = afundamento.getPorcetagemAfundamento();

        if (porcetagemExsudacaoKm >= LIMIAR_ALTA){
            afundamento.setCodigoAfundamento("A");
            afundamento.setGravidadeAfundamento(3);
        }else if(porcetagemExsudacaoKm >= LIMIAR_MEDIA){
            afundamento.setCodigoAfundamento("B");
            afundamento.setGravidadeAfundamento(2);
        }else {
            afundamento.setCodigoAfundamento("C");
            afundamento.setGravidadeAfundamento(1);
        }
    }

    public void pesoFoap(Afundamento afundamento){
        String codigo = afundamento.getCodigoAfundamento();
        if ("A".equals(codigo)) {
            afundamento.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            afundamento.setFoap(FATOR_MEDIO);
        } else {
            afundamento.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Afundamento afundamento) {
        int gravidade = afundamento.getGravidadeAfundamento();
        if (gravidade == 3) {
            afundamento.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            afundamento.setPoap(FATOR_MEDIO);
        } else {
            afundamento.setPoap(FATOR_BAIXO);
        }
    }

}
