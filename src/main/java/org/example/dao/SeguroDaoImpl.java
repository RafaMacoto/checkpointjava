package org.example.dao;

import org.example.db.DatabaseConfig;
import org.example.model.Seguro;
import org.example.model.TipoSeguro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImpl implements SeguroDao {
    @Override
    public void salvar(Seguro seguro) {
        String sql = "INSERT INTO seguro (id, tipo_seguro, valor, apolice_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, seguro.getId());
            stmt.setString(2, seguro.getTipoSeguro().name());
            stmt.setDouble(3, seguro.getValor());
            stmt.setLong(4, seguro.getApolice().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Seguro buscarPorId(Long id) {
        String sql = "SELECT * FROM seguro WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Seguro(
                        rs.getLong("id"),
                        TipoSeguro.valueOf(rs.getString("tipo_seguro")),
                        rs.getDouble("valor"),
                        null
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Seguro> buscarTodos() {
        List<Seguro> seguros = new ArrayList<>();
        String sql = "SELECT * FROM seguro";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seguros.add(new Seguro(
                        rs.getLong("id"),
                        TipoSeguro.valueOf(rs.getString("tipo_seguro")),
                        rs.getDouble("valor"),
                        null
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seguros;
    }

    @Override
    public void atualizar(Seguro seguro) {
        String sql = "UPDATE seguro SET tipo_seguro = ?, valor = ?, apolice_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, seguro.getTipoSeguro().name());
            stmt.setDouble(2, seguro.getValor());
            stmt.setLong(3, seguro.getApolice().getId());
            stmt.setLong(4, seguro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM seguro WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
