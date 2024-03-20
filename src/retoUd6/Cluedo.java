package retoUd6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Cluedo {
    public static void main(String[] args) {

        boolean pregunta = true;
        String preguntaContinuada;

        Scanner scn = new Scanner(System.in);

        String personajes[] = { "Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco" };

        String armasPersonajes[] = { "Bate", "Pistola", "Candelabro", "Cuchillo",
                "Cuerda", "hacha", "Pesa", "Veneno", "Trofeo" };

        String lugares_Habitaciones[] = { "Casa de invitados", "Teatro", "Spa", "Observatorio", "Comedor", "Terraza",
                "Salon", "Cocina", "Vestibulo" };

        menuJuego(personajes, armasPersonajes, lugares_Habitaciones);

        menuAñadir();

        int respuesta = scn.nextInt();

        while (pregunta) {

            switch (respuesta) {

                case 1:

                    System.out.println("¿Cuantos personajes quieres añadir?");

                    int numero = scn.nextInt();

                    System.out.println("Introduce los nombres de los personajes: ");

                    actualizarArray(personajes, numero);

                    System.out.println("¿Quieres añadir mas personajes?");

                    preguntaContinuada = scn.next();

                    if (preguntaContinuada.equalsIgnoreCase("Si")) {

                    } else
                        pregunta = false;

                    break;

                case 2:

                    System.out.println("¿Cuantas armas quieres añadir?");

                    int numeroArmas = scn.nextInt();

                    System.out.println("Introduce los nombres de las armas a añadir: ");

                    actualizarArray(armasPersonajes, numeroArmas);

                    System.out.println("¿Quieres añadir mas armas?");

                    preguntaContinuada = scn.next();

                    if (preguntaContinuada.equalsIgnoreCase("Si")) {

                    } else
                        pregunta = false;

                    break;

                case 3:

                    System.out.println("Cuantas habitaciones quieres añadir?");

                    int numeroHB = scn.nextInt();

                    System.out.println("Introduce los nombres de las habitaciones: ");

                    actualizarArray(lugares_Habitaciones, numeroHB);

                    System.out.println("¿Quieres añadir mas personajes?");

                    preguntaContinuada = scn.next();

                    if (preguntaContinuada.equalsIgnoreCase("Si")) {

                    } else
                        pregunta = false;

                    break;

                case 4:

                    System.out.println("Hasta luego ;)");
                    pregunta = false;

                    break;

                default:
                    break;
            }

        }

        scn.close();

    }

    public static void menuJuego(String[] personajes, String[] armasPersonajes, String[] lugares_Habitaciones) {
        System.out.println("Bienvenido al Cluedo, este programa se encargara de barajar las cartas por ti. Juguemos:");

        System.out.println("----------------------");
        System.out.println("Personajes disponibles: ");
        System.out.println("----------------------");

        lectorArrays(personajes);

        System.out.println("Las armas disponibles son: ");
        System.out.println("----------------------");

        lectorArrays(armasPersonajes);

        System.out.println("Los lugares o habitaciones en los que puede haber ocurrido el suceso son: ");
        System.out.println("----------------------");

        lectorArrays(lugares_Habitaciones);
    }

    public static void lectorArrays(String[] e) {

        for (String string : e) {
            System.out.println(string);
        }

        System.out.println("----------------------");

    }

    public static void menuAñadir() {

        System.out.println("¿Quieres añadir algo mas?");
        System.out.println("1. Personaje");
        System.out.println("2. Arma");
        System.out.println("3. Habitacion");
        System.out.println("4. Salir");

    }

    public static String[] actualizarArray(String[] arrayAntiguo, int num) {

        Scanner scn = new Scanner(System.in);

        String[] arrayNuevo = new String[arrayAntiguo.length + num];

        System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);

        for (int i = arrayAntiguo.length; i < arrayAntiguo.length + num; i++) {

            String nombreNuevo = scn.nextLine();

            arrayNuevo[i] = nombreNuevo;
        }

        System.out.println("Nuevo array: " + Arrays.toString(arrayNuevo));

        return arrayNuevo;

    }
}
