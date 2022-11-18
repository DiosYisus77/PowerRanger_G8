package com.example.ps_g8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public final class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL("create table lista(email string primary key, contraseña string not null)");
        BaseDatos.execSQL("create table pelis(id string primary key,nombre string not null, año string not null)");
        BaseDatos.execSQL("create table relacion(email string primary key,id string not null,visto string not null,gusta string not null)");
        this.agregarPelis();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void agregarPelis() {
        SQLiteDatabase BaseDatos = this.getWritableDatabase();
        ContentValues reg = new ContentValues();
            for (int i = 1; i <= 7; i++) {
                switch (i) {
                    case 1:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "SPIDERMAN");
                        reg.put("año", "2002");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 2:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "TITANIC");
                        reg.put("año", "1997");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 3:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "STAR WARS");
                        reg.put("año", "1977");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 4:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "EL HOMBRE DE ACERO");
                        reg.put("año", "2013");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 5:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "JUMANJI");
                        reg.put("año", "1995");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 6:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "SIN PERDÓN");
                        reg.put("año", "1992");
                        BaseDatos.insert("pelis", null, reg);
                        break;

                    case 7:
                        reg.put("id", String.valueOf(i));
                        reg.put("nombre", "MATRIX");
                        reg.put("año", "1999");
                        BaseDatos.insert("pelis", null, reg);
                        break;
                }
            }
        }

    public void crearRelaciones(String email){
        SQLiteDatabase BaseDatos = this.getWritableDatabase();
        ContentValues reg = new ContentValues();
        for(int i=1; i<=7;i++){
                reg.put("email", email);
                reg.put("id", String.valueOf(i));
                reg.put("visto", false);
                reg.put("gusta",false);
                BaseDatos.insert("relacion", null, reg);
        }
    }

}


