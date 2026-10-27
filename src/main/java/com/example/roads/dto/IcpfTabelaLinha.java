package com.example.roads.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "numeroSeguimento",
        "kmInicio",
        "kmFim",
        "extensaoKm",
        "p",
        "trincas",
        "r",
        "deformacoes",
        "outrosDefeitos",
        "icpf"
})
public class IcpfTabelaLinha {

    private int numeroSeguimento;
    private double kmInicio;
    private double kmFim;
    private double extensaoKm;
    private String p;
    private TrincasDTO trincas;
    private String r;
    private DeformacoesDTO deformacoes;
    private OutrosDefeitosDTO outrosDefeitos;
    private double icpf;

    public IcpfTabelaLinha() {
    }

    public IcpfTabelaLinha(int numeroSeguimento, double kmInicio, double kmFim, double extensaoKm,
                           String p, TrincasDTO trincas, String r,
                           DeformacoesDTO deformacoes, OutrosDefeitosDTO outrosDefeitos, double icpf) {
        this.numeroSeguimento = numeroSeguimento;
        this.kmInicio = kmInicio;
        this.kmFim = kmFim;
        this.extensaoKm = extensaoKm;
        this.p = p;
        this.trincas = trincas;
        this.r = r;
        this.deformacoes = deformacoes;
        this.outrosDefeitos = outrosDefeitos;
        this.icpf = icpf;
    }

    public int getNumeroSeguimento() {
        return numeroSeguimento;
    }

    public void setNumeroSeguimento(int numeroSeguimento) {
        this.numeroSeguimento = numeroSeguimento;
    }

    public double getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(double kmInicio) {
        this.kmInicio = kmInicio;
    }

    public double getKmFim() {
        return kmFim;
    }

    public void setKmFim(double kmFim) {
        this.kmFim = kmFim;
    }

    public double getExtensaoKm() {
        return extensaoKm;
    }

    public void setExtensaoKm(double extensaoKm) {
        this.extensaoKm = extensaoKm;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public TrincasDTO getTrincas() {
        return trincas;
    }

    public void setTrincas(TrincasDTO trincas) {
        this.trincas = trincas;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public DeformacoesDTO getDeformacoes() {
        return deformacoes;
    }

    public void setDeformacoes(DeformacoesDTO deformacoes) {
        this.deformacoes = deformacoes;
    }

    public OutrosDefeitosDTO getOutrosDefeitos() {
        return outrosDefeitos;
    }

    public void setOutrosDefeitos(OutrosDefeitosDTO outrosDefeitos) {
        this.outrosDefeitos = outrosDefeitos;
    }

    public double getIcpf() {
        return icpf;
    }

    public void setIcpf(double icpf) {
        this.icpf = icpf;
    }

    @JsonPropertyOrder({"tr", "tj", "tb"})
    public static class TrincasDTO {

        private String tr;
        private String tj;
        private String tb;

        public TrincasDTO() {
        }

        public TrincasDTO(String tr, String tj, String tb) {
            this.tr = tr;
            this.tj = tj;
            this.tb = tb;
        }

        public String getTr() {
            return tr;
        }

        public void setTr(String tr) {
            this.tr = tr;
        }

        public String getTj() {
            return tj;
        }

        public void setTj(String tj) {
            this.tj = tj;
        }

        public String getTb() {
            return tb;
        }

        public void setTb(String tb) {
            this.tb = tb;
        }
    }

    @JsonPropertyOrder({"af", "o", "d"})
    public static class DeformacoesDTO {

        private String af;
        private String o;
        private String d;

        public DeformacoesDTO() {
        }

        public DeformacoesDTO(String af, String o, String d) {
            this.af = af;
            this.o = o;
            this.d = d;
        }

        public String getAf() {
            return af;
        }

        public void setAf(String af) {
            this.af = af;
        }

        public String getO() {
            return o;
        }

        public void setO(String o) {
            this.o = o;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }
    }

    @JsonPropertyOrder({"ex", "e"})
    public static class OutrosDefeitosDTO {

        private String ex;
        private String e;

        public OutrosDefeitosDTO() {
        }

        public OutrosDefeitosDTO(String ex, String e) {
            this.ex = ex;
            this.e = e;
        }

        public String getEx() {
            return ex;
        }

        public void setEx(String ex) {
            this.ex = ex;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }
    }
}
