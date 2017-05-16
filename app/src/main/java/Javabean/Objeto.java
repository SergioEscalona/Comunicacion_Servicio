package Javabean;

import java.io.Serializable;

/**
 * Created by USUARIO on 10/04/2017.
 */

public class Objeto implements Serializable{
    private String nombre;
    private Double longitud;
    private Double latitud;

    public Objeto(String nombre, Double longitud, Double latitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    @Override
    public String toString() {
        return nombre + " | " + longitud +" | "+ latitud;
    }
}
