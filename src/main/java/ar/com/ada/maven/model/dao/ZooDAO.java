package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.*;
import java.util.ArrayList;

public class ZooDAO implements Dao<ZooDTO> {

    private CiudadDAO ciudadDAO = new CiudadDAO(false);
    private Boolean willCloseConnection = true;

    public ZooDAO() {
    }

    public ZooDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    private ZooDAO zooDAO = new ZooDAO(false);

    @Override
    public ArrayList<ZooDTO> findAll() {
        String sql = "SELECT * FROM Zoo";

        ArrayList<ZooDTO> zoologicos = new ArrayList<>();

        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CiudadDTO ciudad = ciudadDAO.findById(rs.getInt("Ciudad_id"));
                ZooDTO zooDTO = new ZooDTO(rs.getString("nombre"), rs.getInt("tamañom2"), rs.getInt("presupuesto"), ciudad);
                zoologicos.add(zooDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return zoologicos;


    }

    @Override
    public ZooDTO findById(Integer id) {
        String sql = "SELECT * FROM Zoo WHERE id = ?";
        ZooDTO zoo = null;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                CiudadDTO ciudad = ciudadDAO.findById(rs.getInt("Ciudad_id"));
                ZooDTO zooDTO = new ZooDTO(rs.getString("nombre"), rs.getInt("tamañom2"), rs.getInt("presupuesto"), ciudad);

            }
            if (willCloseConnection)
                connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return zoo;

    }

    @Override
    public Boolean save(ZooDTO zooDTO) {
        String sql = "INSERT INTO Zoo (nombre) VALUES (?)";
        int hasSave = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zooDTO.getNombre());

            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasSave == 1;

    }

    @Override
    public Boolean update(ZooDTO zooDTO, Integer id) {
        String sql = "UPDATE Zoo set nombre = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zooDTO.getNombre());
            preparedStatement.setInt(2, id);

            hasUpdate = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;

    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Pais where id = ?";
        int hasDelete = 0;

        Connection connection = null;

        try {
            connection = ConnectionDB.getConnection();
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



