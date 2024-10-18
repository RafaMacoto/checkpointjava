package org.example.dao;

import org.example.model.Seguro;

import java.sql.SQLException;
import java.util.List;

public interface SeguroDao {
    void salvar(Seguro seguro) throws SQLException;
    void atualizar(Seguro seguro) throws SQLException;
    void deletar(Long id) throws SQLException;
    Seguro buscarPorId(Long id) throws SQLException;
    List<Seguro> buscarTodos() throws SQLException;
}
