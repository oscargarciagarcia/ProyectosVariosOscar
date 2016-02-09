package com.example.tartanuk.proyectofinaloscar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //variables de los botones
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        //click del boton1
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Pantalla Registro
                Intent miIntent = new Intent(Principal.this, Registro.class);
                startActivity(miIntent);
            }
        });

        //click del boton2
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //Pantalla InicioSesion
                Intent miIntent1 = new Intent(Principal.this, InicioSesion.class);
                startActivity(miIntent1);
            }
        });
    }
}
