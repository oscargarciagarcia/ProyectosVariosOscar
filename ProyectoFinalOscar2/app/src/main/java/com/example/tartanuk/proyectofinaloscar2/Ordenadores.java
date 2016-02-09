package com.example.tartanuk.proyectofinaloscar2;

/**
 * Created by tartanuk on 9/2/16.
 */
public class Ordenadores {

    private String tipo;
    private double precio;
    private int imagen;

    public Ordenadores (String tipo, double precio, int imagen){
        this.tipo = tipo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public int getImagen() { return imagen; }
}
