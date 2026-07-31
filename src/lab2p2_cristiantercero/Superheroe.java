/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_cristiantercero;

/**
 *
 * @author crist
 */
public class Superheroe {

    private int id;
    private String apodo;
    private String nombre;
    private String descripcion;
    private boolean capacidadVuelo;
    private int[] habilidades;
    private double nivel;

    public Superheroe(int id, String apodo, String nombre, String descripcion, boolean capacidadVuelo, int[] habilidades, double nivel) {
        this.id = id;
        this.apodo = apodo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadVuelo = capacidadVuelo;
        this.habilidades = habilidades;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCapacidadVuelo() {
        return capacidadVuelo;
    }

    public void setCapacidadVuelo(boolean capacidadVuelo) {
        this.capacidadVuelo = capacidadVuelo;
    }

    public int[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(int[] habilidades) {
        this.habilidades = habilidades;
    }

    public double getNivel() {
        return nivel;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

}
