package Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClaseMain {

    /*
    EJERCICIO 1
Implemente un método que reciba como parámetro una lista de strings y devuelva una nueva
lista con los strings en mayúscula.
     */

    /*
    EJERCICIO 2
Implementar un método que reciba como parámetro una lista de strings y un entero "n". El
método debe devolver un String que concatene separando por coma y espacio todas las
palabras, en la lista, que tengan más de "n" caracteres.
     */

    public static void main(String[] args) {
        System.out.println("Practico clase 3");

        System.out.println("\nEjercicio 1:");

        List<String> listaInicial = new ArrayList<>();
        listaInicial.add("Jorge");
        listaInicial.add("ana");
        listaInicial.add("Esteban");
        listaInicial.add("Pepe");

        System.out.println("Lista inicial: \n");
        listaInicial.forEach(System.out::println);

        System.out.println("\n----------\n");

        List<String> listaFinal1 = ejercicio1(listaInicial);

        System.out.println("Lista transformada: \n");
        listaFinal1.forEach(System.out::println);

        int n = 4;
        List<String> listaFinal2 = ejercicio2(listaInicial, n);

        System.out.println("Lista transformada y filtrada: \n");
        listaFinal2.forEach(System.out::println);
    }

    public static List<String> ejercicio1 (List<String> lista) {

        ArrayList<String> listaMayuscula = new ArrayList<>();

        InterfaceMayusculas transformar = new InterfaceMayusculas() {
            @Override
            public String pasarAMayusculas(String palabra) {
                return palabra.toUpperCase();
            }
        };

        lista.forEach((l) -> {
            listaMayuscula.add(transformar.pasarAMayusculas(l));
        });

        return listaMayuscula;

    }

    public static List<String> ejercicio2 ( List<String> lista, int cantidad) {

        List<String> resultado = new ArrayList<>();

        lista.stream().filter((x) -> x.length() > cantidad).forEach(resultado::add);

        return (ejercicio1(resultado));

    }
}
