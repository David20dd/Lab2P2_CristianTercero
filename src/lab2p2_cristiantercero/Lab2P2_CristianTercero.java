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
            id = entero("ID; ");

            if (idCiudadExiste(id)) {
                System.out.println("El ID ya existe.");
            }

        } while (idCiudadExiste(id));

        System.out.println("Nombre ciudad: ");

        String nombre = leer.nextLine();
        boolean vuelo = respuestaBoolean("Se necesita volar para llegar?");

        System.out.println("Nombre del villano: ");
        String villano = leer.nextLine();

        double nivel = nivelVillano("Nivel del villano [0-100]: ", 1);
        ciudades.add(new Ciudad(id, nombre, villano, vuelo, nivel));

        System.out.println("Ciudad agregada");

    }

    public static void agregarSuperheroe() {
        int id;

        do {
            id = entero("ID: ");

            if (idCiudadExiste(id)) {
                System.out.println("El ID ya existe");
            }

        } while (idSuperheroeExiste(id));

        System.out.println("Apodo: ");
        String apodo = leer.nextLine();

        System.out.println("Nombre civil: ");
        String nombre = leer.nextLine();

        System.out.println("Descripcion: ");
        String descripcion = leer.nextLine();

        boolean vuelo = respuestaBoolean("Tiene capacidad de vuelo?");
        int[] habilidades = new int[5];

        for (int i = 0; i < habilidades.length; i++) {
            habilidades[i] = random.nextInt(101);

            double nivel = habilidades[0] * 0.20 + habilidades[1] * 0.15 + habilidades[2] * 0.10 + habilidades[3] * 0.30 + habilidades[4] * 0.25;
            superheroes.add(new Superheroe(id, apodo, nombre, descripcion, vuelo, habilidades, nivel));
            System.out.println("Superheroe agregado");

        }

    }
}
