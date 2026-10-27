package com.example.roads.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"rodoviaId", "numRodovia", "linhas", "mediaIcpf"})
public class IcpfTabela {

    private Long rodoviaId;
    private Integer numRodovia;
    private List<IcpfTabelaLinha> linhas;
    private double mediaIcpf;

    public IcpfTabela() {
        this.linhas = new ArrayList<>();
    }

    public IcpfTabela(Long rodoviaId, Integer numRodovia, List<IcpfTabelaLinha> linhas) {
        this.rodoviaId = rodoviaId;
        this.numRodovia = numRodovia;
        this.linhas = linhas;
        this.mediaIcpf = calcularMedia(linhas);
    }

    private double calcularMedia(List<IcpfTabelaLinha> linhas) {
        if (linhas == null || linhas.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        int quantidade = 0;
        for (IcpfTabelaLinha linha : linhas) {
            if (linha != null) {
                soma += linha.getIcpf();
                quantidade++;
            }
        }
        if (quantidade == 0) {
            return 0.0;
        }
        return Math.round((soma / quantidade) * 100.0) / 100.0;
    }

    public Long getRodoviaId() {
        return rodoviaId;
    }

    public void setRodoviaId(Long rodoviaId) {
        this.rodoviaId = rodoviaId;
    }

    public Integer getNumRodovia() {
        return numRodovia;
    }

    public void setNumRodovia(Integer numRodovia) {
        this.numRodovia = numRodovia;
    }

    public List<IcpfTabelaLinha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<IcpfTabelaLinha> linhas) {
        this.linhas = linhas;
        this.mediaIcpf = calcularMedia(linhas);
    }

    public double getMediaIcpf() {
        return mediaIcpf;
    }

    public void setMediaIcpf(double mediaIcpf) {
        this.mediaIcpf = mediaIcpf;
    }
}
