/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_cristiantercero;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Lab2P2_CristianTercero {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<Ciudad> ciudades = new ArrayList<>();
    static ArrayList<Superheroe> superheroes = new ArrayList<>();
    static ArrayList<String> historial = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n---- SUPERHERO DISPATCH NETWORK ----");
            System.out.println("1. Agregar ciudad");
            System.out.println("2. Agregar superheroe");
            System.out.println("3. Listar");
            System.out.println("4. Modificar villano");
            System.out.println("5. Modificar superheroe");
            System.out.println("6. Eliminar ciudad");
            System.out.println("7. Eliminar superheroe");
            System.out.println("8. Simulacion");
            System.out.println("9. Salir");

            opcion = entero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    agregarCiudad();
                    break;
                case 2:
                    agregarSuperheroe();
                    break;
                case 3:
                    menuListar();
                    break;
                case 4:
                    modificarVillano();
                    break;
                case 5:
                    modificarSuperheroe();
                    break;
                case 6:
                    eliminarCiudad();
                    break;
                case 7:
                    eliminarSuperheroe();
                    break;
                case 8:
                    simulacion();
                    break;
                case 9:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 9);
    }

    public static void agregarCiudad() {

        int id;

        do {
            id = entero("ID: ");
            if (idCiudadExiste(id)) {
                System.out.println("El ID ya existe");
            }

        } while (idCiudadExiste(id));

        System.out.print("Nombre de la ciudad: ");
        String nombre = leer.nextLine();

        boolean vuelo = respuestaBoolean("Se necesita volar para llegar?");

        System.out.print("Nombre del villano: ");
        String villano = leer.nextLine();

        double nivel = nivelValido("Nivel del villano [1-100]: ", 1);

        ciudades.add(new Ciudad(id, nombre, vuelo, villano, nivel));

        System.out.println("Ciudad agregada");
    }

    public static void agregarSuperheroe() {

        int id;

        do {
            id = entero("ID: ");

            if (idSuperheroeExiste(id)) {
                System.out.println("El ID ya existe");
            }

        } while (idSuperheroeExiste(id));

        System.out.print("Apodo: ");
        String apodo = leer.nextLine();

        System.out.print("Nombre civil: ");
        String nombre = leer.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = leer.nextLine();

        boolean vuelo = respuestaBoolean("¿Tiene capacidad de vuelo?");

        int[] habilidades = new int[5];

        for (int i = 0; i < habilidades.length; i++) {
            habilidades[i] = random.nextInt(101);
        }

        double nivel = habilidades[0] * 0.20 + habilidades[1] * 0.15 + habilidades[2] * 0.10 + habilidades[3] * 0.30 + habilidades[4] * 0.25;

        superheroes.add(new Superheroe(
                id, apodo, nombre, descripcion,
                vuelo, habilidades, nivel));

        System.out.println("Superheroe agregado");
        System.out.println("Nivel: " + redondear(nivel) + "%");
    }

    public static void menuListar() {

        System.out.println("1. Ciudades");
        System.out.println("2. Superheroes");
        System.out.println("3. Historial");

        int opcion = entero("Seleccione una opcion: ");

        switch (opcion) {
            case 1:
                listarCiudades();
                break;
            case 2:
                listarSuperheroes();
                break;
            case 3:
                listarHistorial();
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void listarCiudades() {

        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades");
            return;
        }

        for (int i = 0; i < ciudades.size(); i++) {

            Ciudad ciudad = ciudades.get(i);
            String vuelo = "NO";

            if (ciudad.getVuelo()) {
                vuelo = "SI";
            }

            System.out.println((i + 1) + ". " + ciudad.getNombre() + " -- " + vuelo + " -- " + ciudad.getNombreVillano() + " -- "
                    + redondear(ciudad.getNivelVillano()) + "%");
        }
    }

    public static void listarSuperheroes() {

        if (superheroes.isEmpty()) {
            System.out.println("No hay superheroes");
            return;
        }

        for (int i = 0; i < superheroes.size(); i++) {

            Superheroe heroe = superheroes.get(i);
            int[] h = heroe.getHabilidades();

            String nombre = heroe.getNombre();
            String vuelo = "NO";

            if (heroe.getNivel() > 80) {
                nombre = "CLASIFICADO";
            }

            if (heroe.getCapacidadVuelo()) {
                vuelo = "SI";
            }

            System.out.println((i + 1) + ". " + heroe.getApodo() + " -- " + nombre + " -- " + vuelo + " -- " + "{Defensa: " + h[0] + ", Agilidad: " + h[1]
                    + ", Carisma: " + h[2] + ", Inteligencia: " + h[3] + ", Ataque: " + h[4] + "} -- " + redondear(heroe.getNivel()) + "%");
        }
    }

    public static void listarHistorial() {

        if (historial.isEmpty()) {
            System.out.println("No hay simulaciones");
            return;
        }

        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". "
                    + historial.get(i));
        }
    }

    public static void modificarVillano() {

        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades.");
            return;
        }

        listarCiudades();

        int posicion = entero("Seleccione una ciudad: ") - 1;
        if (!posicionCiudadValida(posicion)) {
            System.out.println("Posicion incorrecta");
            return;
        }

        Ciudad ciudad = ciudades.get(posicion);

        System.out.print("Nuevo nombre del villano: ");
        ciudad.setNombreVillano(leer.nextLine());

        ciudad.setNivelVillano(nivelValido("Nuevo nivel [1-100]: ", 1));
        System.out.println("Villano modificado.");
    }

    public static void modificarSuperheroe() {

        if (superheroes.isEmpty()) {
            System.out.println("No hay superheroes");
            return;
        }

        listarSuperheroes();

        int posicion = entero("Seleccione un superheroe: ") - 1;
        if (!posicionSuperheroeValida(posicion)) {
            System.out.println("Posicion incorrecta");
            return;
        }

        Superheroe heroe = superheroes.get(posicion);

        System.out.print("Nuevo apodo: ");
        heroe.setApodo(leer.nextLine());

        System.out.print("Nuevo nombre civil: ");
        heroe.setNombre(leer.nextLine());

        System.out.print("Nueva descripcion: ");
        heroe.setDescripcion(leer.nextLine());

        heroe.setCapacidadVuelo(respuestaBoolean("¿Puede volar?"));
        System.out.println("Superheroe modificado");
    }

    public static void eliminarCiudad() {

        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades");
            return;
        }

        listarCiudades();

        int posicion = entero("Seleccione una ciudad: ") - 1;
        if (!posicionCiudadValida(posicion)) {
            System.out.println("Posicion incorrecta");
            return;
        }

        if (ciudades.get(posicion).getNivelVillano() < 60) {
            ciudades.remove(posicion);
            System.out.println("Ciudad eliminada");
        } else {
            System.out.println(
                    "No se puede eliminar, El villano tiene nivel 60 o mayor");
        }
    }

    public static void eliminarSuperheroe() {

        if (superheroes.isEmpty()) {
            System.out.println("No hay superheroes");
            return;
        }

        listarSuperheroes();

        int posicion = entero("Seleccione un superheroe: ") - 1;
        if (!posicionSuperheroeValida(posicion)) {
            System.out.println("Posicion incorrecta");
            return;
        }

        if (superheroes.get(posicion).getNivel() <= 80) {
            superheroes.remove(posicion);
            System.out.println("Superheroe eliminado");
        } else {
            System.out.println("No se puede eliminar, porque el nivel es mayor a 80");
        }
    }

    public static void simulacion() {

        if (ciudades.isEmpty() || superheroes.isEmpty()) {
            System.out.println("Debe registrar una ciudad y un superheroe");
            return;
        }

        listarSuperheroes();

        int posicionHeroe = entero("Seleccione un superheroe: ") - 1;
        if (!posicionSuperheroeValida(posicionHeroe)) {
            System.out.println("Superheroe incorrecto");
            return;
        }

        listarCiudades();

        int posicionCiudad = entero("Seleccione una ciudad: ") - 1;
        if (!posicionCiudadValida(posicionCiudad)) {
            System.out.println("Ciudad incorrecta");
            return;
        }

        Superheroe heroe = superheroes.get(posicionHeroe);
        Ciudad ciudad = ciudades.get(posicionCiudad);

        if (ciudad.getVuelo() && !heroe.getCapacidadVuelo()) {
            derrota(ciudad, heroe);
            aumentarNivelVillano(ciudad);
            System.out.println("Derrota. El superheroe no puede volar.");

        } else if (heroe.getNivel() > ciudad.getNivelVillano()) {
            historial.add("Ciudad: " + ciudad.getNombre() + " - Villano: " + ciudad.getNombreVillano() + " - Derrotado Por: " + heroe.getApodo());

            ciudades.remove(posicionCiudad);
            System.out.println("Victoria. La ciudad fue liberada.");

        } else {
            derrota(ciudad, heroe);
            aumentarNivelVillano(ciudad);
            System.out.println("El villano gano");
        }
    }

    public static void derrota(Ciudad ciudad, Superheroe heroe) {
        historial.add("Ciudad: " + ciudad.getNombre() + " - Superheroe: " + heroe.getApodo() + " - Derrotado Por: " + ciudad.getNombreVillano());
    }

    public static void aumentarNivelVillano(Ciudad ciudad) {
        double nuevoNivel = ciudad.getNivelVillano() * 1.10;
        if (nuevoNivel > 100) {
            nuevoNivel = 100;
        }

        ciudad.setNivelVillano(nuevoNivel);
    }

    public static boolean idCiudadExiste(int id) {

        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudades.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }

    public static boolean idSuperheroeExiste(int id) {
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }

    public static boolean posicionCiudadValida(int posicion) {
        return posicion >= 0 && posicion < ciudades.size();
    }

    public static boolean posicionSuperheroeValida(int posicion) {
        return posicion >= 0 && posicion < superheroes.size();
    }

    public static boolean respuestaBoolean(String pregunta) {
        int respuesta;

        do {
            System.out.println(pregunta);
            System.out.println("1. Si");
            System.out.println("2. No");

            respuesta = entero("Respuesta: ");

        } while (respuesta != 1 && respuesta != 2);

        return respuesta == 1;
    }

    public static double nivelValido(String mensaje, int minimo) {

        double nivel;

        do {
            nivel = decimal(mensaje);

            if (nivel < minimo || nivel > 100) {
                System.out.println("Debe estar entre " + minimo + " y 100.");
            }

        } while (nivel < minimo || nivel > 100);

        return nivel;
    }

    public static int entero(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(leer.nextLine());

            } catch (NumberFormatException error) {
                System.out.println("Ingrese un numero entero");
            }
        }
    }

    public static double decimal(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(
                        leer.nextLine());

            } catch (NumberFormatException error) {
                System.out.println("Ingrese un numero valido");
            }
        }
    }

    public static double redondear(double numero) {
        return Math.round(numero * 100.0) / 100.0;
    }
}
