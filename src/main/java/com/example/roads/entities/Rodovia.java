package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rodovias")


    public class Rodovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "tipoRodovia")
    private String tipoRodovia;

    @Column(name = "numRodovia")
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
