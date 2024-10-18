package org.example.model;

public class Seguro {
    private Long id;
    private TipoSeguro tipoSeguro;
    private double valor;
    private Apolice apolice;

    public Seguro(Long id, TipoSeguro tipoSeguro, double valor, Apolice apolice) {
        this.id = id;
        this.tipoSeguro = tipoSeguro;
        this.valor = valor;
        this.apolice = apolice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Apolice getApolice() {
        return apolice;
    }

    public void setApolice(Apolice apolice) {
        this.apolice = apolice;
    }

    private double valorAnualSemDesconto(){
        return this.valor * 12;
    }

    public double getValorAnual(){
        return this.valorAnualSemDesconto() - (this.valorAnualSemDesconto() * 0.10);
    }
}
