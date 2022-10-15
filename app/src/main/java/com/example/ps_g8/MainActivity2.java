package com.example.ps_g8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    private List<Pelicula> lst;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv1 = (ListView) findViewById(R.id.lv1);

        CustomAdapter adapter=new CustomAdapter(this, GetData());
        lv1.setAdapter(adapter);
    }

    private List<Pelicula> GetData() {
        lst=new ArrayList<>();
        lst.add(new Pelicula(1,R.drawable.spiderman,"SPIDERMAN","2002"));
        lst.add(new Pelicula(2,R.drawable.titanic,"TITANIC","1997"));
        lst.add(new Pelicula(3,R.drawable.starwars,"STAR WARS","1977"));
        lst.add(new Pelicula(4,R.drawable.elhombredeacero,"EL HOMBRE DE ACERO","2013"));
        lst.add(new Pelicula(5,R.drawable.jumanji,"JUMANJI","1995"));
        lst.add(new Pelicula(6,R.drawable.sinperdon,"SIN PERDÓN","1992"));
        lst.add(new Pelicula(7,R.drawable.matrix,"MATRIX","1999"));

        return lst;
    }
}
