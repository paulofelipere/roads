package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Igge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valorIgge")
    private double valorIgge;

    @Column(name = "conceito")
    private String conceito;

    public Igge(){

    }

    public Igge(double valorIgge, String conceito) {
        this.valorIgge = valorIgge;
        this.conceito = conceito;
    }

    public Long getId() {
        return id;
    }

    public double getValorIgge() {
        return valorIgge;
    }

    public String getConceito() {
        return conceito;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorIgge(double valorIgge) {
        this.valorIgge = valorIgge;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }
}
