package argentinaPrograma.integrador;

import controllers.ClienteNegocio;
import util.ConectorHibernate;
import vistas.OrdenesVista;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        OrdenesVista vista = new OrdenesVista();

        System.out.println( "--------------" );
        System.out.println("\nAdministrador de Ordenes de Trabajo\n");

        Scanner scan = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            System.out.println("----------");
            System.out.println("Seleccione una opcion: ");
            System.out.println("1- Cargar nueva Orden.");
            System.out.println("2- Listar Ordenes.");
            System.out.println("3- Salir.");
            System.out.print("Opcion: ");
            String opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    vista.alta();
                    break;
                case "2":
                    vista.lista();
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("\nOpcion incorrecta!");
                    break;
            }

            System.out.println("\n--------------\n");
            System.out.println("Programa terminado.");

        }

    }


}
