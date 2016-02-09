package com.example.tartanuk.proyectofinaloscar2;

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

    String cadSQL1 = "CREATE TABLE IF NOT EXISTS Pedidos (" +
            " idpedido INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " imagenordenador INTEGER NOT NULL," +
            " ordenador TEXT NOT NULL," +
            " pulgadas TEXT NOT NULL," +
            " accesorios TEXT ," +
            " unidades REAL NOT NULL," +
            " precio REAL NOT NULL)";
            //" FOREIGN KEY (id) REFERENCES Usuarios(id) ON DELETE CASCADE)";

    public CrearDB(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(cadSQL);
        bd.execSQL(cadSQL1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL("DROP TABLE IF EXISTS Usuarios");
        bd.execSQL("DROP TABLE IF EXISTS Pedidos");

        bd.execSQL(cadSQL);
        bd.execSQL(cadSQL1);
    }

}
