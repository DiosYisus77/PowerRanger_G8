package com.example.ps_g8;

import  java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable {
    private static ArrayList<Pelicula> listP = new ArrayList<>();

    public ArrayList<Pelicula> getListP() {
        return listP;
    }

    public void cargarListaPelicula() throws FileNotFoundException {
        File f = new File("peliculas.txt");
        Scanner sc = new Scanner(f);
        int i =0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            String nombre = sc.nextLine();
            int año = Integer.parseInt(sc.nextLine());
            String genero = sc.nextLine();
            if(sc.hasNextLine()) {
                sc.nextLine();
            }
            Pelicula p = new Pelicula(nombre, año, genero);
            listP.add(i,p);
            i++;
        }
    }

    public String[] listToString() {
        String[] listaTitulo = {"1. Interstellar 2014 Ciencia Ficcion","2. La casa Gucci 2021 Drama","3. Avatar 2009 Ciencia Ficcion"};
        int i = 0;
        for (Pelicula p: listP) {
            String s = p.getTitulo();
            listaTitulo[i]= s;
            i++;
        }
        return listaTitulo;
    }
}
