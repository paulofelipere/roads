package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Panelas {
    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "gravidade")
    private int gravidade;

    public Panelas() {
    }

    public Panelas(String codigo, int quantidade, int gravidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.gravidade = gravidade;
    }

    public void frequenciaPanelas() {
        if (quantidade >= 5) {
            codigo = "A";
            gravidade = 3;
            System.out.println("Frequencia Alta!");
        } else if (quantidade > 2 && quantidade < 5) {
            codigo = "M";
            gravidade = 2;
            System.out.println("Frequencia Média!");
        } else if (quantidade <= 2) {
            codigo = "B";
            gravidade = 1;
            System.out.println("Frequencia baixa");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
}
