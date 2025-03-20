package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "defeitosPavimentos")
public class DefeitosPavimentos {

    @Id
    @Column(name = "codigo")
    private String codigo;
// add chaves externas
    @ManyToMany
    @JoinColumn(name = "cadastroSeguimento")
    private CadastroSeguimento cadastroSeguimento;

    @Column(name = "tipodefeito")
    private String tipoDefeito;

    @Column(name ="numseguimento")
    private String numSeguimento;


    public DefeitosPavimentos(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
