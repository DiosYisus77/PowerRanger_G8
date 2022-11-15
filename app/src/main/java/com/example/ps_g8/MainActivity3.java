package com.example.ps_g8;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText et_contraseña, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et_email = (EditText) findViewById(R.id.id_Email3);
        et_contraseña =(EditText) findViewById(R.id.id_Password3);
    }

    public void Registrarse(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if ((!email.isEmpty()) && (!contraseña.isEmpty())) {
            ContentValues registro = new ContentValues();

            if (isUsuario(BaseDatos,email)) {
                registro.put("email", email);
                registro.put("contraseña", contraseña);
                BaseDatos.insert("lista", null, registro);
                BaseDatos.close();

                et_email.setText("");
                et_contraseña.setText("");

                Toast.makeText(getApplicationContext(), "Registro completado", Toast.LENGTH_SHORT).show();

                Intent confirmar = new Intent(this, MainActivity.class);
                startActivity(confirmar);
            }

        } else {
            Toast.makeText(getApplicationContext(), "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean isUsuario(SQLiteDatabase BaseDatos, String email) {

        Cursor fila = BaseDatos.rawQuery("select email from lista where email =" + email, null);
        if (fila.moveToFirst()) {
                return true;
        } else {
                return false;
        }
    }

}