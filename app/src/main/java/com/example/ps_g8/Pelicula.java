package com.example.ps_g8;

public class Pelicula {
    private String titulo;
    private int año;
    private String genero;

    public Pelicula(String titulo, int año, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.genero = genero;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
