package org.example.service;

import org.example.dao.ClienteDao;
import org.example.factory.DaoFactory;
import org.example.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private final ClienteDao clienteDao;

    public ClienteService() {
        this.clienteDao = DaoFactory.getClienteDao();
    }

    public void salvarCliente(Cliente cliente) throws SQLException {
        clienteDao.salvar(cliente);
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        clienteDao.atualizar(cliente);
    }

    public void deletarCliente(Long id) throws SQLException {
        clienteDao.deletar(id);
    }

    public Cliente buscarClientePorId(Long id) throws SQLException {
        return clienteDao.buscarPorId(id);
    }

    public List<Cliente> buscarTodosClientes() throws SQLException {
        return clienteDao.buscarTodos();
    }
}
