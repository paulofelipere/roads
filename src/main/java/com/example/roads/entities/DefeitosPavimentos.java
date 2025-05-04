package com.example.roads.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "defeitosPavimentos")
public class DefeitosPavimentos {

    @Id
    @Column(name = "codigo")
    private String codigo;

    @ManyToMany
    @JoinTable(
            name = "defeitosseguimentos",
            joinColumns = @JoinColumn(name = "codigo"),
            inverseJoinColumns = @JoinColumn(name = "numSeguimento")
    )
    private List<CadastroSeguimento> cadastroSeguimento;

    @Column(name = "tipodefeito")
    private String tipoDefeito;

    @Column(name = "numseguimento")
    private String numSeguimento;

    public DefeitosPavimentos() {
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