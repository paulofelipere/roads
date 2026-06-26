package com.example.roads.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "icpf")
public class Icpf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_icpf")
    private double valorIcpf;

    @Column(name = "conceito")
    private String conceito;

    @OneToOne
    @JoinColumn(name = "seguimento_id")
    private CadastroSeguimento seguimento;

    public Icpf(){

    }


    public Icpf(double valorIcpf, String conceito) {
        this.valorIcpf = valorIcpf;
        this.conceito = conceito;
    }

    public Long getId() {
        return id;
    }

    public double getValorIcpf() {
        return valorIcpf;
    }

    public String getConceito() {
        return conceito;
    }

    public CadastroSeguimento getSeguimento() {
        return seguimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorIcpf(double valorIcpf) {
        this.valorIcpf = valorIcpf;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }

    public void setSeguimento(CadastroSeguimento seguimento) {
        this.seguimento = seguimento;
    }
}
