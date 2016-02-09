package com.example.tartanuk.proyectofinaloscar2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tartanuk on 8/2/16.
 */
public class Registro extends AppCompatActivity {

    EditText et1, et2;
    Button btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(Registro.this, Principal.class);
                startActivity(miIntent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = et1.getText().toString();
                String contraseña = et2.getText().toString();

                registroNuevo(usuario, contraseña);
            }
        });


    }

    public void registroNuevo (String usuario, String contraseña) {
        //crear la base de datos
        CrearDB cdb = new CrearDB(this, "DBUsuarios", null, 1);
        //escribe en la base de datos
        SQLiteDatabase database = cdb.getWritableDatabase();

        //Guardo lo de los edit text
        ContentValues values = new ContentValues();

        //los datos entre comillas, deben ser identicos a los creados en la tabla
        values.put("usuario", usuario);
        values.put("contraseña", contraseña);

        database.insert("Usuarios", null, values);

        database.close();

        Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
    }
}
