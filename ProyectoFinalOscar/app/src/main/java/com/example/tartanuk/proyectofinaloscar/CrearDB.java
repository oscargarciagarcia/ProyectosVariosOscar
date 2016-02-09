package com.example.tartanuk.proyectofinaloscar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tartanuk on 8/2/16.
 */
public class CrearDB extends SQLiteOpenHelper{

    String cadSQL = "CREATE TABLE IF NOT EXISTS Usuarios (" +
            " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " usuario TEXT NOT NULL," +
            " contraseña TEXT NOT NULL)";

    public CrearDB(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(cadSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS Usuarios");

        bd.execSQL(cadSQL);
    }

}
