package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Trincas {
    // add as chaves externas
    @Column(name = "quantidadetrincas")
    private int quantidadeTrincas;

    @Column(name = "tipotrinca")
    private String tipoTrinca;

    @Column(name = "porcentagemkm")
    private double porcentagemKM;

    @Column(name = "gravidadetrincas")
    private int gravidadeTrincas;

    @Column(name = "ft")
    private double ft;

    @Column(name = "pt")
    private double pt;
    @Id
    private Long id;

    public Trincas() {
    }

    public int getQuantidadeTrincas() {
        return quantidadeTrincas;
    }

    public void setQuantidadeTrincas(int quantidadeTrincas) {
        this.quantidadeTrincas = quantidadeTrincas;
    }

    public String getTipoTrinca() {
        return tipoTrinca;
    }

    public void setTipoTrinca(String tipoTrinca) {
        this.tipoTrinca = tipoTrinca;
    }

    public double getPorcentagemKM() {
        return porcentagemKM;
    }

    public void setPorcentagemKM(double porcentagemKM) {
        this.porcentagemKM = porcentagemKM;
    }

    public int getGravidadeTrincas() {
        return gravidadeTrincas;
    }

    public void setGravidadeTrincas(int gravidadeTrincas) {
        this.gravidadeTrincas = gravidadeTrincas;
    }

    public double getFt() {
        return ft;
    }

    public void setFt(double ft) {
        this.ft = ft;
    }

    public double getPt() {
        return pt;
    }

    public void setPt(double pt) {
        this.pt = pt;
    }


}
