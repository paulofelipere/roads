package com.example.roads.servicies;

import com.example.roads.entities.Rodovia;
import com.example.roads.repositories.RodoviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RodoviaService {

    @Autowired RodoviaRepository rodoviaRepository;

    public RodoviaService(){

    }
    /* Funcao para acessar todas os dados */
    public List<Rodovia> getRodovias() {
        return rodoviaRepository.findAll();
    }

    public Rodovia saveRodovia(Rodovia rodovia) {
        rodoviaRepository.save(rodovia);
        return rodovia;
    }

    public Rodovia deleteRodovia(Rodovia rodovia) {
        rodoviaRepository.delete(rodovia);
        return rodovia;
    }
}