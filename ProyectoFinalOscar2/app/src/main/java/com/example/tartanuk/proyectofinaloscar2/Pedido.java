package com.example.tartanuk.proyectofinaloscar2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by tartanuk on 9/2/16.
 */
public class Pedido extends AppCompatActivity{
    public Spinner spinner;
    double total, precioOrdenador;
    String ordenador;
    Integer imagen;

    private Ordenadores[] ordenadoresarray = new Ordenadores[]{
            new Ordenadores("MappleBook Air", 900, R.drawable.air2),
            new Ordenadores("MappleBook Pro", 1100, R.drawable.pro),
            new Ordenadores("iMapple", 2300, R.drawable.imac),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);


        //variables textView y imageView (titulo)
        final TextView textView1 = (TextView) findViewById(R.id.textView1);

        //variables RadioGroup
        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);

        //variables checkBox
        final CheckBox ch1 = (CheckBox) findViewById(R.id.ch1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.ch2);
        final CheckBox ch3 = (CheckBox) findViewById(R.id.ch3);

        //variables textView y editText (cantidad)
        final TextView tv10 = (TextView) findViewById(R.id.tv10);
        final EditText et5 = (EditText) findViewById(R.id.et5);

        //variable botton para ver total del pedido
        final Button btn9 = (Button) findViewById(R.id.btn9);
        final Button btn10 = (Button) findViewById(R.id.btn10);


        class AdaptadorOrdenadores extends ArrayAdapter<Ordenadores> {

            public Activity AdaptadorOrdenadores;

            public AdaptadorOrdenadores(Activity Adaptadorordenadores) {
                super(Adaptadorordenadores, R.layout.spinner_ordenadores, ordenadoresarray);
                this.AdaptadorOrdenadores = Adaptadorordenadores;
            }
            public View getDropDownView (int position, View convertView, ViewGroup parent) {
                View vistaDesplegada = getView(position, convertView, parent);
                return vistaDesplegada;
            }
            //ADAPTACION PARA EL SPINNER
            public  View getView (int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = AdaptadorOrdenadores.getLayoutInflater();
                View item=inflater.inflate(R.layout.spinner_ordenadores, null);

                //VARIABLES JAVA ASIGNADAS AL XML (SIPNNER)
                TextView textView1 = (TextView) item.findViewById(R.id.textView1);
                TextView textView2 = (TextView) item.findViewById(R.id.textView2);
                ImageView imageView1 = (ImageView) item.findViewById(R.id.imageView1);

                textView1.setText(ordenadoresarray[position].getTipo());
                textView2.setText(String.valueOf(ordenadoresarray[position].getPrecio()));
                imageView1.setImageResource(ordenadoresarray[position].getImagen()); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPORP SE HACICA DE OTRA FORMA PE

                return item;
            }

        }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);*/

        spinner = (Spinner) findViewById(R.id.spinner1);
        AdaptadorOrdenadores adaptador = new AdaptadorOrdenadores(this);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                ordenador = ordenadoresarray[position].getTipo();
                precioOrdenador = ordenadoresarray[position].getPrecio();
                imagen = ordenadoresarray[position].getImagen();
                //String mensaje = "Ha seleccionado: " + bebidas[position].getNombre();
                //showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ordenador = "No ha seleccionado ningun ordenador";
            }
        });

        //Click del boton
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                DecimalFormat formateador = new DecimalFormat("##.##");
                String precioTotal;
                double total = 0;
                double cantidad = Double.parseDouble(et5.getText().toString());
                String pulgadas = " ";
                String accesorios = " ";

                String seleccionado = spinner.getSelectedItem().toString();

                //Condición radioButton
                if (rg1.getCheckedRadioButtonId() == R.id.rb1) {
                    total = total;
                    pulgadas = "11";
                }
                if (rg1.getCheckedRadioButtonId() == R.id.rb2) {
                    total = total + 50;
                    pulgadas = "13";
                }
                if (rg1.getCheckedRadioButtonId() == R.id.rb3) {
                    total = total + 70;
                    pulgadas = "15";
                }

                //Condición checkbox seleccionado
                if (ch1.isChecked()) {
                    total = total + 65;
                    accesorios+= ch1.getText()+"";
                }
                if (ch2.isChecked()) {
                    total = total + 45;
                    accesorios+= ch2.getText()+"";
                }
                if (ch3.isChecked()) {
                    total = total + 55;
                    accesorios+= ch3.getText()+"";
                }

                //Precio segun la cantidad
                total = total + precioOrdenador;
                total = total * cantidad;


                //Mostrar precio total
                precioTotal = (formateador.format(total));
                //textView4.setText("El total son "+precioTotal+" euros.");



                nuevoPedido(ordenador, pulgadas, accesorios, cantidad, total, imagen);
            }

        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                Intent miIntent1 = new Intent(Pedido.this, Usuario.class);
                startActivity(miIntent1);

            }
        });

    }

    public void nuevoPedido (String ordenador, String pulgadas, String accesorios, double unidades, double precio, int imagenordenador){

        //crear la base de datos
        CrearDB cdb = new CrearDB(this, "DBUsuarios", null, 1);
        //escribe en la base de datos
        SQLiteDatabase database = cdb.getWritableDatabase();

        //Guardo lo de los edit text
        ContentValues values = new ContentValues();

        //los datos entre comillas, deben ser identicos a los creados en la tabla
        values.put("ordenador", ordenador);
        values.put("pulgadas", pulgadas);
        values.put("accesorios", accesorios);
        values.put("unidades", unidades);
        values.put("precio", precio);
        values.put("imagenordenador", imagenordenador);

        database.insert("Pedidos", null, values);

        database.close();

        Toast.makeText(this, "Pedido creado correctamente", Toast.LENGTH_SHORT).show();

    }
}
