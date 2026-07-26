package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "panelas")
public class Panelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // A chave não é mais o "codigo", e sim este ID

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "gravidade")
    private int gravidade;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "ppr")
    private double ppr;

    @Column(name = "fpr")
    private double fpr;

    @ManyToOne
    @JoinColumn(name = "seguimento_id") // Aponta para o ID do CadastroSeguimento
    private CadastroSeguimento seguimento;

    public Panelas() {
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getGravidade() { return gravidade; }
    public void setGravidade(int gravidade) { this.gravidade = gravidade; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public double getPpr() { return ppr; }
    public void setPpr(double ppr) { this.ppr = ppr; }
    public double getFpr() { return fpr; }
    public void setFpr(double fpr) { this.fpr = fpr; }
    public CadastroSeguimento getSeguimento() { return seguimento; }
    public void setSeguimento(CadastroSeguimento seguimento) { this.seguimento = seguimento; }


}