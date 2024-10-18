package org.example.dao;

import org.example.model.Apolice;

import java.sql.SQLException;
import java.util.List;

public interface ApoliceDao {
    void salvar(Apolice apolice) throws SQLException;
    void atualizar(Apolice apolice) throws SQLException;
    void deletar(Long id) throws SQLException;
    Apolice buscarPorId(Long id) throws SQLException;
    List<Apolice> buscarTodas() throws SQLException;

}
