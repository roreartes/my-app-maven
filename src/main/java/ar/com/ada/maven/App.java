package ar.com.ada.maven;

import ar.com.ada.maven.Controller.MainController;
import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dao.PaisDAO;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.statements.CountryStatements;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

       /* ContinenteDAO dao = new ContinenteDAO();
        ContinenteDTO continente = dao.findById(2);
        if(continente != null)
            System.out.println("continente.toString() = " + continente.toString());

        ContinenteDTO continentUpdate = new ContinenteDTO ("America");
        Integer idUpdate = 2;

        Boolean hasUpdate = dao.update(continentUpdate, idUpdate);
        if (hasUpdate)
            System.out.println("Se actualizo el registro " + idUpdate);
        else
            System.out.println("NO se pudo realizar la actualizacion");

        Boolean hasDelete = dao.delete(3);
        if (continente != null)
            System.out.println("continente.toString() = " + continente.toString());

        ContinenteDTO continentSave = new ContinenteDTO ("Argentina");
        Integer idSave = 5;
        Boolean hasSave = dao.save(continentSave);
        if (hasSave)
            System.out.println("Se agrego el registro " + idSave);
        else
            System.out.println("NO se pudo realizar la actualizacion");*/

// findbyid
        /*PaisDAO dao = new PaisDAO();
        PaisDTO paisDTO = dao.findById(2);
        if (paisDTO != null)
            System.out.println("continente.toString() = " + paisDTO.toString());

        // update
        PaisDTO paisUpdate = new PaisDTO ("Chile");
        Integer idUpdate = 2;
        Boolean hasUpdate = dao.update(paisUpdate, idUpdate);
        if (hasUpdate)
            System.out.println("Se actualizo el registro " + idUpdate);
        else
            System.out.println("NO se pudo realizar la actualizacion");
//delete
        Boolean hasDelete = dao.delete(2);
        if (hasDelete)
            System.out.println("Se borró el registro de la tabla");
       else
           System.out.println("No se pudo realizar");


*/
        MainController.run();

    }
        
    }

