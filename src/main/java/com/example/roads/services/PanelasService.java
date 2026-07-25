package com.example.roads.services;

import com.example.roads.entities.Panelas;
import com.example.roads.repositories.PanelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelasService {

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
        if (quantidadeKm >= 5) {
            panelas.setCodigo("A");
           /* panelas.setGravidade(3);*/
            System.out.println("Frequencia Alta!");
        } else if (quantidadeKm > 2 && quantidadeKm < 5) {
            panelas.setCodigo("M");
            /*panelas.setGravidade(2);*/
            System.out.println("Frequencia Média!");
        } else {
            panelas.setCodigo("B");
           /* panelas.setGravidade(1);*/

            System.out.println("Frequencia baixa");
        }
    }

    public void fatorFpr(Panelas panelas) {
        int quantidadeKm = panelas.getQuantidade();
        if (quantidadeKm >= 5) {
            panelas.setGravidade(3);
            System.out.println("Frequencia Alta!");
        } else if (quantidadeKm > 2 && quantidadeKm < 5) {
            panelas.setGravidade(2);
            System.out.println("Frequencia Média!");
        } else {
            panelas.setGravidade(1);
            System.out.println("Frequencia baixa");
        }
    }

   public void pesoPpr(Panelas panelas) {
        int gravidade =  panelas.getGravidade();
       if (gravidade == 3) {
           panelas.setPpr(1);
       } else if (gravidade == 2) {
           panelas.setPpr(0.80);
       } else {
           panelas.setPpr(0.70);
       }
   }
}
