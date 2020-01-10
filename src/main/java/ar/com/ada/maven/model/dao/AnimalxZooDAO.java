package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.ConnectionDB;
import ar.com.ada.maven.model.dto.AnimalDTO;
import ar.com.ada.maven.model.dto.AnimalxZoo;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.*;
import java.util.ArrayList;


public class AnimalxZooDAO implements Dao <AnimalxZoo> {

    private AnimalxZooDAO animalxZooDAO = new AnimalxZooDAO(false);
    private Boolean willCloseConnection = true;

    public AnimalxZooDAO(boolean b) {
    }


    public AnimalxZooDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }


    @Override
    public ArrayList<AnimalxZoo> findAll() {
        String sql = "SELECT * FROM AnimalxZoo";
        ArrayList<AnimalxZoo> animalxZoos = new ArrayList<>();

        try {
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                AnimalxZoo zooId = animalxZooDAO.findById(rs.getInt("zooID"));
                AnimalxZoo animalID = animalxZooDAO.findById(rs.getInt("animalID"));
                AnimalxZoo animalxZoo = new AnimalxZoo(rs.getInt("id"), zooId, animalID);
                animalxZoos.add(animalxZoo);
            }
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return animalxZoos;

    }

    @Override
    public AnimalxZoo findById(Integer id) {
        String sql = "SELECT * FROM AnimalxZoo WHERE id = ?";
        AnimalxZoo animalxZoo = null;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            AnimalxZoo zooId = animalxZooDAO.findById(rs.getInt("zooID"));
            AnimalxZoo animalID = animalxZooDAO.findById(rs.getInt("animalID"));
            AnimalxZoo animalxZoo1 = new AnimalxZoo(rs.getInt("id"), zooId, animalID);

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return animalxZoo;
    }

    @Override
    public Boolean save(AnimalDTO animalDTO) {
        String sql = "INSERT INTO AnimalxZoo (zoo) VALUES (?)";
        int hasSave = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalDTO.getId());

            hasSave = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasSave == 1;


    }

    @Override
    public Boolean update(AnimalDTO animalDTO, ZooDTO zooDTO, Integer id) {
        String sql = "UPDATE AnimalxZoo set Animal_id = ? where id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalDTO.getId());
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





/* *//*


    */
/**//*



*/
