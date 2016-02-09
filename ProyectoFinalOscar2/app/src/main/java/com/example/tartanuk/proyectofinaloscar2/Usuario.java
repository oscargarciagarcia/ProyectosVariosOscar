package com.example.tartanuk.proyectofinaloscar2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tartanuk on 9/2/16.
 */
public class Usuario extends AppCompatActivity{

    Button btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        //variables de los botones
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Pantalla Registro
                Intent miIntent = new Intent(Usuario.this, Pedido.class);
                startActivity(miIntent);
            }
        });

        /*btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Pantalla Registro
                Intent miIntent2 = new Intent(Usuario.this, VerPedidos.class);
                startActivity(miIntent2);
            }
        });*/

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Pantalla Registro
                Intent miIntent3 = new Intent(Usuario.this, Principal.class);
                startActivity(miIntent3);
            }
        });


    }

}