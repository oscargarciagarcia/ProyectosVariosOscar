package com.example.tartanuk.proyectofinaloscar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by tartanuk on 8/2/16.
 */
public class InicioSesion extends AppCompatActivity {

    //final TextView tv5 = (TextView) findViewById(R.id.tv5);
    //final TextView tv6 = (TextView) findViewById(R.id.tv6);
    //final EditText et3 = (EditText) findViewById(R.id.et3);
    //final TextView tv7 = (TextView) findViewById(R.id.tv7);
    //final EditText et4 = (EditText) findViewById(R.id.et4);
    //final Button btn5 = (Button) findViewById(R.id.btn5);

    EditText et3, et4;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);

        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        btn5 = (Button) findViewById(R.id.btn5);
    }

}
