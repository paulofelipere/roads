package com.example.roads.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cadastroseguimento")
public class CadastroSeguimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária verdadeira para o banco de dados

    @Column(name = "numseguimento")
    private int numSeguimento; // O número anotado no campo

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "seguimentoinicial")
    private double seguimentoInicial;

    @Column(name = "seguimentofinal")
    private double seguimentoFinal;

    @Column(name = "extensaoseguimento")
    private double extensaoSeguimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacadastro")
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "rodovia_id")
    private Rodovia rodovia;

    // --- RELACIONAMENTOS CORRIGIDOS (1 Seguimento tem VÁRIOS defeitos) ---

    @OneToMany(mappedBy = "seguimento", cascade = CascadeType.ALL)
    private List<Trincas> trincas = new ArrayList<>();

    @OneToMany(mappedBy = "seguimento", cascade = CascadeType.ALL)
    private List<Remendos> remendos = new ArrayList<>();

    @OneToMany(mappedBy = "seguimento", cascade = CascadeType.ALL)
    private List<Panelas> panelas = new ArrayList<>();

    @OneToMany(mappedBy = "seguimento", cascade = CascadeType.ALL)
    private List<Deformacoes> deformacoes = new ArrayList<>();

    public CadastroSeguimento() {
    }

    public void calcularExtensãoSeguimento() {
        this.extensaoSeguimento = this.seguimentoFinal - this.seguimentoInicial;
    }

    // --- Getters e Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumSeguimento() { return numSeguimento; }
    public void setNumSeguimento(int numSeguimento) { this.numSeguimento = numSeguimento; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public double getSeguimentoInicial() { return seguimentoInicial; }
    public void setSeguimentoInicial(double seguimentoInicial) { this.seguimentoInicial = seguimentoInicial; }
    public double getSeguimentoFinal() { return seguimentoFinal; }
    public void setSeguimentoFinal(double seguimentoFinal) { this.seguimentoFinal = seguimentoFinal; }
    public double getExtensaoSeguimento() { return extensaoSeguimento; }
    public void setExtensaoSeguimento(double extensaoSeguimento) { this.extensaoSeguimento = extensaoSeguimento; }
    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }
    public Rodovia getRodovia() { return rodovia; }
    public void setRodovia(Rodovia rodovia) { this.rodovia = rodovia; }
    public List<Trincas> getTrincas() { return trincas; }
    public void setTrincas(List<Trincas> trincas) { this.trincas = trincas; }
    public List<Remendos> getRemendos() { return remendos; }
    public void setRemendos(List<Remendos> remendos) { this.remendos = remendos; }
    public List<Panelas> getPanelas() { return panelas; }
    public void setPanelas(List<Panelas> panelas) { this.panelas = panelas; }
    public List<Deformacoes> getDeformacoes() { return deformacoes; }
    public void setDeformacoes(List<Deformacoes> deformacoes) { this.deformacoes = deformacoes; }
}