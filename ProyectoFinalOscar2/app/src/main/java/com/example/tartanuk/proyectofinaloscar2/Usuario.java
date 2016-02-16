package com.example.tartanuk.proyectofinaloscar2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tartanuk on 9/2/16.
 */
public class Usuario extends AppCompatActivity{

    Button btn6, btn7, btn8;
    int idCliente1;
    String nombreCliente1, titulo;
    TextView tv8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        //variables de los botones
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        tv8 = (TextView) findViewById(R.id.tv8);
        Bundle recoger = getIntent().getExtras();
        idCliente1 = recoger.getInt("ID");
        nombreCliente1 = recoger.getString("NOMBRE");
        titulo = "Página principal de " + nombreCliente1 + "(id " + idCliente1 + " )";

        tv8.setText(titulo);

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle miBundle1 = new Bundle();
                miBundle1.putInt("ID", idCliente1);

                //Pantalla Registro
                Intent miIntent1 = new Intent(Usuario.this, Pedido.class);
                miIntent1.putExtras(miBundle1);
                startActivity(miIntent1);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent2 = new Intent(Usuario.this, MostrarPedidos.class);

                Bundle miBundle2 = new Bundle();
                miBundle2.putInt("IDC", idCliente1);

                //Pantalla Registro
                miIntent2.putExtras(miBundle2);
                startActivity(miIntent2);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Pantalla Registro
                Intent miIntent3 = new Intent(Usuario.this, Principal.class);
                startActivity(miIntent3);
            }
        });


    }

}