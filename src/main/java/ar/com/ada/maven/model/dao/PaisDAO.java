package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ar.com.ada.maven.model.dto.PaisDTO.*;

public class PaisDAO implements Dao<PaisDTO>{

    private Boolean willCloseConnection = true;
    public PaisDAO() {
    }

    public PaisDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    private ContinenteDAO continenteDAO = new ContinenteDAO(false);

    @Override
    public ArrayList<PaisDTO> findAll() {
        String sql = "SELECT * FROM Pais";

        ArrayList<PaisDTO> paises = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                ContinenteDTO continente = continenteDAO.findById(rs.getInt("Continente_id"));
                PaisDTO paisDTO = new PaisDTO(rs.getInt("id"), rs.getInt("iso_cod"), rs.getString("nombre"), continente);
                paises.add(paisDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return paises;
    }

    @Override
    public PaisDTO findById(Integer id) {
        String sql = "SELECT * FROM Pais WHERE id = ?";
        PaisDTO pais = null;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ContinenteDTO continente = continenteDAO.findById(rs.getInt("Continente_id"));
                pais = new PaisDTO(rs.getInt("id"), rs.getInt("iso-cod"), rs.getString("nombre"), continente);
            }
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return pais;
    }

    @Override
    public Boolean save(PaisDTO paisDTO) {
        String sql = "INSERT INTO Pais (nombre) VALUES (?)";
        int hasSave =0;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, paisDTO.getNombre());

            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasSave == 1;
    }

    @Override
    public Boolean update(PaisDTO paisDTO, Integer id) {
        String sql = "UPDATE Pais set nombre = ? where id = ?";
        int hasUpdate = 0;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, paisDTO.getNombre());
            preparedStatement.setInt(2, id);

            hasUpdate= preparedStatement.executeUpdate();

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


      return hasDelete == 1 ;
    }




}
