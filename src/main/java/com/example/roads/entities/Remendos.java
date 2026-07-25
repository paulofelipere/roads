package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "remendos")
public class Remendos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_remendos")
    private String codigoRemendos;

    @Column(name = "porcentagemkm")
    private double porcentagemKm;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "gravidade")
    private int gravidade;

    @Column(name = "ppr")
    private double ppr;

    @Column(name ="resultadoiggeremendos")
    private int resultadoIggeRemendos;

    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Remendos() {
        this.porcentagemKm = 0;
        this.quantidade = 0;
        this.gravidade = 0;
        this.resultadoIggeRemendos = 0;
    }

    public String getCodigoRemendos() {
        return codigoRemendos;
    }

    public void setCodigoRemendos(String codigoRemendos) {
        this.codigoRemendos = codigoRemendos;
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

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getPpr() {
        return ppr;
    }

    public void setPpr(double ppr) {
        this.ppr = ppr;
    }
}
