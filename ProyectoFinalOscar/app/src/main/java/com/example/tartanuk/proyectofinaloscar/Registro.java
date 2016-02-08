package com.example.tartanuk.proyectofinaloscar;

import android.content.ContentValues;
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
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        btn1 = (Button) findViewById(R.id.button5);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String apellido = et2.getText().toString();

                registroNuevo(nombre, apellido);
            }
        });

    }

    public void registroNuevo (String nombre, String apellido) {
        //crear la base de datos
        CrearDB cdb = new CrearDB(this, "DBOscar", null, 1);
        //escribe en la base de datos
        SQLiteDatabase database = cdb.getWritableDatabase();

        //Guardo lo de los edit text
        ContentValues values = new ContentValues();

        //los datos entre comillas, deben ser identicos a los creados en la tabla
        values.put("nombre", nombre);
        values.put("apellido", apellido);

        database.insert("Clientes", null, values);

        database.close();

        Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
    }
}


