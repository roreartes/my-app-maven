package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.EspecieDTO;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.*;
import java.util.ArrayList;

public class EspecieDAO implements Dao <EspecieDTO> {

    private FamiliaDAO familiaDAO = new FamiliaDAO(false);
    private Boolean willCloseConnection = true;

    public EspecieDAO() {
    }

    ;

    public EspecieDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    private EspecieDAO especieDAO = new EspecieDAO(false);

    @Override
    public ArrayList<EspecieDTO> findAll() {
        String sql = "SELECT * FROM Especie";

        ArrayList<EspecieDTO> especieDTOS = new ArrayList<>();

        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                EspecieDTO familia_id = especieDAO.findById(rs.getInt("Familia_id"));
                EspecieDTO especieDTO = new EspecieDTO(rs.getInt("id"), rs.getString("nombreVulgar"),
                        rs.getString("nombreCientifico"), rs.getBoolean("extinto"), familia_id);
                especieDTOS.add(especieDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return especieDTOS;
    }

    @Override
    public EspecieDTO findById(Integer id) {
        String sql = "SELECT * FROM Especie WHERE id = ?";
        EspecieDTO especieDTO = null;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                EspecieDTO familia_id = especieDAO.findById(rs.getInt("Familia_id"));
                EspecieDTO especieDTO1 = new EspecieDTO(rs.getInt("id"), rs.getString("nombreVulgar"),
                        rs.getString("nombreCientifico"), rs.getBoolean("extinto"), familia_id);
            }
            if (willCloseConnection)
                connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return especieDTO;
    }

    @Override
    public Boolean save(EspecieDTO especieDTO) {
        String sql = "INSERT INTO Especie (nombre) VALUES (?)";
        int hasSave = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, especieDTO.getNombre());
            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasSave == 1;
    }

    @Override
    public Boolean update(EspecieDTO especieDTO, Integer id) {
        String sql = "UPDATE Especie set nombre = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, especieDTO.getNombre());
            preparedStatement.setInt(2, id);

            hasUpdate = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();

        }

        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Especie where id = ?";
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


