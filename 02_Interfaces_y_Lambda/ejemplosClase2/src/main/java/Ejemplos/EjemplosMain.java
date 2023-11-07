package Ejemplos;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class EjemplosMain {

    public static void main( String[] args )
    {
        System.out.println( "Clase 02 - Interfaces y Lambdas" );

        ArrayList <Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        for (Integer i : numeros) {
            if (i == 3)
                System.out.println("Se encontro el 3!");
        }

        System.out.println("otra forma...");
        System.out.println((numeros.contains(3))? "Esta el 3! " : "No esta el 3..." );

        System.out.println("para implementciones\n------------------");

        ClaseImplementa coso = new ClaseImplementa();

        System.out.println(coso.suma(1, 2));

        System.out.println("otra forma");

        InterfaceSuma coso2 = new ClaseImplementa();

        System.out.println(coso2.suma(1,2));

        System.out.println("\n------------\nvamos a clases anonimas");

        InterfaceSuma var1 = new InterfaceSuma() {
            @Override
            public int suma(int num1, int num2) {
                return num1 + num2;
            }
        };
        System.out.println(var1.suma(2,3));

        System.out.println("\n------------\nvamos a lambdas");

        InterfaceSuma var2 = ( x , y) -> (x + y);
        System.out.println(var2.suma(2,3));

        System.out.println("\n------------\nejercicio");
        System.out.println("mostrar en la primera colexion los valores de la misma multiplicadas por si misma");

        for (Integer i : numeros) {
            System.out.println(i*i);

        }
        System.out.println("\nOtra forma");

        numeros.stream().map((x) -> x*x).forEach(System.out::println);

        System.out.println("\n------------\n");

        Function<Integer, Integer> exponente = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        numeros.stream().map(exponente).forEach(System.out::println);
        System.out.println("\n------------\n");

        Function<Integer, Integer> exponentealt = (x) -> x*x;
        numeros.stream().map(exponentealt).forEach(System.out::println);

        System.out.println("\n------------filtrar numeros pares\n");

        numeros.stream().filter((x) -> x%2 == 0).forEach(System.out::println);

        System.out.println("\n------------ej cambiar predicate\n");

        Predicate<Integer> ejPredic = (x) -> x%2 == 0;

        numeros.stream().filter(ejPredic).forEach(System.out::println);

        System.out.println("\n------------hacer una coleccion nde personas con dni\n");

        ArrayList<Persona> personas = new ArrayList<>();

        Persona p1 = new Persona();
        p1.setDni(31276419);
        Persona p2 = new Persona();
        p2.setDni(14875325);
        Persona p3 = new Persona();
        p3.setDni(32541416);
        Persona p4 = new Persona();
        p4.setDni(11425778);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        int dniFiltro = 25000000;

        /*
        for (Persona persona: personas
             ) {
            System.out.println(persona.getDni());
        }
        */

        //deberia devolver los dni mayores a 25 millones
        personas.stream().filter((x)-> x.getDni() > dniFiltro).forEach((z) -> System.out.println(z.getDni()));

    }

}
