package com.example.roads.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rodovias")
public class Rodovia {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "tiporodovia")
    private String tipoRodovia;

    @OneToMany(mappedBy = "rodovia", cascade = CascadeType.ALL)
    private List<CadastroSeguimento> seguimentos;

    @Column(name = "numrodovia")
    private int numRodovia;

    @Column(name = "vmd")
    private int vmd;


    public Rodovia(long id) {
        this.id = id;
        this.tipoRodovia = "";
        this.seguimentos = new ArrayList<CadastroSeguimento>();
        this.numRodovia = 0;
        this.vmd = 0;
    }

    public int getVmd() {
        return vmd;
    }

    public void setVmd(int vmd) {
        this.vmd = vmd;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CadastroSeguimento> getSeguimentos() {
        return seguimentos;
    }

    public void setSeguimentos(List<CadastroSeguimento> seguimentos) {
        this.seguimentos = seguimentos;
    }
}