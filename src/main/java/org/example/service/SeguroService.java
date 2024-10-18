package org.example.service;

import org.example.dao.SeguroDao;
import org.example.factory.DaoFactory;
import org.example.model.Seguro;

import java.sql.SQLException;
import java.util.List;

public class SeguroService {
    private final SeguroDao seguroDao;

    public SeguroService() {
        this.seguroDao = DaoFactory.getSeguroDao();
    }

    public void salvarSeguro(Seguro seguro) throws SQLException {
        seguroDao.salvar(seguro);
    }

    public void atualizarSeguro(Seguro seguro) throws SQLException {
        seguroDao.atualizar(seguro);
    }

    public void deletarSeguro(Long id) throws SQLException {
        seguroDao.deletar(id);
    }

    public Seguro buscarSeguroPorId(Long id) throws SQLException {
        return seguroDao.buscarPorId(id);
    }

    public List<Seguro> buscarTodosSeguros() throws SQLException {
        return seguroDao.buscarTodos();
    }
}
