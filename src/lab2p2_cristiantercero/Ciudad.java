/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_cristiantercero;

/**
 *
 * @author crist
 */
public class Ciudad {

    private int id;
    private String nombre;
    private String nombreVillano;
    private boolean vuelo;
    private double nivelVillano;

    public Ciudad(int id, String nombre, boolean vuelo, String nombreVillano, double nivelVillano) {
        this.id = id;
        this.nombre = nombre;
        this.nombreVillano = nombreVillano;
        this.vuelo = vuelo;
        this.nivelVillano = nivelVillano;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreVillano() {
        return nombreVillano;
    }

    public boolean getVuelo() {
        return vuelo;
    }

    public double getNivelVillano() {
        return nivelVillano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }

    public void setNombreVillano(String nombreVillano) {
        this.nombreVillano = nombreVillano;
    }

    public void setNivelVillano(double nivelVillano) {
        this.nivelVillano = nivelVillano;
    }

}
