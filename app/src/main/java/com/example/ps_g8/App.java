package com.example.ps_g8;


import java.io.FileNotFoundException;

public class App {
    private static Database DB = new Database();
    private static MainActivity menu1;
    private MainActivity menu2;

    public static void main(String[] args) throws FileNotFoundException {
        DB.cargarListaPelicula();
        menu1.onStart();
    }
}
