package com.example.tartanuk.proyectofinaloscar2;

import android.widget.Spinner;

/**
 * Created by tartanuk on 15/2/16.
 */
public class SpinnerPedidos {

    int idPedido, idCliente, imagenordenador;
    String pulgadas, ordenador, accesorios;
    double unidades, precio;

    public SpinnerPedidos (int idPedido, int idCliente, int imagenordenador, String ordenador,String pulgadas, String accesorios, double unidades, double precio) {

        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.imagenordenador = imagenordenador;
        this.ordenador = ordenador;
        this.pulgadas = pulgadas;
        this.accesorios = accesorios;
        this.unidades = unidades;
        this.precio = precio;
    }

    public int getIdPedido() { return idPedido; }
    public int getIdCliente() { return idCliente; }
    public int getImagenordenador() { return imagenordenador; }
    public String getOrdenador() { return ordenador; }
    public String getPulgadas() { return pulgadas; }
    public String getAccesorios() { return accesorios; }
    public double getUnidades() { return unidades; }
    public double getPrecio() { return precio; }


}
