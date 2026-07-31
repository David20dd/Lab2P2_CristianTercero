/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_cristiantercero;

/**
 *
 * @author crist
 */
public class Lab2P2_CristianTercero {

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
            opcion = leerEntero("Seleccione una opcion: ");

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
    
    public static void agregarCiudad(){
        
    }
}
