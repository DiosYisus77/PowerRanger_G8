package com.example.ps_g8;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private Database DB;

    RecyclerView listaPelis;
    ArrayList<Pelicula> listaArrayPelis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_item_pelis);

        listaArrayPelis = new ArrayList<>();
        Database userData = (Database) getIntent().getSerializableExtra("userData");
        ListaPelisAdapter adapter = new ListaPelisAdapter(userData);
        listaArrayPelis = userData.getListP();
        listaPelis.setAdapter(adapter);

        System.out.println(listaArrayPelis);
        listaPelis.setLayoutManager(new LinearLayoutManager(this));
    }
}
