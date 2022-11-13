package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.net.ssl.ManagerFactoryParameters;

public class MainActivity extends AppCompatActivity {

    private Database DB = new Database();
    private EditText et_usuario, et_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*try {
            DB.cargarListaPelicula();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        et_usuario = (EditText) findViewById(R.id.id_Usuario);
        et_contraseña =(EditText) findViewById(R.id.id_Password);
    }

    public void Start(View view){
        Intent start = new Intent(this, MainActivity2.class);
        startActivity(start);
    }

    public void Registrarse(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administración",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String usuario = et_usuario.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if((!usuario.isEmpty()) && (!contraseña.isEmpty())){
            ContentValues registro = new ContentValues();
            registro.put("usuario",usuario);
            registro.put("contraseña",contraseña);

            BaseDatos.insert("lista",null,registro);
            BaseDatos.close();

            et_usuario.setText("");
            et_contraseña.setText("");

            Toast.makeText(this,"Registro completado",Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this,"Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String usuario = et_usuario.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if(!usuario.isEmpty()){
            Cursor fila = BaseDatos.rawQuery("select contraseña from lista where usuario =" + usuario, null);

            if(((Cursor) fila).moveToFirst()){
                et_contraseña.setText(fila.getString(0));
                BaseDatos.close();
            } else {
                Toast.makeText(this, "La contraseña no es correcta", Toast.LENGTH_SHORT).show();
                BaseDatos.close();
            }
        } else {
            Toast.makeText(this, "No encontramos ninguna cuenta con esa dirección de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }
}