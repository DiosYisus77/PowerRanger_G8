package com.example.ps_g8;

public class Pelicula {
    private String nombre;
    private int año;
    private String genero;

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public String getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
