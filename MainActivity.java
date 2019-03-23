package com.social.servicio.actuaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button asistencia = (Button)findViewById(R.id.asistenciaButton);
        Button anularAsistencia = (Button)findViewById(R.id.anularButton);
        Button desarrolladores = (Button)findViewById(R.id.desarrolladoresButton);

        asistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaEventos.class);
                i.putExtra("Asistencia", 1);
                startActivity(i);
            }
        });

        anularAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaEventos.class);
                i.putExtra("Asistencia", 0);
                startActivity(i);
            }
        });

        desarrolladores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Desarrolladores.class);
                startActivity(i);
            }
        });
    }
}
