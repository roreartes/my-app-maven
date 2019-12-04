package ar.com.ada.maven;

import ar.com.ada.maven.statements.CountryStatements;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        CountryStatements.listCountries();
        CountryStatements.insertCountry();

    }
}
