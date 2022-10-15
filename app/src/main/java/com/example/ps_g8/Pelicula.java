package com.example.ps_g8;

public class Pelicula {

    private int id;
    private int imagen;
    private String titulo;
    private String descripcion;
    private boolean megusta;
    private boolean visto;


    public Pelicula(int id, int imagen, String titulo, String descripcion, boolean megusta, boolean visto) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.megusta = megusta;
        this.visto = visto;
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

    public boolean isMegusta() {
        return megusta;
    }

    public void setMegusta(boolean megusta) {
        this.megusta = megusta;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}
