package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "deformacoes")
public class Deformacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // A chave não é mais o "tipodefeito", e sim este ID

    @Column(name = "tipodefeito")
    private String tipoDefeito;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "porcentagemkm")
    private double porcentagemKm;

    @Column(name = "foap")
    private double foap;

    @Column(name = "poap")
    private double poap;

    @Column(name = "gravidade")
    private int gravidade;

    @Column(name = "igge")
    private double igge;

    @ManyToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Deformacoes() {
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoDefeito() { return tipoDefeito; }
    public void setTipoDefeito(String tipoDefeito) { this.tipoDefeito = tipoDefeito; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public double getPorcentagemKm() { return porcentagemKm; }
    public void setPorcentagemKm(double porcentagemKm) { this.porcentagemKm = porcentagemKm; }
    public double getFoap() { return foap; }
    public void setFoap(double foap) { this.foap = foap; }
    public double getPoap() { return poap; }
    public void setPoap(double poap) { this.poap = poap; }
    public int getGravidade() { return gravidade; }
    public void setGravidade(int gravidade) { this.gravidade = gravidade; }
    public double getIgge() { return igge; }
    public void setIgge(double igge) { this.igge = igge; }
    public CadastroSeguimento getSeguimento() { return seguimento; }
    public void setSeguimento(CadastroSeguimento seguimento) { this.seguimento = seguimento; }
}