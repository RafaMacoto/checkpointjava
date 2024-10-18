package org.example.service;

import org.example.dao.CorretorDao;
import org.example.factory.DaoFactory;
import org.example.model.Corretor;

import java.sql.SQLException;
import java.util.List;

public class CorretorService {

    private final CorretorDao corretorDao;

    public CorretorService() {
        this.corretorDao = DaoFactory.getCorretorDao();
    }

    public void salvarCorretor(Corretor corretor) throws SQLException {
        corretorDao.salvar(corretor);
    }

    public void atualizarCorretor(Corretor corretor) throws SQLException {
        corretorDao.atualizar(corretor);
    }

    public void deletarCorretor(Long id) throws SQLException {
        corretorDao.deletar(id);
    }

    public Corretor buscarCorretorPorId(Long id) throws SQLException {
        return corretorDao.buscarPorId(id);
    }

    public List<Corretor> buscarTodosCorretores() throws SQLException {
        return corretorDao.listarTodos();
    }
}
