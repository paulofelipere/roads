package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Exsudacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigoExsudacao")
    private String codigoExsudacao;

    @Column(name = "porcetagemExsudacaoKm")
    private double porcetagemExsudacaoKm;

    @Column(name = "gravidadeExsudacao")
    private int gravidadeExsudacao;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Exsudacao() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoExsudacao() {
        return codigoExsudacao;
    }

    public void setCodigoExsudacao(String codigoExsudacao) {
        this.codigoExsudacao = codigoExsudacao;
    }

    public double getPorcetagemExsudacaoKm() {
        return porcetagemExsudacaoKm;
    }

    public void setProcetagemExsudacaoKm(double procetagemExsudacaoKm) {
        this.porcetagemExsudacaoKm = procetagemExsudacaoKm;
    }

    public double getFoap() {
        return foap;
    }

    public void setFoap(double foap) {
        this.foap = foap;
    }

    public int getGravidadeExsudacao() {
        return gravidadeExsudacao;
    }

    public void setGravidadeExsudacao(int gravidadeExsudacao) {
        this.gravidadeExsudacao = gravidadeExsudacao;
    }

    public void setPorcetagemExsudacaoKm(double porcetagemExsudacaoKm) {
        this.porcetagemExsudacaoKm = porcetagemExsudacaoKm;
    }

    public double getPoap() {
        return poap;
    }

    public void setPoap(double poap) {
        this.poap = poap;
    }

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
    }
}
