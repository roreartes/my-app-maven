package ar.com.ada.maven.Controller;

import ar.com.ada.maven.View.MainView;

public class MainController {

    private static MainView view = new MainView();

    public static void run (){
        boolean varFinal  = false;

        while (!varFinal) {
            int option = view.selectOption();
            switch (option){
                case 1:
                    ContinenteController.init();
                    break;
                case 2:
                    varFinal = true;
                default:
                    System.out.println(" Usted debe seleccionar una opción válida" );


            }
        }

    }
}
