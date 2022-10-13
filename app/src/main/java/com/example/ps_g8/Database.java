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
        File f = new File("C:\\Users\\diosy\\AndroidStudioProjects\\PowerRanger_G8\\app\\src\\main\\res\\raw\\peliculas");
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

    public String[] listToString() {
        String[] listaTitulo = {"1","2","3"};
        int i = 1;
        for (Pelicula p: listP) {
            String s = p.getTitulo();
            listaTitulo[i]=s;
            i++;
        }
        return listaTitulo;
    }
}
