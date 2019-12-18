package ar.com.ada.maven.statements;

import ar.com.ada.maven.model.ConnectionDB;

import java.sql.*;

public class CountryStatements {

   /* public static void listCountries() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String sql = "Select * from Pais";
        Connection conn = ConnectionDB.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("nombre"));
        }

        conn.close();
    }

    public static void insertCountry() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String pais = "Chile";
        Integer continenteId = 2;
        String sql = "insert into Pais (nombre, continente_Id) values (?,?)";

        Connection conn = ConnectionDB.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, pais);
        pst.setInt(2, continenteId);

        int insert = pst.executeUpdate();

        System.out.println(insert);
        conn.close();
    }*/
}
