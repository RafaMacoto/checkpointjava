package org.example.service;

import org.example.dao.SinistroDao;
import org.example.factory.DaoFactory;
import org.example.model.Sinistro;

import java.sql.SQLException;
import java.util.List;

public class SinistroService {

    private final SinistroDao sinistroDao;

    public SinistroService() {
        this.sinistroDao = DaoFactory.getSinistroDao();
    }

    public void salvarSinistro(Sinistro sinistro) throws SQLException {
        sinistroDao.salvar(sinistro);
    }

    public void atualizarSinistro(Sinistro sinistro) throws SQLException {
        sinistroDao.atualizar(sinistro);
    }

    public void deletarSinistro(Long id) throws SQLException {
        sinistroDao.deletar(id);
    }

    public Sinistro buscarSinistroPorId(Long id) throws SQLException {
        return sinistroDao.buscarPorId(id);
    }

    public List<Sinistro> buscarTodosSinistros() throws SQLException {
        return sinistroDao.listarTodos();
    }
}
