package com.example.ps_g8;

import static com.example.ps_g8.App.DB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView listaPelis;
    ArrayList<Pelicula> listaArrayPelis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_item_pelis);
        listaArrayPelis = new ArrayList<>();
        listaArrayPelis = DB.getPelis();
        listaPelis.setLayoutManager(new LinearLayoutManager(this));
        ListaPelisAdapter adapter = new ListaPelisAdapter();
        listaPelis.setAdapter(adapter);


    }
}
