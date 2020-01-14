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
        continents.forEach(c -> System.out.println(" id: " + c.getId() + " nombre" + c.getNombre()));

    }

    public String getNameNewContinent() {
        System.out.println("Usted creará un nuevo continente ");
        System.out.println(" Ingrese el nombre del nuevo continente. Si desea cancelar, no ingrese datos");

        Scanner keyboard2 = ScannerSingleton.getInstance();
        keyboard2.nextLine();

        while (true) {
            try {
                String name = keyboard2.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println(" Usted debe ingresar una opción válida ");
                    name = keyboard2.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                System.out.println("Usted debe ingresar una opción válida");
                keyboard2.nextLine();

            }

        }

    }

    public void showNewContinent(String nuevoContinente ){
        System.out.println( "El continente agregado es " + nuevoContinente);

    }

    public void newContinentCanceled(){
        System.out.println(" Se ha cancelado el proceso de guardado de continente" );
    }

    public void continentAlreadyExists(ContinenteDTO nuevoContinente){
        System.out.println(" Ese continente ya existe " );
    }


}
