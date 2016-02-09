package com.example.tartanuk.proyectofinaloscar2;

/**
 * Created by tartanuk on 9/2/16.
 */
public class Usuarios {

    private int id;
    private String usuario, contraseña;

    public Usuarios (int id, String usuario, String contraseña){
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId(){
        return id;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContraseña(){
        return contraseña;
    }
}
