package org.example.model;

import org.example.exceptions.SinistroAprovado;

public class Sinistro {
    private Long id;
    private String descricao;
    private boolean aprovado;
    private Seguro seguro;

    public Sinistro(Long id, String descricao, Seguro seguro) {
        this.id = id;
        this.descricao = descricao;
        this.seguro = seguro;
        this.aprovado = false;
    }

    public void aprovar() throws SinistroAprovado {
       if (this.aprovado) {
           throw new SinistroAprovado("Sinistro já aprovado");
       }
       this.aprovado = true;
    }

    public boolean isAprovado() {
        return aprovado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
