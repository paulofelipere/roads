package com.example.roads.dto;

public class IggeResultado {

    private Long seguimentoId;
    private int numSeguimento;
    private double inicioKm;
    private double fimKm;
    private double extensaoKm;
    private double ft;
    private double pt;
    private double ftPt;
    private double foap;
    private double poap;
    private double foapPoap;
    private double fpr;
    private double ppr;
    private double fprPpr;
    private double valorIgge;

    public IggeResultado() {
    }

    public IggeResultado(Long seguimentoId, int numSeguimento, double inicioKm, double fimKm, double extensaoKm,
                         double ft, double pt, double ftPt, double foap, double poap, double foapPoap,
                         double fpr, double ppr, double fprPpr, double valorIgge) {
        this.seguimentoId = seguimentoId;
        this.numSeguimento = numSeguimento;
        this.inicioKm = inicioKm;
        this.fimKm = fimKm;
        this.extensaoKm = extensaoKm;
        this.ft = ft;
        this.pt = pt;
        this.ftPt = ftPt;
        this.foap = foap;
        this.poap = poap;
        this.foapPoap = foapPoap;
        this.fpr = fpr;
        this.ppr = ppr;
        this.fprPpr = fprPpr;
        this.valorIgge = valorIgge;
    }

    public Long getSeguimentoId() {
        return seguimentoId;
    }

    public void setSeguimentoId(Long seguimentoId) {
        this.seguimentoId = seguimentoId;
    }

    public int getNumSeguimento() {
        return numSeguimento;
    }

    public void setNumSeguimento(int numSeguimento) {
        this.numSeguimento = numSeguimento;
    }

    public double getInicioKm() {
        return inicioKm;
    }

    public void setInicioKm(double inicioKm) {
        this.inicioKm = inicioKm;
    }

    public double getFimKm() {
        return fimKm;
    }

    public void setFimKm(double fimKm) {
        this.fimKm = fimKm;
    }

    public double getExtensaoKm() {
        return extensaoKm;
    }

    public void setExtensaoKm(double extensaoKm) {
        this.extensaoKm = extensaoKm;
    }

    public double getFt() {
        return ft;
    }

    public void setFt(double ft) {
        this.ft = ft;
    }

    public double getPt() {
        return pt;
    }

    public void setPt(double pt) {
        this.pt = pt;
    }

    public double getFtPt() {
        return ftPt;
    }

    public void setFtPt(double ftPt) {
        this.ftPt = ftPt;
    }

    public double getFoap() {
        return foap;
    }

    public void setFoap(double foap) {
        this.foap = foap;
    }

    public double getPoap() {
        return poap;
    }

    public void setPoap(double poap) {
        this.poap = poap;
    }

    public double getFoapPoap() {
        return foapPoap;
    }

    public void setFoapPoap(double foapPoap) {
        this.foapPoap = foapPoap;
    }

    public double getFpr() {
        return fpr;
    }

    public void setFpr(double fpr) {
        this.fpr = fpr;
    }

    public double getPpr() {
        return ppr;
    }

    public void setPpr(double ppr) {
        this.ppr = ppr;
    }

    public double getFprPpr() {
        return fprPpr;
    }

    public void setFprPpr(double fprPpr) {
        this.fprPpr = fprPpr;
    }

    public double getValorIgge() {
        return valorIgge;
    }

    public void setValorIgge(double valorIgge) {
        this.valorIgge = valorIgge;
    }
}
