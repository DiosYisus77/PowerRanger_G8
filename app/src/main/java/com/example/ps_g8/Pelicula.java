package com.example.ps_g8;

public class Pelicula {
    private String name;
    private int año;
    private String genero;

    public Pelicula(String name, int año, String genero) {
        this.name = name;
        this.año = año;
        this.genero = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
