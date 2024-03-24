package retoUd6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        boolean pregunta = true;

        while (pregunta) {

            System.out.println("¿Quieres añadir algo mas?");
            System.out.println("1. Personaje");
            System.out.println("2. Arma");
            System.out.println("3. Habitacion");
            System.out.println("4. Salir");

            int respuesta = scn.nextInt();

            String preguntaContinuada = "";

            if (respuesta >= 1 && respuesta <= 4) {

                switch (respuesta) {

                    case 1:

                        System.out.println("¿Cuantos personajes quieres añadir?");

                        int numero = scn.nextInt();

                        System.out.println("Introduce los nombres de los personajes: ");

                        actualizarArray(personajes, numero);

                        System.out.println("¿Quieres añadir algo mas?");

                        preguntaContinuada = scn.next();

                        if (preguntaContinuada.equalsIgnoreCase("Si")) {

                        } else {

                            System.out.println("¡Genial, sigamos…!" + "\n");
                        }

                        break;

                    case 2:

                        System.out.println("¿Cuantas armas quieres añadir?");

                        int numeroArmas = scn.nextInt();

                        System.out.println("Introduce los nombres de las armas a añadir: ");

                        actualizarArray(armasPersonajes, numeroArmas);

                        System.out.println("¿Quieres añadir algo mas?");

                        preguntaContinuada = scn.next();

                        if (preguntaContinuada.equalsIgnoreCase("Si")) {

                        } else {

                            System.out.println("¡Genial, sigamos…!" + "\n");
                        }

                        break;

                    case 3:

                        System.out.println("Cuantas habitaciones quieres añadir?");

                        int numeroHB = scn.nextInt();

                        System.out.println("Introduce los nombres de las habitaciones: ");

                        actualizarArray(lugares_Habitaciones, numeroHB);

                        System.out.println("¿Quieres añadir algo mas?");

                        preguntaContinuada = scn.next();

                        if (preguntaContinuada.equalsIgnoreCase("Si")) {

                        } else {

                            System.out.println("¡Genial, sigamos…!" + "\n");
                        }
                        break;

                    case 4:

                        System.out.println("Hasta luego ;)" + "\n");

                        pregunta = false;

                        break;

                }

                if (preguntaContinuada != null && preguntaContinuada.equalsIgnoreCase("No")) {
                    pregunta = false;
                } else {
                    System.out.println("¡Genial, sigamos…!" + "\n");
                }

            } else {
                System.out.println("Numero incorrecto, introduce un numero valido dentro de las opciones del menu.");

                pregunta = true;
            }

        }

        System.out.println("...Baranjando cartas..." + "\n");

        // Metodo que genera el culpable del juego gracias a su lógica aleatoria.

        generadorDeCartas(personajes, armasPersonajes, lugares_Habitaciones);

        // Metodo que pregunta la contraseña y si es la correcta muestra al culpable.

        preguntaContraseña();

        // Imprime el archivo -txt con los culpables que se han ido generando a cada
        // vuelta.

        imprimirArchivo();

    }

    // Metodo que utilizo para imprimir el archivo con la informacion dentro del
    // ArrayList.

    private static void imprimirArchivo() {

        String rutaArchivos = System.getProperty("user.dir");

        try {

            BufferedWriter miBuffer = new BufferedWriter(
                    new FileWriter(rutaArchivos + File.separator + "RegistroCulpables.txt", true));

            miBuffer.write(arrayJugadores.toString());

            miBuffer.close();

            System.out.println("Datos guardados!!" + "\n" + "Hasta la vista!!");

        } catch (IOException e) {
            System.out.println("No se han podido guardar los jugadores");

        }

    }

    // Metodo que compara si el valor del String introducido por el usuario equivale
    // al guardado.

    private static void preguntaContraseña() {
        System.out.println("Si introduces la clave correcta, puedo enseñarte quien ha sido el culpable...");

        String clave = scn.next();

        if (clave.equalsIgnoreCase("hola")) {

            System.out.println("Clave correcta,el culpable ha sido" + arrayJugadores.toString());
        } else
            System.out.println("Clave incorrecta");
    }

    // Metodo que utiliza un for-each para leer los arrays.

    public static void lectorArrays(String[] e) {

        for (String string : e) {
            System.out.println(string);
        }

        System.out.println("----------------------");

    }

    // Actualiza el array existente por uno nuevo

    public static String[] actualizarArray(String[] arrayAntiguo, int num) {

        String[] arrayNuevo = new String[arrayAntiguo.length + num];

        System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);

        for (int i = arrayAntiguo.length; i < arrayAntiguo.length + num; i++) {

            String nombreNuevo = scn.next();
            arrayNuevo[i] = nombreNuevo;
        }

        System.out.println("Nuevo array: " + Arrays.toString(arrayNuevo));

        return arrayNuevo;
    }

    public static String generadorDeCartas(String[] personajes, String[] armas, String[] habitaciones) {

        try {

            int numeroAleatorioPer = (int) (Math.random() * personajes.length);
            int numeroAleatorioAr = (int) (Math.random() * armas.length);
            int numeroAleatorioLug = (int) (Math.random() * habitaciones.length);

            System.out.println(numeroAleatorioPer + "\n" + numeroAleatorioAr + "\n" + numeroAleatorioLug + "\n");

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
