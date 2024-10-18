package org.example.dao;

import org.example.model.Corretor;

import java.util.List;

public interface CorretorDao {
    void salvar(Corretor corretor);
    Corretor buscarPorId(Long id);
    List<Corretor> listarTodos();
    void atualizar(Corretor corretor);
    void deletar(Long id);
}
