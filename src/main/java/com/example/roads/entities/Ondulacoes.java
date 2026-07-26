package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Ondulacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigoOndulacao")
    private String codigoOndulacao;

    @Column(name = "porcetagemOnduacoesKm")
    private double porcetagemOnduacoesKm;

    @Column(name = "gravidadeOndulacoes")
    private int gravidadeOndulacoes;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    public Ondulacoes() {}

    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public String getCodigoOndulacao() {
        return codigoOndulacao;
    }

    public void setCodigoOndulacao(String codigoOndulacao) {
        this.codigoOndulacao = codigoOndulacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPorcetagemOnduacoesKm() {
        return porcetagemOnduacoesKm;
    }

    public void setPorcetagemOnduacoesKm(double porcetagemOnduacoesKm) {
        this.porcetagemOnduacoesKm = porcetagemOnduacoesKm;
    }

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
    }

    public int getGravidadeOndulacoes() {
        return gravidadeOndulacoes;
    }

    public void setGravidadeOndulacoes(int gravidadeOndulacoes) {
        this.gravidadeOndulacoes = gravidadeOndulacoes;
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
