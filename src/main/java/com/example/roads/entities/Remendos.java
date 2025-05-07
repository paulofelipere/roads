package com.example.roads.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
public class Remendos {
//add chaves externas

    @Column(name = "porcentagemkm")
    private double porcentagemKm;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "gravidade")
    private int gravidade;

    @Column(name ="resultadoiggeremendos")
    private int resultadoIggeRemendos;
    @Id
    private Long id;

    @OneToMany(mappedBy = "remendos", cascade = CascadeType.ALL)
    private List<CadastroSeguimento> seguimentos;

    public Remendos() {
    }

    public double getPorcentagemKm() {
        return porcentagemKm;
    }

    public void setPorcentagemKm(double porcentagemKm) {
        this.porcentagemKm = porcentagemKm;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }

    public int getResultadoIggeRemendos() {
        return resultadoIggeRemendos;
    }

    public void setResultadoIggeRemendos(int resultadoIggeRemendos) {
        this.resultadoIggeRemendos = resultadoIggeRemendos;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
