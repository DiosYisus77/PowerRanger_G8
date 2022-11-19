package com.example.ps_g8;

public class Pelicula {

    private int id;
    private int imagen;
    private String titulo;
    private String descripcion;


    public Pelicula(int id, int imagen, String titulo, String descripcion){
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String genero) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId(){
        return id;
    }
}
