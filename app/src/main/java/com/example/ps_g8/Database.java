package com.example.ps_g8;

import  java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable {
    private ArrayList<Pelicula> listP = new ArrayList<Pelicula>();

    public ArrayList<Pelicula> getListP() {
        return listP;
    }

    public void cargarListaPelicula() throws FileNotFoundException {
        File f = new File("src/peliculas.txt");
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
            listP.add(p);
            i++;
        }
    }

}
