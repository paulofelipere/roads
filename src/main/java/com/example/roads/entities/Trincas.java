package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trincas")
public class Trincas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID seguro gerado pelo banco

    @Column(name = "tipotrinca")
    private String tipoTrinca;

    @Column(name = "codigoTrinca")
    private String codigoTrinca;

    @Column(name = "quantidadetrincas")
    private int quantidadeTrincas;

    @Column(name = "porcentagemkm")
    private double porcentagemKm;

    @Column(name = "gravidadetrincas")
    private int gravidadeTrincas;

    @Column(name = "ft")
    private double ft;

    @Column(name = "pt")
    private double pt;


    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Trincas() {
    }

    public String getCodigoTrinca() {
        return codigoTrinca;
    }

    public void setCodigoTrinca(String codigoTrinca) {
        this.codigoTrinca = codigoTrinca;
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoTrinca() { return tipoTrinca; }
    public void setTipoTrinca(String tipoTrinca) { this.tipoTrinca = tipoTrinca; }
    public int getQuantidadeTrincas() { return quantidadeTrincas; }
    public void setQuantidadeTrincas(int quantidadeTrincas) { this.quantidadeTrincas = quantidadeTrincas; }
    public double getPorcentagemKm() { return porcentagemKm; }
    public void setPorcentagemKm(double porcentagemKm) { this.porcentagemKm = porcentagemKm; }
    public int getGravidadeTrincas() { return gravidadeTrincas; }
    public void setGravidadeTrincas(int gravidadeTrincas) { this.gravidadeTrincas = gravidadeTrincas; }
    public double getFt() { return ft; }
    public void setFt(double ft) { this.ft = ft; }
    public double getPt() { return pt; }
    public void setPt(double pt) { this.pt = pt; }
    public CadastroSeguimento getSeguimento() { return seguimento; }
    public void setSeguimento(CadastroSeguimento seguimento) { this.seguimento = seguimento; }



}