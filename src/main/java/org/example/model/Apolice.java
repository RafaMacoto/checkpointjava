package org.example.model;

import java.time.LocalDate;


public class Apolice {
    private Long id;
    private String numero;
    private LocalDate validade;

    public Apolice(Long id, String numero, LocalDate  validade) {
        this.id = id;
        this.numero = numero;
        this.validade = validade;

    }

    public boolean isValida() {
        LocalDate hoje = LocalDate.now();
        return hoje.isBefore(validade);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
