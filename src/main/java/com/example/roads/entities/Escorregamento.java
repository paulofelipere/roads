package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Escorregamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigoEscorregamento")
    private String codigoEscorregamento;

    @Column(name = "porcetagemEscorregamentoKm")
    private double porcetagemEscorregamentoKm;

    @Column(name = "gravidadeEscorregamento")
    private int gravidadeEscorregamento;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    public Escorregamento() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoEscorregamento() {
        return codigoEscorregamento;
    }

    public void setCodigoEscorregamento(String codigoEscorregamento) {
        this.codigoEscorregamento = codigoEscorregamento;
    }

    public int getGravidadeEscorregamento() {
        return gravidadeEscorregamento;
    }

    public void setGravidadeEscorregamento(int gravidadeEscorregamento) {
        this.gravidadeEscorregamento = gravidadeEscorregamento;
    }

    public double getPorcetagemEscorregamentoKm() {
        return porcetagemEscorregamentoKm;
    }

    public void setPorcetagemEscorregamentoKm(double porcetagemEscorregamentoKm) {
        this.porcetagemEscorregamentoKm = porcetagemEscorregamentoKm;
    }

    public double getFoap() {
        return foap;
    }

    public void setFoap(double foap) {
        this.foap = foap;
    }

    public double getPoap() {
        return poap;
    }

    public void setPoap(double poap) {
        this.poap = poap;
    }
}
