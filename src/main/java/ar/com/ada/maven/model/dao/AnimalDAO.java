package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.AnimalDTO;
import ar.com.ada.maven.model.dto.EspecieDTO;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDAO implements  Dao <AnimalDTO> {

    private AnimalDAO animalDAO = new AnimalDAO(false);
    private Boolean willCloseConnection = true;

    public AnimalDAO(boolean b) {
    };

    public AnimalDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public ArrayList<AnimalDTO> findAll() {
        String sql = "SELECT * FROM Animal";

        ArrayList<AnimalDTO> animalDTOS = new ArrayList<>();

        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                AnimalDTO especieID = animalDAO.findById(rs.getInt("especieID"));
                AnimalDTO paisID = animalDAO.findById(rs.getInt("paisID"));
                AnimalDTO animalDTO = new AnimalDTO(rs.getInt("id"), rs.getNString("sexo"), rs.getDate("fecha_nacimiento"), especieID, paisID);
                animalDTOS.add(animalDTO);

            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());

        }
        return animalDTOS;
    }

    @Override
    public AnimalDTO findById(Integer id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        AnimalDTO animalDTO = null;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            AnimalDTO especieID = animalDAO.findById(rs.getInt("especieID"));
            AnimalDTO paisID = animalDAO.findById(rs.getInt("paisID"));
            AnimalDTO animalDTO1 = new AnimalDTO(rs.getInt("id"), rs.getNString("sexo"), rs.getDate("fecha_nacimiento"), especieID, paisID);

            if (willCloseConnection)
                connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return animalDTO;
    }

    @Override
    public Boolean save(AnimalDTO animalDTO) {
        String sql = "INSERT INTO Animal (sexo, fecha_nacimiento, especieID, paisID) VALUES (?, ?, ?, ?)";
        int hasSave = 0;

        try {
            Connection connection = ConnectionDB.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalDTO.getSexo());

            Date date = new Date(animalDTO.getFecha_nacimiento().getTime());
            preparedStatement.setDate(2, date);

            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasSave == 1;
    }

    @Override
    public Boolean update(AnimalDTO animalDTO, Integer id) {
        String sql = "UPDATE Animal set nombre = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalDTO.getSexo());
            preparedStatement.setInt(2, id);

            hasUpdate = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Animal where id = ?";
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