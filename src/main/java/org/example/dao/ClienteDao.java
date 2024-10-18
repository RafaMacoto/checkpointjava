package org.example.dao;

import org.example.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDao {

    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletar(Long id);
    Cliente buscarPorId(Long id);
    List<Cliente> buscarTodos();
}
