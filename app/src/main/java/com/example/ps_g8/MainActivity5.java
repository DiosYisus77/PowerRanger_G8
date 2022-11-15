package com.example.ps_g8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    private EditText et_contraseña, et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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

            if (!isUsuario(email)) {
                registro.put("email", email);
                registro.put("contraseña", contraseña);
                BaseDatos.insert("lista", null, registro);
                BaseDatos.close();

                et_email.setText("");
                et_contraseña.setText("");

                Toast.makeText(getApplicationContext(), "Registro completado", Toast.LENGTH_SHORT).show();

                Intent confirmar = new Intent(this, MainActivity.class);
                startActivity(confirmar);
                //}

            } else {
                Toast.makeText(getApplicationContext(), "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isUsuario(String email) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        Cursor fila = BaseDatos.rawQuery("select contraseña from lista where email =" + email, null);
        if (fila.moveToFirst()) {
            BaseDatos.close();
            return true;
        } else {
            BaseDatos.close();
            return false;
        }
    }
}