package ar.com.ada.maven.View;

import ar.com.ada.maven.Utils.ScannerSingleton;
import ar.com.ada.maven.model.dto.ContinenteDTO;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContinenteView {

    public int continentMenuSelectOption() {

        System.out.println("*** Bienvenido al modulo Continente*** \n \t Seleccione una opción: \n" +
                "1) Lista \n 2) Agregar \n 3) Editar \n 4) Eliminar \n 5) Salir ");

        Scanner keyboard = ScannerSingleton.getInstance();

        while (true) {

            try {

                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("La opción ingresada debe ser valida");
                keyboard.next();
            }
        }
    }

    public void printAllContinents(List<ContinenteDTO> continents) {
        System.out.println("Listado de Continentes");
        continents.forEach(c -> System.out.println(" id: " + c.getId() + "Nombre" + c.getNombre()));

    }

}
