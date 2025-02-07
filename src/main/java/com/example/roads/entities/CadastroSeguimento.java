package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cadastroSeguimento")
public class CadastroSeguimento {
    @Id // Primary key
    @Column(name = "numSeguimento")
    private int numSeguimento;

    @Column(name ="seguimentoInicial")
    private double seguimentoInicial;

    @Column(name = "seguimentoFinal")
    private double seguimentoFinal;

    @Column(name = "extensaoSeguimento")
    private double extensaoSeguimento;

    @Column(name = "cidade")
    private String cidade;

    public CadastroSeguimento(){

    }

    public int getNumSeguimento() {
        return numSeguimento;
    }

    public void setNumSeguimento(int numSeguimento) {
        this.numSeguimento = numSeguimento;
    }

    public double getSeguimentoInicial() {
        return seguimentoInicial;
    }

    public void setSeguimentoInicial(double seguimentoInicial) {
        this.seguimentoInicial = seguimentoInicial;
    }

    public CadastroSeguimento(int numSeguimento) {
        this.numSeguimento = numSeguimento;
    }

    public double getSeguimentoFinal() {
        return seguimentoFinal;
    }

    public void setSeguimentoFinal(double seguimentoFinal) {
        this.seguimentoFinal = seguimentoFinal;
    }

    public double getExtensaoSeguimento() {
        return extensaoSeguimento;
    }

    public void setExtensaoSeguimento(double extensaoSeguimento) {
        this.extensaoSeguimento = extensaoSeguimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

