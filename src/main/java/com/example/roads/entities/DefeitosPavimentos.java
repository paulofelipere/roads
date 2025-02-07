package com.example.roads.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "defeitosPavimentos")
public class DefeitosPavimentos {

    @Id
    @Column(name = "codigo")
    private String codigo;
// add chaves externas
    public DefeitosPavimentos(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
