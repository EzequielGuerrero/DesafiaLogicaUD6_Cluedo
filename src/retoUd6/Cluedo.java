package retoUd6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Cluedo {

    public static ArrayList<Jugador> arrayJugadores = new ArrayList<>();
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        String personajes[] = { "Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco" };

        String armasPersonajes[] = { "Bate", "Pistola", "Candelabro", "Cuchillo",
                "Cuerda", "hacha", "Pesa", "Veneno", "Trofeo" };

        String lugares_Habitaciones[] = { "Casa de invitados", "Teatro", "Spa", "Observatorio", "Comedor", "Terraza",
                "Salon", "Cocina", "Vestibulo" };

        menuJuego(personajes, armasPersonajes, lugares_Habitaciones);

        menuOpciones(personajes, armasPersonajes, lugares_Habitaciones);

        System.out.println("...Baranjando cartas...");

        generadorDeCartas(personajes, armasPersonajes, lugares_Habitaciones);

        System.out
                .println("Si introduces la clave correcta, puedo mostrarte quien ha sido el culpable, donde y como...");

        String clave = scn.next();

        if (clave.equalsIgnoreCase("Hola")) {

            System.out.println("Cartas ganadoras!!");

            System.out.println(
                    "El culpable ha sido: " + arrayJugadores.toString());

        } else
            System.out.println("Clave incorrecta...");

    }

    private static void menuOpciones(String[] personajes, String[] armasPersonajes,
            String[] lugares_Habitaciones) {

        boolean pregunta = true;

        int respuesta = scn.nextInt();

        String preguntaContinuada;

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

                        pregunta = true;

                    } else
                        pregunta = false;

                    System.out.println("¡Genial, sigamos…!");

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

                    System.out.println("¡Genial, sigamos…!");

                    break;

                case 3:

                    System.out.println("Cuantas habitaciones quieres añadir?");

                    int numeroHB = scn.nextInt();

                    System.out.println("Introduce los nombres de las habitaciones: ");

                    actualizarArray(lugares_Habitaciones, numeroHB);

                    System.out.println("¿Quieres añadir mas habitaciones?");

                    preguntaContinuada = scn.next();

                    if (preguntaContinuada.equalsIgnoreCase("Si")) {

                    } else
                        pregunta = false;

                    System.out.println("¡Genial, sigamos…!");

                    break;

                case 4:

                    System.out.println("Hasta luego ;)");
                    pregunta = false;

                    break;

                default:
                    break;
            }

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

        System.out.println("¿Quieres añadir algo mas?");
        System.out.println("1. Personaje");
        System.out.println("2. Arma");
        System.out.println("3. Habitacion");
        System.out.println("4. Salir");
    }

    public static void lectorArrays(String[] e) {

        for (String string : e) {
            System.out.println(string);
        }

        System.out.println("----------------------");

    }

    public static String[] actualizarArray(String[] arrayAntiguo, int num) {

        String[] arrayNuevo = new String[arrayAntiguo.length + num];

        for (int i = arrayAntiguo.length; i < arrayAntiguo.length + num; i++) {

            String nombreNuevo = scn.next();

            arrayNuevo[i] = nombreNuevo;
        }

        System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);

        System.out.println("Nuevo array: " + Arrays.toString(arrayNuevo));

        return arrayNuevo;

    }

    public static String generadorDeCartas(String[] personajes, String[] armas, String[] habitaciones) {

        try {

            int numeroAleatorioPer = (int) (Math.random() * personajes.length);
            int numeroAleatorioAr = (int) (Math.random() * armas.length);
            int numeroAleatorioLug = (int) (Math.random() * habitaciones.length);

            System.out.println(numeroAleatorioPer + "\n" + numeroAleatorioAr + "\n" + numeroAleatorioLug);

            String personjeAleatorio = personajes[numeroAleatorioPer];
            String armaAleatorio = armas[numeroAleatorioAr];
            String lugaresAlt = habitaciones[numeroAleatorioLug];

            arrayJugadores.add(new Jugador(personjeAleatorio, armaAleatorio, lugaresAlt, new Date()));

            System.out.println("Barajado de cartas realizado con exito!!");

        } catch (Exception e) {

            System.out.println("No se han podido generar las cartas...");

        }
        return arrayJugadores.toString();

    }
}
