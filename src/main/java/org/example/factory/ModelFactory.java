package org.example.factory;

import org.example.model.*;

import java.time.LocalDate;

public class ModelFactory {

    private ModelFactory() {
    }

    public static Cliente criarCliente(Long id, String nome, String email, String telefone, String endereco, String cpf) {
        return new Cliente(id, nome, email, telefone, endereco, cpf);
    }

    public static Apolice criarApolice(Long id, String numero, LocalDate validade) {
        return new Apolice(id, numero, validade);
    }

    public static Seguro criarSeguro(Long id, TipoSeguro tipo, double valor, Apolice apolice) {
        return new Seguro(id, tipo, valor, apolice);
    }

    public static Sinistro criarSinistro(Long id, String descricao, Seguro seguro) {
        return new Sinistro(id, descricao, seguro);
    }

    public static Corretor criarCorretor(Long id, String nome, String cpf) {
        return new Corretor(id, nome, cpf);
    }
}
