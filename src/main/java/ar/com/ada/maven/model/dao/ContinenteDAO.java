package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.ContinenteDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinenteDAO implements Dao<ContinenteDTO> {


    private Boolean willCloseConnection = true;
    public ContinenteDAO() {
    }

    public ContinenteDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public List<ContinenteDTO> findAll() {
        String sql = "SELECT * FROM Continente";
        List<ContinenteDTO> continents = new ArrayList<>();

        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ContinenteDTO continente = new ContinenteDTO(rs.getInt("id"), rs.getString("Nombre"));
                continents.add(continente);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continents;
    }


    @Override
    public ContinenteDTO findById(Integer id) {
        String sql = "Select * from Continente where id = ?";
        ContinenteDTO continente = null;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continente = new ContinenteDTO(rs.getInt("id"), rs.getString("nombre")); // mapping

            if (willCloseConnection)
                connection.close();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return continente;
    }

    @Override
    public Boolean save(ContinenteDTO continenteDTO) {
        String sql = "INSERT INTO Continente (nombre) VALUES (?)";
        int hasSave =0;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continenteDTO.getNombre());

           hasSave = preparedStatement.executeUpdate();
           connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());

        }
        return hasSave == 1;
    }

    @Override
    public Boolean update(ContinenteDTO continente, Integer id) {
        String sql = "Update Continente set nombre = ? where id = ?";
        int hasUpdate = 0;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continente.getNombre());
            preparedStatement.setInt(2, id);

            // validacion de actualizacion

            hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasUpdate == 1;
    }


    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Continente WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasDelete == 1;

    }
}



