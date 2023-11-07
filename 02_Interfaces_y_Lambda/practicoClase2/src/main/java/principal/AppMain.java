package principal;

import java.util.ArrayList;
import java.util.Arrays;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Practico clase 2 - Funciones lambda e interfaces funcionales");
        System.out.println("--------------------");
        System.out.println("Antes de transformar a mayusculas:");

        String[] lista = {"alpha", "Bravo", "CHARLIE", "DeLtA", "42", "#?+"};

        for (String item :
                lista) {
            System.out.println(item);
        }

        ArrayList<String> listaMayuscula = new ArrayList<>();

        InterfaceMayusculas transformar = new InterfaceMayusculas() {
            @Override
            public String pasarAMayusculas(String palabra) {
                return palabra.toUpperCase();
            }
        };

        Arrays.stream(lista).forEach((l) -> {
            listaMayuscula.add(transformar.pasarAMayusculas(l));
        });

        System.out.println("\nDespues:\n ");
        listaMayuscula.forEach(System.out::println);


    }

}
