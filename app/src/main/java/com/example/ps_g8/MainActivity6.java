package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    public void buscarPelicula(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        btn1 = view.findViewById(R.id.button1);
        Pelicula p = (Pelicula) btn1.getTag();
        int idPelicula = p.getId();
        Cursor c = BaseDatos.rawQuery("select * from pelicula where id=idPelicula", null);
        if (c.moveToFirst() && c.getCount() >= 1){
            @SuppressLint("Range") String titulo = c.getString(c.getColumnIndex("nombre"));
            @SuppressLint("Range") String sinopsis = c.getString(c.getColumnIndex("sinopsis"));
            @SuppressLint("Range") String año = c.getString(c.getColumnIndex("año"));
            BaseDatos.close();
        }

    }

    public void volverListadoPelis(View view){
        Intent volver = new Intent(this, MainActivity2.class);
        startActivity(volver);
    }
}