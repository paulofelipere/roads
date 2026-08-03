package com.example.roads.services;

import com.example.roads.entities.Escorregamento;
import com.example.roads.repositories.EscorregamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscorregamentoService {

    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    private EscorregamentoRepository escorregamentoRepository;

    public EscorregamentoService(){

    }

   public List<Escorregamento> getEscorregamento(){return escorregamentoRepository.findAll();}

    public Escorregamento saveEscorregamento(Escorregamento escorregamento){
        calculoEscorregamento(escorregamento);
        return escorregamentoRepository.save(escorregamento);
    }

    public Escorregamento findEscorregamentoById(long id){
        return escorregamentoRepository.findById(id).get();
    }

    public Escorregamento updateEscorregamento(Escorregamento escorregamento){
        calculoEscorregamento(escorregamento);
        return escorregamentoRepository.save(escorregamento);
    }

    public void calculoEscorregamento(Escorregamento escorregamento){
        double porcetagemExsudacaoKm = escorregamento.getPorcetagemEscorregamentoKm();

        if (porcetagemExsudacaoKm >= LIMIAR_ALTA){
            escorregamento.setCodigoEscorregamento("A");
            escorregamento.setGravidadeEscorregamento(3);
        }else if(porcetagemExsudacaoKm >= LIMIAR_MEDIA){
            escorregamento.setCodigoEscorregamento("B");
            escorregamento.setGravidadeEscorregamento(2);
        }else {
            escorregamento.setCodigoEscorregamento("C");
            escorregamento.setGravidadeEscorregamento(1);
        }
    }

    public void pesoFoap(Escorregamento escorregamento){
        String codigo = escorregamento.getCodigoEscorregamento();
        if ("A".equals(codigo)) {
            escorregamento.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            escorregamento.setFoap(FATOR_MEDIO);
        } else {
            escorregamento.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Escorregamento escorregamento) {
        int gravidade = escorregamento.getGravidadeEscorregamento();
        if (gravidade == 3) {
            escorregamento.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            escorregamento.setPoap(FATOR_MEDIO);
        } else {
            escorregamento.setPoap(FATOR_BAIXO);
        }
    }
}
