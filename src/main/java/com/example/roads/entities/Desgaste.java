package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Desgaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigoDesgaste")
    private String codigoDesgaste;

    @Column(name = "porcetagemDesgasteKm")
    private double porcetagemDesgasteKm;

    @Column(name = "gravidadeDesgaste")
    private int gravidadeDesgaste;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Desgaste() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoDesgaste() {
        return codigoDesgaste;
    }

    public void setCodigoDesgaste(String codigoDesgaste) {
        this.codigoDesgaste = codigoDesgaste;
    }

    public double getPorcetagemDesgasteKm() {
        return porcetagemDesgasteKm;
    }

    public void setPorcetagemDesgasteKm(double porcetagemDesgasteKm) {
        this.porcetagemDesgasteKm = porcetagemDesgasteKm;
    }

    public int getGravidadeDesgaste() {
        return gravidadeDesgaste;
    }

    public void setGravidadeDesgaste(int gravidadeDesgaste) {
        this.gravidadeDesgaste = gravidadeDesgaste;
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

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
    }
}
