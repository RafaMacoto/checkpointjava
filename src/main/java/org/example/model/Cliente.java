package org.example.model;

import org.example.exceptions.EmailInvalido;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;
    private List<Apolice> apolices;

    public Cliente(Long id, String nome, String email, String cpf , String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        try {
            if (validarEmail(email)){
                this.email = email;
            }
        } catch (EmailInvalido e) {
            throw new RuntimeException(e);
        }
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.apolices = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Apolice> getApolices() {
        return apolices;
    }

    private boolean validarEmail(String email) throws EmailInvalido {
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && !email.isEmpty() && email.matches(EMAIL_REGEX);
    }

}
