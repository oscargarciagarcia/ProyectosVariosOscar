package com.example.tartanuk.proyectofinaloscar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //variables de los botones
        Button button1 = (Button) findViewById(R.id.button1);

        //click del boton1
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Segunda Pantalla
                Intent miIntent = new Intent(Principal.this, Registro.class);
                startActivity(miIntent);
            }
        });
    }
}
