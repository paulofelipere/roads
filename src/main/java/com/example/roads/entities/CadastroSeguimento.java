package com.example.roads.entities;

import jakarta.persistence.*;

import java.util.Date;

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

    @Column(name = "datacadastro")
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "rodovia") // ver isso
    private Rodovia rodovia;

    @ManyToOne
    @JoinColumn(name = "remendos")
    private Remendos remendos;

    @ManyToOne
    @JoinColumn(name = "trincas")
    private Trincas trincas;

    @ManyToOne
    @JoinColumn(name = "deformacoes")
    private Deformacoes deformacoes;


    public CadastroSeguimento(){

    }


    public double extensaoSeguimento(double seguimentoFinal, double seguimentoInicial){
        return seguimentoFinal - seguimentoInicial;
    }

    public Deformacoes getDeformacoes() {
        return deformacoes;
    }

    public void setDeformacoes(Deformacoes deformacoes) {
        this.deformacoes = deformacoes;
    }

    public Trincas getTrincas() {
        return trincas;
    }

    public void setTrincas(Trincas trincas) {
        this.trincas = trincas;
    }

    public Rodovia getRodovia() {
        return rodovia;
    }

    public void setRodovia(Rodovia rodovia) {
        this.rodovia = rodovia;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Remendos getRemendos() {
        return remendos;
    }

    public void setRemendos(Remendos remendos) {
        this.remendos = remendos;
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

    public void calcularExtensãoSeguimento(){
        this.extensaoSeguimento = this.seguimentoFinal - this.seguimentoInicial;
    }
}

