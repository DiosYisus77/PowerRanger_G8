package com.example.ps_g8;

public class Pelicula {
    private String Titulo;
    private int Año;
    private String Genero;

    public Pelicula(String titulo, int año, String genero) {
        this.Titulo = titulo;
        this.Año = Año;
        this.Genero = genero;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.Año = año;
    }

    public String getGenero() {

        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
