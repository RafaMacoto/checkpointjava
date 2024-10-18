package org.example.dao;

import org.example.db.DatabaseConfig;
import org.example.model.Corretor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorretorDaoImpl implements CorretorDao {
    @Override
    public void salvar(Corretor corretor) {
        String sql = "INSERT INTO corretor (id, nome, cpf) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, corretor.getId());
            stmt.setString(2, corretor.getNome());
            stmt.setString(3, corretor.getCpf());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Corretor buscarPorId(Long id) {
        String sql = "SELECT * FROM corretor WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Corretor(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Corretor> listarTodos() {
        List<Corretor> corretores = new ArrayList<>();
        String sql = "SELECT * FROM corretor";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                corretores.add(new Corretor(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return corretores;
    }

    @Override
    public void atualizar(Corretor corretor) {
        String sql = "UPDATE corretor SET nome = ?, cpf = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, corretor.getNome());
            stmt.setString(2, corretor.getCpf());
            stmt.setLong(3, corretor.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM corretor WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
