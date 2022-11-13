package com.example.ps_g8;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText et_contraseña, et_email;

    public void Registrarse(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administración", null, 1);
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

                Toast.makeText(this, "Registro completado", Toast.LENGTH_SHORT).show();

                Intent confirmar = new Intent(this, MainActivity.class);
                startActivity(confirmar);
            }

        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
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