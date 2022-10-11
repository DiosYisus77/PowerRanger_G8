package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.net.ssl.ManagerFactoryParameters;

public class MainActivity extends AppCompatActivity {

    public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leerListaPeli();
    }

    public void Start(View view){
        Intent start = new Intent(this, MainActivity2.class);
        startActivity(start); // aaaaa
    }

    public void leerListaPeli() throws FileNotFoundException {
        File f = new File("Peliculas.txt");
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()){
            sc.nextLine();
            sc.findInLine("Pelicula:");
            String nombre = sc.nextLine();
            sc.findInLine("Año:");
            int año = sc.nextInt();
            sc.nextLine();
            sc.findInLine("Genero:");
            String genero = sc.nextLine();
            sc.nextLine();

            Pelicula p = new Pelicula(nombre, año, genero);

        }
    }
}