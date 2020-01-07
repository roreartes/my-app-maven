package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.FamiliaDTO;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.*;
import java.util.ArrayList;

public class FamiliaDAO implements Dao <FamiliaDTO> {

    private Boolean willCloseConnection = true;

    public FamiliaDAO() {
    }

    public FamiliaDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public ArrayList<FamiliaDTO> findAll() {
        String sql = "SELECT * FROM Familia";

        ArrayList<FamiliaDTO> familiaDTOS = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                FamiliaDTO familiaDTO = new FamiliaDTO (rs.getInt("id"), rs.getString("nombre"));
                familiaDTOS.add(familiaDTO);

            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return familiaDTOS;

    }

    @Override
    public FamiliaDTO findById(Integer id) {
        String sql = "Select * from Familia where id = ?";
        FamiliaDTO familiaDTO = null;

               try {
                Connection connection = ConnectionDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next())
                    familiaDTO = new FamiliaDTO(rs.getInt("id"), rs.getString("nombre"));

                if (willCloseConnection)
                    connection.close();



            } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                System.out.println("CONNECTION ERROR: " + e.getMessage());
            }
        return familiaDTO;
        }


        @Override
        public Boolean save(FamiliaDTO familiaDto) {
            String sql = "INSERT INTO Familia (nombre) VALUES (?)";
            int hasSave =0;
            try {
                Connection connection = ConnectionDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, familiaDto.getNombre());

                hasSave = preparedStatement.executeUpdate();
                connection.close();

            } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                System.out.println("CONNECTION ERROR: " + e.getMessage());
            }
            return hasSave == 1;
        }

    @Override
    public Boolean update(FamiliaDTO familiaDTO, Integer id) {
        String sql = "Update Familia set nombre = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familiaDTO.getNombre());
            preparedStatement.setInt(2, id);

            hasUpdate = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Familia WHERE id = ?";
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