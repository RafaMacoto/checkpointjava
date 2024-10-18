package org.example.dao;

import org.example.db.DatabaseConfig;
import org.example.exceptions.SinistroAprovado;
import org.example.model.Seguro;
import org.example.model.Sinistro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinistroDaoImpl implements SinistroDao{
    @Override
    public void salvar(Sinistro sinistro) {
        String sql = "INSERT INTO sinistro (id, descricao, aprovado, seguro_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, sinistro.getId());
            stmt.setString(2, sinistro.getDescricao());
            stmt.setBoolean(3, sinistro.isAprovado());
            stmt.setLong(4, sinistro.getSeguro().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sinistro buscarPorId(Long id) {
        String sql = "SELECT * FROM sinistro WHERE id = ?";
        Sinistro sinistro = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Seguro seguro = new Seguro(rs.getLong("seguro_id"), null, 0.0, null);
                sinistro = new Sinistro(
                        rs.getLong("id"),
                        rs.getString("descricao"),
                        seguro
                );

                if (rs.getBoolean("aprovado")) {
                    sinistro.aprovar();
                }
            }

        } catch (SQLException | SinistroAprovado e) {
            e.printStackTrace();
        }

        return sinistro;
    }

    @Override
    public List<Sinistro> listarTodos() {
        List<Sinistro> sinistros = new ArrayList<>();
        String sql = "SELECT * FROM sinistro";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seguro seguro = new Seguro(rs.getLong("seguro_id"), null, 0.0, null);
                Sinistro sinistro = new Sinistro(
                        rs.getLong("id"),
                        rs.getString("descricao"),
                        seguro
                );

                if (rs.getBoolean("aprovado")) {
                    sinistro.aprovar();
                }

                sinistros.add(sinistro);
            }

        } catch (SQLException | SinistroAprovado e) {
            e.printStackTrace();
        }

        return sinistros;
    }

    @Override
    public void atualizar(Sinistro sinistro) {
        String sql = "UPDATE sinistro SET descricao = ?, aprovado = ?, seguro_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sinistro.getDescricao());
            stmt.setBoolean(2, sinistro.isAprovado());
            stmt.setLong(3, sinistro.getSeguro().getId());
            stmt.setLong(4, sinistro.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM sinistro WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
