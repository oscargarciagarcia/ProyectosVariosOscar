package com.example.tartanuk.proyectofinaloscar2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tartanuk on 15/2/16.
 */
public class MostrarPedidos extends AppCompatActivity{

    SpinnerPedidos[] spinnerPedidos;
    ImageView siv1;
    TextView stv1, stv2, stv3, stv4, stv5;
    Spinner pedidos;
    String mensaje;
    Button boton;

    int id;
    int idPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_pedidos);

        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                borrar();

            }
        });

        Bundle bundleId = getIntent().getExtras();
        id = bundleId.getInt("IDC");

        mostrarSpinner();
        Adaptador adaptador = new Adaptador(this);
        pedidos = (Spinner) findViewById(R.id.spinner);
        pedidos.setAdapter(adaptador);
        pedidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                siv1.setImageResource(spinnerPedidos[i].getImagenordenador());
                stv1.setText(spinnerPedidos[i].getOrdenador());
                stv2.setText(spinnerPedidos[i].getPulgadas());
                stv3.setText(spinnerPedidos[i].getAccesorios());
                stv4.setText("Unidades: " + spinnerPedidos[i].getUnidades());
                stv5.setText("Precio: " + spinnerPedidos[i].getPrecio());
                idPedido = spinnerPedidos[i].getIdPedido();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                mensaje = "Hola caracola";

            }
        });
    }


        class Adaptador extends ArrayAdapter<SpinnerPedidos> {

            public Activity activity;

            //Creamos el adaptador
            public Adaptador(Activity activity) {
                super(activity, R.layout.spinner_pedidos, spinnerPedidos);
                this.activity = activity;
            }

            //Buscar lo que hace
            public View getDropDownView(int i, View convertView, ViewGroup parent) {
                View view = getView(i, convertView, parent);
                return view;
            }

            //Muestra los datos del pedido de un cliente
            public View getView(int i, View convertView, ViewGroup parent) {
                LayoutInflater inflater = getLayoutInflater();
                //Coge los datos del pedido para guardarlos en el spinner
                View item = inflater.inflate(R.layout.spinner_pedidos, null);

                siv1 = (ImageView) item.findViewById(R.id.siv1);
                stv1 = (TextView) item.findViewById(R.id.stv1);
                stv2 = (TextView) item.findViewById(R.id.stv2);
                stv3 = (TextView) item.findViewById(R.id.stv3);
                stv4 = (TextView) item.findViewById(R.id.stv4);
                stv5 = (TextView) item.findViewById(R.id.stv5);

                //metemos las variables en el spinner para que lo rellene
                siv1.setImageResource(spinnerPedidos[i].getImagenordenador());
                stv1.setText(spinnerPedidos[i].getOrdenador());
                stv2.setText("Pulgadas: " + spinnerPedidos[i].getPulgadas());
                stv3.setText("Accesorios: " + spinnerPedidos[i].getAccesorios());
                stv4.setText("Unidades: " + spinnerPedidos[i].getUnidades());
                stv5.setText("Precio: " + spinnerPedidos[i].getPrecio());

                return item;
            }

        }


    public void mostrarSpinner() {
        CrearDB cdb = new CrearDB(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = cdb.getReadableDatabase();
        if ( db != null) {
            Cursor cursor = db.rawQuery("SELECT * FROM Pedidos WHERE idCliente =" + id, null);
            int contador = cursor.getCount();
            int i = 0;
            //Crea un array con tantas filas hayas
            spinnerPedidos = new SpinnerPedidos[contador];

            if (cursor.moveToFirst()){
                do {
                    int idPedido = cursor.getInt(0);
                    int idCliente = cursor.getInt(1);
                    int imagenOrdenador = cursor.getInt(2);
                    String ordenador = cursor.getString(3);
                    String pulgadas = cursor.getString(4);
                    String accesorios = cursor.getString(5);
                    int unidades = cursor.getInt(6);
                    double precio = cursor.getDouble(7);

                    spinnerPedidos[i] = new SpinnerPedidos(idPedido, idCliente, imagenOrdenador, ordenador, pulgadas, accesorios, unidades, precio);
                    i++;
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();

        }
    }

    public void borrar () {

        CrearDB crear = new CrearDB(this, "DBUsuarios", null, 1);
        SQLiteDatabase crearSQL = crear.getWritableDatabase();
        crearSQL.execSQL("DELETE FROM Pedidos WHERE idpedido=" + idPedido);

        Toast.makeText(this, "Pedido con id " + idPedido + " borrado correctamente", Toast.LENGTH_SHORT).show();

    }
}
