package com.example.roads.services;

import com.example.roads.entities.Desgaste;
import com.example.roads.repositories.DesgasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesgasteService {

    private static final double LIMIAR_ALTA = 0.50;
    private static final double LIMIAR_MEDIA = 0.10;
    private static final double FATOR_ALTO = 0.65;
    private static final double FATOR_MEDIO = 0.45;
    private static final double FATOR_BAIXO = 0.30;

    @Autowired
    private DesgasteRepository desgasteRepository;

    public  DesgasteService()
    {}

    public List<Desgaste> findAll()
    {
        return desgasteRepository.findAll();
    }

    public Desgaste saveDesgaste(Desgaste desgaste){
        calculoDesgaste(desgaste);
        return desgasteRepository.save(desgaste);
    }

    public Desgaste findDesgasteById(long id) {
        return desgasteRepository.findById(id).get();
    }

    public  Desgaste updateDesgaste(Desgaste desgaste){
        calculoDesgaste(desgaste);
        return desgasteRepository.save(desgaste);
    }

    public void calculoDesgaste(Desgaste desgaste){
        double porcetagemExsudacaoKm = desgaste.getPorcetagemDesgasteKm();

        if (porcetagemExsudacaoKm >= LIMIAR_ALTA){
            desgaste.setCodigoDesgaste("A");
            desgaste.setGravidadeDesgaste(3);
        }else if(porcetagemExsudacaoKm >= LIMIAR_MEDIA){
            desgaste.setCodigoDesgaste("B");
            desgaste.setGravidadeDesgaste(2);
        }else {
            desgaste.setCodigoDesgaste("C");
            desgaste.setGravidadeDesgaste(1);
        }
    }

    public void pesoFoap(Desgaste desgaste){
        String codigo = desgaste.getCodigoDesgaste();
        if ("A".equals(codigo)) {
            desgaste.setFoap(FATOR_ALTO);
        } else if ("M".equals(codigo)) {
            desgaste.setFoap(FATOR_MEDIO);
        } else {
            desgaste.setFoap(FATOR_BAIXO);
        }
    }

    private void calculoPoap(Desgaste desgaste) {
        int gravidade = desgaste.getGravidadeDesgaste();
        if (gravidade == 3) {
            desgaste.setPoap(FATOR_ALTO);
        } else if (gravidade == 2) {
            desgaste.setPoap(FATOR_MEDIO);
        } else {
            desgaste.setPoap(FATOR_BAIXO);
        }
    }


}
