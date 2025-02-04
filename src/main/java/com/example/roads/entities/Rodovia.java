package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rodovias")


    public class Rodovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRodovia")
    private Long idRodovia;

    @Column(name ="codigo")
    private String codigo;;

    @Column(name= "numSeguimento")
    private int numSeguimento;

    @Column(name= "tipoRodovia")
    private String tipoRodovia;

    @Column(name = "numRodovia")
    private int numRodovia;


    public Rodovia() {

    }

    public Long getIdRodovia() {
        return idRodovia;
    }

    public void setIdRodovia(Long idRodovia) {
        this.idRodovia = idRodovia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumSeguimento() {
        return numSeguimento;
    }

    public void setNumSeguimento(int numSeguimento) {
        this.numSeguimento = numSeguimento;
    }

    public String getTipoRodovia() {
        return tipoRodovia;
    }

    public void setTipoRodovia(String tipoRodovia) {
        this.tipoRodovia = tipoRodovia;
    }

    public int getNumRodovia() {
        return numRodovia;
    }

    public void setNumRodovia(int numRodovia) {
        this.numRodovia = numRodovia;
    }
}
