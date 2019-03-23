package com.social.servicio.actuaria;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class AdaptadorEvento extends ArrayAdapter<Evento> {


    public AdaptadorEvento(Context context, ArrayList<Evento> conferencias) {
        super(context, 0, conferencias);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        }

        Evento eventoActual =  getItem(position);

        TextView nombreConferenica =  (TextView) listItemView.findViewById(R.id.nombreConferencia);
        nombreConferenica.setText(eventoActual.getPrnombreEvento());

        TextView nombrePonente = (TextView) listItemView.findViewById(R.id.nombrePonente);
        nombrePonente.setText(eventoActual.getPrnombrePonente());

        TextView horaInicio = (TextView) listItemView.findViewById(R.id.horaInicio);
        horaInicio.setText(Integer.toString(eventoActual.getPrhoraInicio()) + ":00");

        TextView horaFinal = (TextView) listItemView.findViewById(R.id.horaFinal);
        horaFinal.setText(Integer.toString(eventoActual.getPrhoraFin()) + ":00");

        TextView mes = (TextView) listItemView.findViewById(R.id.mes);
        mes.setText("Mes: " + Integer.toString(eventoActual.getPrmes()));

        TextView dia = (TextView) listItemView.findViewById(R.id.dia);
        dia.setText("Dia: " + Integer.toString(eventoActual.getPrdia()));

        return listItemView;
    }
}
