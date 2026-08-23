package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "igge")
public class Igge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_igge")
    private double valorIgge;

    @Column(name = "conceito")
    private String conceito;

    @OneToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;


    public Igge(){

    }

    public Igge(double valorIgge, String conceito) {
        this.valorIgge = valorIgge;
        this.conceito = conceito;
    }

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
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
