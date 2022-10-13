package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.net.ssl.ManagerFactoryParameters;

public class MainActivity extends AppCompatActivity {

    private Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button startButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            DB.cargarListaPelicula();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //startButton = (Button) findViewById(R.id.startButton);
        //startButton.setOnClickListener(view -> {
            //Call to login method from userAccess

        }


    public void Start(View view){
        Intent start = new Intent(this, MainActivity2.class);
        //start.putExtra("userData", userData);
        startActivity(start);
    }

}