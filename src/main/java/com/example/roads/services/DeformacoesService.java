package com.example.roads.services;

import com.example.roads.entities.Deformacoes;
import com.example.roads.entities.Exsudacao;
import com.example.roads.repositories.DeformacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeformacoesService {

    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    private DeformacoesRepository deformacoesRepository;

    public DeformacoesService(){

    }

    public List<Deformacoes> getDeformacoes() {return deformacoesRepository.findAll();}

    public Deformacoes saveDeformacoes(Deformacoes deformacoes){
        calculoDeformacoes(deformacoes);
        return deformacoesRepository.save(deformacoes);
    }

    public Deformacoes findDeformacoesById(long id){
        return deformacoesRepository.findById(id).get();}

    public Deformacoes updateDeformacoes(Deformacoes deformacoes){
        calculoDeformacoes(deformacoes);
        return deformacoesRepository.save(deformacoes);
    }

    public void calculoDeformacoes(Deformacoes deformacoes){
        double porcetagemExsudacaoKm = deformacoes.getPorcentagemKm();

        if (porcetagemExsudacaoKm >= LIMIAR_ALTA){
            deformacoes.setCodigo("A");
            deformacoes.setGravidade(3);
        }else if(porcetagemExsudacaoKm >= LIMIAR_MEDIA){
            deformacoes.setCodigo("B");
            deformacoes.setGravidade(2);
        }else {
            deformacoes.setCodigo("C");
            deformacoes.setGravidade(1);
        }
    }

    public void pesoFoap(Deformacoes deformacoes){
        String codigo = deformacoes.getCodigo();
        if ("A".equals(codigo)) {
            deformacoes.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            deformacoes.setFoap(FATOR_MEDIO);
        } else {
            deformacoes.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Deformacoes deformacoes) {
        int gravidade = deformacoes.getGravidade();
        if (gravidade == 3) {
            deformacoes.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            deformacoes.setPoap(FATOR_MEDIO);
        } else {
            deformacoes.setPoap(FATOR_BAIXO);
        }
    }

}
