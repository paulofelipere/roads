package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Afundamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CodigoAfundamento")
    private String codigoAfundamento;

    @Column(length = 100)
    private String descricaoAfundamento;

    @Column(name = "porcetagemAfundamentoKm")
    private double porcetagemAfundamento;

    @Column(name = "gravidadeAfundamento")
    private int gravidadeAfundamento;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    public Afundamento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoAfundamento() {
        return codigoAfundamento;
    }

    public void setCodigoAfundamento(String codigoAfundamento) {
        this.codigoAfundamento = codigoAfundamento;
    }

    public String getDescricaoAfundamento() {
        return descricaoAfundamento;
    }

    public void setDescricaoAfundamento(String descricaoAfundamento) {
        this.descricaoAfundamento = descricaoAfundamento;
    }

    public double getPorcetagemAfundamento() {
        return porcetagemAfundamento;
    }

    public void setPorcetagemAfundamento(double porcetagemAfundamento) {
        this.porcetagemAfundamento = porcetagemAfundamento;
    }

    public int getGravidadeAfundamento() {
        return gravidadeAfundamento;
    }

    public void setGravidadeAfundamento(int gravidadeAfundamento) {
        this.gravidadeAfundamento = gravidadeAfundamento;
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
