package com.example.tartanuk.proyectofinaloscar2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tartanuk on 8/2/16.
 */
public class InicioSesion extends AppCompatActivity {

    EditText et3, et4;
    Button btn5;
    Usuarios[] usuariosarray1;
    int idCliente;
    String nombreCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);

        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        btn5 = (Button) findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Coge los campos introducidos.
                String usuarioInicioSesion = et3.getText().toString();
                String contraseñaInicioSesion = et4.getText().toString();

                Usuarios[] usuariosarray = usuarios();

                //comprobar si existe
                boolean existe = false;
                for (Usuarios usuarios1 : usuariosarray){
                    if (usuarios1.getUsuario().equals(usuarioInicioSesion) && usuarios1.getContraseña().equals(contraseñaInicioSesion)){
                        existe = true;
                        idCliente = usuarios1.getId();
                        nombreCliente = usuarios1.getUsuario();
                    }
                }
                if(existe == false){
                    verToast();
                }else{
                    Intent miIntent = new Intent(InicioSesion.this, Usuario.class);
                    Bundle mibundle = new Bundle();
                    mibundle.putInt("ID", idCliente);
                    mibundle.putString("NOMBRE", nombreCliente);
                    miIntent.putExtras(mibundle);
                    startActivity(miIntent);

                }
            }
        });
    }

    public void verToast(){
        Toast.makeText(this, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
    }

    //Mete los los datos de la tabla usuarios en un array, para posteriormente comprobar si existe el usuario introducido en el inicio de sesion.
    public Usuarios[] usuarios(){
        CrearDB cdb = new CrearDB(this, "DBUsuarios", null, 1);
        SQLiteDatabase database = cdb.getReadableDatabase();
        //creo el cursor para saber que tabla tiene que analizar
        Cursor cursor = database.rawQuery("select * from Usuarios", null);
        //guarda el numero de filas que tiene.
        int numeroUsuarios = cursor.getCount();

        int i = 0;
        usuariosarray1 = new Usuarios[numeroUsuarios];
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String usuario = cursor.getString(1);
                String contraseña = cursor.getString(2);

                usuariosarray1[i] = new Usuarios(id, usuario, contraseña);
                i++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return usuariosarray1;
    }

}
