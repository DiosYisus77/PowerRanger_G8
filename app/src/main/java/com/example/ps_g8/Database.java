package com.example.ps_g8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();

    public ArrayList<Pelicula> getPelis() {
        return pelis;
    }

    public void setPelis(ArrayList<Pelicula> pelis) {
        this.pelis = pelis;
    }

    public void cargarListaPelicula() throws FileNotFoundException {
        File f = new File("Peliculas.txt");
        Scanner sc = new Scanner(f);
        int i =0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            sc.findInLine("Pelicula:");
            String nombre = sc.nextLine();
            sc.findInLine("Año:");
            int año = sc.nextInt();
            sc.findInLine("Genero:");
            String genero = sc.nextLine();
            sc.nextLine();

            Pelicula p = new Pelicula(nombre, año, genero);
            pelis.add(i,p);
            i++;
        }
    }
}
