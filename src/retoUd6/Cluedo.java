package retoUd6;

import java.util.Scanner;

public class Cluedo {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String personajes[] = { "Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco" };

        String armasPersonajes[] = { "Bate", "Pistola", "Candelabro", "Cuchillo",
                "Cuerda", "hacha", "Pesa", "Veneno", "Trofeo" };

        String lugares_Habitaciones[] = { "Casa de invitados", "Teatro", "Spa", "Observatorio", "Comedor", "Terraza",
                "Salón", "Cocina", "Vestíbulo" };

        menuJuego(personajes, armasPersonajes, lugares_Habitaciones);

        menuAñadir();

        int respuesta = scn.nextInt();

        switch (respuesta) {
            case 1:
                System.out.println("¿Cuantos personajes quieres añadir?");
                break;

            case 2:
                System.out.println("¿Que arma quieres añadir?");
                break;

            case 3:

                System.out.println("¿Cual es el lugar o habitacion que quieres añadir?");

                break;

            case 4:

                break;

            default:
                break;
        }

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
}
