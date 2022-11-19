package com.example.ps_g8;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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

    private ListView lv1;
    private List<Pelicula> lst;
    private ImageButton tgbtn1;
    private ImageButton tgbtn2;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv1 = (ListView) findViewById(R.id.lv1);

        CustomAdapter adapter=new CustomAdapter(this, GetData());
        lv1.setAdapter(adapter);

    }

    public void me_gusta (View view) {
        tgbtn1 = view.findViewById(R.id.imageButton1);
        tgbtn1.setImageResource(R.drawable.ic_baseline_favorite_24);
        Pelicula p = (Pelicula) tgbtn1.getTag();
        Toast.makeText(getApplicationContext(), Integer.toString(p.getId()), Toast.LENGTH_SHORT).show();
    }

    public void visto (View view) {
        tgbtn2 = view.findViewById(R.id.imageButton2);
        tgbtn2.setImageResource(R.drawable.ic_baseline_remove_red_eye_24);
        Pelicula p = (Pelicula) tgbtn1.getTag();
        Toast.makeText(getApplicationContext(), Integer.toString(p.getId()), Toast.LENGTH_SHORT).show();
    }

    /*public List<Pelicula> GetData() {
        lst=new ArrayList<>();
        lst.add(new Pelicula(1,R.drawable.spiderman,"SPIDERMAN","2002", false, false));
        lst.add(new Pelicula(2,R.drawable.titanic,"TITANIC","1997", false, false));
        lst.add(new Pelicula(3,R.drawable.starwars,"STAR WARS","1977", false, false));
        lst.add(new Pelicula(4,R.drawable.elhombredeacero,"EL HOMBRE DE ACERO","2013", false, false));
        lst.add(new Pelicula(5,R.drawable.jumanji,"JUMANJI","1995", false, false));
        lst.add(new Pelicula(6,R.drawable.sinperdon,"SIN PERDÓN","1992", false, false));
        lst.add(new Pelicula(7,R.drawable.matrix,"MATRIX","1999", false, false));

        return lst;
    }*/

    public List<Pelicula> GetData() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        lst = new ArrayList<>();
        Cursor c = BaseDatos.rawQuery("select * from pelicula", null);
        if (c.moveToFirst() && c.getCount() >= 1) {
            do {
                @SuppressLint("Range") String titulo = c.getString(c.getColumnIndex("nombre"));
                @SuppressLint("Range") String año = c.getString(c.getColumnIndex("año"));
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
                switch (id){
                    case 1:lst.add(new Pelicula(id, R.drawable.spiderman, titulo, año));
                    break;
                    case 2:lst.add(new Pelicula(id, R.drawable.titanic, titulo, año));
                    break;
                    case 3:lst.add(new Pelicula(id, R.drawable.starwars, titulo, año));
                    break;
                    case 4:lst.add(new Pelicula(id, R.drawable.elhombredeacero, titulo, año));
                    break;
                    case 5:lst.add(new Pelicula(id, R.drawable.jumanji, titulo, año));
                    break;
                    case 6:lst.add(new Pelicula(id, R.drawable.sinperdon, titulo, año));
                    break;
                    case 7:lst.add(new Pelicula(id, R.drawable.matrix, titulo, año));
                    break;
                }
            } while (c.moveToNext());
        }
        c.close();
        BaseDatos.close();
        return lst;
    }
}

