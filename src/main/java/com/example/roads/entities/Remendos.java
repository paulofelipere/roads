package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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


}
