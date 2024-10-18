package org.example.dao;

import org.example.model.Sinistro;

import java.util.List;

public interface SinistroDao {
    void salvar(Sinistro sinistro);
    Sinistro buscarPorId(Long id);
    List<Sinistro> listarTodos();
    void atualizar(Sinistro sinistro);
    void deletar(Long id);
}
