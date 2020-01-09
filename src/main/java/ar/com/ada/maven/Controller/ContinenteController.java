package ar.com.ada.maven.Controller;

import ar.com.ada.maven.View.ContinenteView;
import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dto.ContinenteDTO;

import java.io.IOException;
import java.util.List;

public class ContinenteController {
    private static ContinenteView view = new ContinenteView();
    private static ContinenteDAO continenteDAO = new ContinenteDAO();

    private static void continentList (){
     List<ContinenteDTO> continentes = continenteDAO.findAll();
     view.printAllContinents(continentes);

        try {
            System.out.println("Presione enter para regresar menu");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

        public static void init(){
        boolean reinicia = false;

        while (!reinicia){
          int option = view.continentMenuSelectOption();
            switch (option) {
                case 1:
                    ContinenteController.continentList();
                    break;
                case 2:
                   reinicia = true;
                default:
                    System.out.println(" Usted debe seleccionar una opción valida");


        }



        }
}


