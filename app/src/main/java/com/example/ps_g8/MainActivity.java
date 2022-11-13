package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Database DB = new Database();
    private EditText et_contraseña,et_email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText) findViewById(R.id.id_Email);
        et_contraseña =(EditText) findViewById(R.id.id_Password);
    }

    public void register(View view){
        Intent register = new Intent(this, MainActivity3.class);
        startActivity(register);
    }

    public void buscar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if(!email.isEmpty()){
            Cursor fila = BaseDatos.rawQuery("select contraseña from lista where usuario =" + email, null);

            if(((Cursor) fila).moveToFirst()){
                et_contraseña.setText(fila.getString(0));
                BaseDatos.close();
                Intent busqueda = new Intent(this,MainActivity2.class);
                startActivity(busqueda);
            } else {
                Toast.makeText(this, "La contraseña no es correcta", Toast.LENGTH_SHORT).show();
                BaseDatos.close();
            }
        } else {
            Toast.makeText(this, "No encontramos ninguna cuenta con esa dirección de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }
}