package org.example.service;

import org.example.dao.ApoliceDao;
import org.example.factory.DaoFactory;
import org.example.model.Apolice;

import java.sql.SQLException;
import java.util.List;

public class ApoliceService {

    private final ApoliceDao apoliceDao;

    public ApoliceService() {
        this.apoliceDao = DaoFactory.getApoliceDao();
    }

    public void salvarApolice(Apolice apolice) throws SQLException {
        apoliceDao.salvar(apolice);
    }

    public void atualizarApolice(Apolice apolice) throws SQLException {
        apoliceDao.atualizar(apolice);
    }

    public void deletarApolice(Long id) throws SQLException {
        apoliceDao.deletar(id);
    }

    public Apolice buscarApolicePorId(Long id) throws SQLException {
        return apoliceDao.buscarPorId(id);
    }

    public List<Apolice> buscarTodasApolices() throws SQLException {
        return apoliceDao.buscarTodas();
    }
}
