package com.example.tartanuk.dibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));
    }

    class Punto{
        float x;
        float y;
        public Punto(float x, float y){
            this.x = x;
            this.y = y;
        }
    }

    class Dibujo extends View {
        public Dibujo (Context c){
            super(c);
        }

        protected void onDraw(Canvas lienzo){

            Paint miPincel = new Paint();
            miPincel.setStrokeWidth(3);
            miPincel.setColor(Color.BLACK);
            Punto p1 = new Punto(20,700);
            Punto p2 = new Punto(520, 700);
            Punto p3 = new Punto(420, 900);
            Punto p4 = new Punto(120, 900);
            Path path = new Path();
            path.moveTo(p1.x, p1.y);
            path.lineTo(p2.x, p2.y);
            path.lineTo(p3.x, p3.y);
            path.lineTo(p4.x, p4.y);
            //dibujo el primer path
            lienzo.drawPath(path, miPincel);
            miPincel.setColor(Color.RED);
            path = new Path();
            p1.x = 270;
            path.moveTo(p1.x , p1.y);
            p2.x = 270;
            p2.y = 400;
            path.lineTo(p2.x , p2.y);
            p3.x = 395;
            p3.y = 550;
            path.lineTo(p3.x , p3.y);
            //dibuja el segundo path porque reutilizo la variable
            lienzo.drawPath(path, miPincel);
        }
    }

}
