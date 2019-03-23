package com.social.servicio.actuaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos);

        final int Asistencia = (int)getIntent().getExtras().getSerializable("Asistencia");
        final ArrayList<Evento> eventos = new ArrayList<Evento>();

        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));
        eventos.add(new Evento("Nombre Evento", "Nombre Ponente", 12, 15, 12, 24));

        AdaptadorEvento adaptadorEvento = new AdaptadorEvento(this, eventos);

        ListView listView = (ListView) findViewById(R.id.lista_eventos);

        listView.setAdapter(adaptadorEvento);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long l) {
                Evento conferencia = eventos.get(position);
                Intent i;
                i = new Intent(ListaEventos.this, Validar.class);
                i.putExtra("Asistencia", Asistencia);
                i.putExtra("NombreEvento", conferencia.getPrnombreEvento());
                startActivity(i);
            }
        });
    }

}
