package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity6 extends AppCompatActivity {
    private Button btn1;
    ImageView img;
    TextView tit,sin,year;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        img.findViewById(R.id.imagen);
        tit.findViewById(R.id.titulo);
        sin.findViewById(R.id.sinopsis);
        year.findViewById(R.id.año);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        btn1 = view.findViewById(R.id.button1);
        Pelicula p = (Pelicula) btn1.getTag();
        int idPelicula = p.getId();
        Cursor c = BaseDatos.rawQuery("select * from pelicula where id=idPelicula", null);
        if (c.moveToFirst() && c.getCount() >= 1) {
            @SuppressLint("Range") String titulo = c.getString(c.getColumnIndex("nombre"));
            tit.setText(titulo);
            @SuppressLint("Range") String sinopsis = c.getString(c.getColumnIndex("sinopsis"));
            sin.setText(sinopsis);
            @SuppressLint("Range") String año = c.getString(c.getColumnIndex("año"));
            year.setText(año);
            BaseDatos.close();


            switch (idPelicula) {
                case 1:
                    img.setImageResource(R.drawable.spiderman);
                    break;
                case 2:
                    img.setImageResource(R.drawable.titanic);
                    break;
                case 3:
                    img.setImageResource(R.drawable.starwars);
                    break;
                case 4:
                    img.setImageResource(R.drawable.elhombredeacero);
                    break;
                case 5:
                    img.setImageResource(R.drawable.jumanji);
                    break;
                case 6:
                    img.setImageResource(R.drawable.sinperdon);
                    break;
                case 7:
                    img.setImageResource(R.drawable.matrix);
                    break;
            }

        }

    }

        public void volverListadoPelis (View view){
            Intent volver = new Intent(this, MainActivity2.class);
            startActivity(volver);
        }
    }