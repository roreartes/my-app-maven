package ar.com.ada.maven.Controller;

import ar.com.ada.maven.View.ContinenteView;
import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dto.ContinenteDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContinenteController {
    private static ContinenteView view = new ContinenteView();
    private static ContinenteDAO continenteDAO = new ContinenteDAO();

    private static void continentList() {
        List<ContinenteDTO> continentes = continenteDAO.findAll();
        view.printAllContinents(continentes);

        try {
            System.out.println("Presione enter para regresar menu");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void init() {
        boolean reinicia = false;

        while (!reinicia) {
            int option = view.continentMenuSelectOption();
            switch (option) {
                case 1:
                    ContinenteController.continentList();
                    break;
                case 2:
                    ContinenteController.createNewContinent();
                    break;
                case 3:
                    reinicia = true;
                default:
                    System.out.println(" Usted debe seleccionar una opción valida");


            }

        }
    }

    public static void createNewContinent() {
        String nuevoContinente = view.getNameNewContinent();

        if (!nuevoContinente.isEmpty()) {
            ContinenteDTO continenteNuevo = new ContinenteDTO(nuevoContinente);
            ContinenteDTO byName = continenteDAO.findByName(nuevoContinente);

            if (byName == null & continenteNuevo == byName) {
                view.continentAlreadyExists(continenteNuevo);


            } else {
                Boolean saveContinenteNuevo = continenteDAO.save(continenteNuevo);
                if (saveContinenteNuevo)
                    view.showNewContinent(nuevoContinente);
            }
            view.newContinentCanceled();

        }


    }

    public static List <String> buildPaginator(int currentPage, int totalPages) {
        List <String> pages = new ArrayList<>();
        pages.add("Inicio");
        pages.add("[Anterior]");

        for (int i = 1; i <= totalPages; i++ ) {
            if(i == currentPage + 1)
                pages.add("[>" + i + " <]");
            else
                pages.add("[" + i + "]");

        }
        pages.add("[Siguiente]");
        pages.add("[Ultimo]");
        return pages;
    }

    private static void continentListPerPage(){
        int limit = 3, currentPage =  0;
        List<ContinenteDTO> continenteDTOS;
        int numberContinents;
        int totalPages;
        List <String> paginator;
        while (true) {
            continenteDTOS = continenteDAO.findAll(limit, currentPage * limit);
            numberContinents = continenteDAO.getTotalContinents();
            totalPages = (int) Math.ceil((double) numberContinents / limit);
            paginator = buildPaginator(currentPage, totalPages);
            String choice = view.printContinentsPerPage(continenteDTOS, paginator);
            switch (choice) {
                case "i": case "I":
                    currentPage = 0;
                    break;
                case "a": case "A":
                    if(currentPage + 1 > 0)
                        currentPage--;
                    break;
                case "s" : case "S":
                    if (currentPage  + 1 < totalPages) currentPage++;
                    break;
                case "e" : case "E":
                    currentPage = totalPages - 1;
                    break;
                default:

            }

        }
    }
}



