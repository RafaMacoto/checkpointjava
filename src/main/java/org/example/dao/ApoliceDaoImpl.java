package org.example.dao;

import org.example.db.DatabaseConfig;
import org.example.model.Apolice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApoliceDaoImpl implements ApoliceDao {

    @Override
    public void salvar(Apolice apolice) {
        String sql = "INSERT INTO apolice (numero, validade) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, apolice.getNumero());
            stmt.setDate(2, Date.valueOf(apolice.getValidade()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Apolice apolice) {
        String sql = "UPDATE apolice SET numero=?, validade=? WHERE id=?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, apolice.getNumero());
            stmt.setDate(2, Date.valueOf(apolice.getValidade()));
            stmt.setLong(3, apolice.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM apolice WHERE id=?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Apolice buscarPorId(Long id) {
        String sql = "SELECT * FROM apolice WHERE id=?";
        Apolice apolice = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                apolice = new Apolice(
                        rs.getLong("id"),
                        rs.getString("numero"),
                        rs.getDate("validade").toLocalDate()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apolice;
    }

    @Override
    public List<Apolice> buscarTodas() {
        String sql = "SELECT * FROM apolice";
        List<Apolice> apolices = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                apolices.add(new Apolice(
                        rs.getLong("id"),
                        rs.getString("numero"),
                        rs.getDate("validade").toLocalDate()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apolices;
    }
}
