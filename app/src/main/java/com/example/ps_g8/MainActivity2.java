package com.example.ps_g8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity{

    private Database DB = new Database();
    private ListView lv1;
    private ArrayAdapter<String> adapter;
    private List<String> listTitulo = new ArrayList<>();
    String[] s ={"a","b","c","d"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv1 = (ListView) findViewById(R.id.lv1);

        try {
            DB.cargarListaPelicula();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String [] listTitulo = DB.listToString();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTitulo);
        lv1.setAdapter(adapter);





        /*listaArrayPelis = new ArrayList<>();
        Database userData = (Database) getIntent().getSerializableExtra("userData");
        ListaPelisAdapter adapter = new ListaPelisAdapter(userData);
        listaArrayPelis = userData.getListP();
        listaPelis.setAdapter(adapter);

        System.out.println(listaArrayPelis);
        listaPelis.setLayoutManager(new LinearLayoutManager(this));

         */
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
