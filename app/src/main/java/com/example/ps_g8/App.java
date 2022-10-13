package com.example.ps_g8;


import java.io.FileNotFoundException;

public class App {
    public static Database DB = new Database();
    private static MainActivity menu1;
    private MainActivity2 menu2;

    public static void main(String[] args) throws FileNotFoundException {
        DB.cargarListaPelicula();
        DB.getPelis().get(0).getTitulo();
        DB.getPelis().get(0).getAño();
        DB.getPelis().get(0).getGenero();
        menu1.onStart();
    }
}
