package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;

public class CiudadDAO implements Dao<CiudadDTO> {

    private Boolean willCloseConnection = true;

    public CiudadDAO() { }

    public CiudadDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    private PaisDAO paisDAO = new PaisDAO(false);

    @Override
    public ArrayList<CiudadDTO> findAll() {
        String sql = "SELECT * FROM Ciudad";
        ArrayList<CiudadDTO> ciudades = new ArrayList<>();


        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                PaisDTO pais = paisDAO.findById(rs.getInt(("Pais_id")));
                CiudadDTO ciudadDTO = new CiudadDTO(rs.getString("nombre"), pais);
                ciudades.add(ciudadDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return ciudades;

    }

    @Override
    public CiudadDTO findById(Integer id) {
        String sql = "SELECT * FROM Ciudad WHERE id = ?";
        CiudadDTO ciudadDTO = null;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                PaisDTO paisDTO = paisDAO.findById(rs.getInt("Pais_id"));
                ciudadDTO = new CiudadDTO(rs.getString("nombre"), paisDTO);
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return ciudadDTO;
    }

    @Override
    public Boolean save(CiudadDTO ciudadDTO) {
        String sql = "INSERT INTO Ciudad (nombre) VALUES (?)";
        int hasSave = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudadDTO.getNombre());

            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasSave == 1;

    }

    @Override
    public Boolean update(CiudadDTO ciudadDTO, Integer id) {
        String sql = "UPDATE Ciudad set nombre = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudadDTO.getNombre());
            preparedStatement.setInt(2, id);


        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasUpdate == 1;


    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Ciudad where id = ?";
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


