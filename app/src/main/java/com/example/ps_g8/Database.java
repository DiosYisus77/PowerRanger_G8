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
        File f = new File("C:\\Users\\ddela\\Desktop\\Lista Películas.txt");
        Scanner sc = new Scanner(f);
        int i =0;
        sc.nextLine();
        while (sc.hasNextLine()) {
            String nombre = sc.nextLine();
            int año = Integer.parseInt(sc.nextLine());
            String genero = sc.nextLine();
            if(sc.hasNextLine()) {
                sc.nextLine();
            }
            Pelicula p = new Pelicula(nombre, año, genero);
            pelis.add(i,p);
            i++;
        }
    }
}
