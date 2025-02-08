package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rodovias")


    public class Rodovia {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "tiporodovia")
    private String tipoRodovia;

    @Column(name = "numrodovia")
    private int numRodovia;

    public Rodovia() {

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
