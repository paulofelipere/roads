package com.example.roads.entities;

import jakarta.persistence.*;
import java.util.List;

@SuppressWarnings("unused")
@Entity
public class DefeitosPavimentos {

    @Id
    private String codigo;

    @ManyToMany
    @JoinTable(
            name = "defeitosseguimentos"  // tabela de junção
    )
    private List<CadastroSeguimento> cadastroSeguimento;

    private String tipoDefeito;

    private String numSeguimento;

    @ManyToOne
    private Rodovia rodovia;


    public DefeitosPavimentos() {
        this.codigo = "";
        this.cadastroSeguimento = null;
        this.tipoDefeito = "";
        this.numSeguimento = "";

    }

    public Rodovia getRodovia() {
        return rodovia;
    }

    public void setRodovia(Rodovia rodovia) {
        this.rodovia = rodovia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<CadastroSeguimento> getCadastroSeguimento() {
        return cadastroSeguimento;
    }

    public void setCadastroSeguimento(List<CadastroSeguimento> cadastroSeguimento) {
        this.cadastroSeguimento = cadastroSeguimento;
    }

    public String getTipoDefeito() {
        return tipoDefeito;
    }

    public void setTipoDefeito(String tipoDefeito) {
        this.tipoDefeito = tipoDefeito;
    }

    public String getNumSeguimento() {
        return numSeguimento;
    }

    public void setNumSeguimento(String numSeguimento) {
        this.numSeguimento = numSeguimento;
    }
}