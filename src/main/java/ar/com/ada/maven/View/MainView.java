package ar.com.ada.maven.View;


import ar.com.ada.maven.Utils.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainView {

        public int selectOption() {


            System.out.println("Zoos del mundo");
            System.out.println("Seleccione la opción deseada: Continente (1), sino Salir (5)");


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



    }

