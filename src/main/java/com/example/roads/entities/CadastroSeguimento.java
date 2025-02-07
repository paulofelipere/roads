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









}
