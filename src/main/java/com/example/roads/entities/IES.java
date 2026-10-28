package com.example.roads.entities;

import jakarta.persistence.*;

@Entity
public class IES {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_IES")
    private int valorIES;

    @Column(name = "conceito_IES")
    private String conceitoIES;

    @Column(name = "codigo_IES")
    private String codigoIES;

    public IES() {}

    public int getValorIES() {
        return valorIES;
    }

    public void setValorIES(int valorIES) {
        this.valorIES = valorIES;
    }

    public String getCodigoIES() {
        return codigoIES;
    }

    public void setCodigoIES(String codigoIES) {
        this.codigoIES = codigoIES;
    }

    public String getConceitoIES() {
        return conceitoIES;
    }

    public void setConceitoIES(String conceitoIES) {
        this.conceitoIES = conceitoIES;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
