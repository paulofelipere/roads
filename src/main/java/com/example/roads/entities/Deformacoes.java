package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// fazer importação
@Entity
@Table(name = "deformacoes")
public class Deformacoes {

    @Column(name = "quantidade")
    private int quantidade;

    @Id
    @Column(name = "tipodefeito")
    private String tipo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "porcentagemkm")
    private double porcentagem;

    @Column(name = "gravidade")
    private int gravidade;

    @Column(name = "poap")
    private double poap;

    @Column(name = "foap")
    private double foap;

    @Column(name = "igge")
    private double igge;

    public Deformacoes(){

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }

    public double getPoap() {
        return poap;
    }

    public void setPoap(double poap) {
        this.poap = poap;
    }

    public double getFoap() {
        return foap;
    }

    public void setFoap(double foap) {
        this.foap = foap;
    }

    public double getIgge() {
        return igge;
    }

    public void setIgge(double igge) {
        this.igge = igge;
    }
}
