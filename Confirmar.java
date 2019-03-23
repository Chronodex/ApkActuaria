package com.social.servicio.actuaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Confirmar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar);

        //Parametros
        final String token = (String)getIntent().getExtras().getSerializable("Folio");
        final int Asistencia = (int)getIntent().getExtras().getSerializable("Asistencia");


        TextView folioQR = (TextView)findViewById(R.id.folioConfirmacion);
        Button botonConfirmar = (Button)findViewById(R.id.botonConfirmar);
        Button botonCancelar = (Button)findViewById(R.id.botonCancelar);

        folioQR.setText(token);

        botonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String folio = token;

                RequestQueue queue = Volley.newRequestQueue(Confirmar.this);
                //for POST requests, only the following line should be changed to

                StringRequest sr = new StringRequest(Request.Method.POST, "http://192.168.43.33/dashboard/webservice/asistencia.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Confirmar.this, response.toString(), Toast.LENGTH_LONG);
                                Log.e("HttpClient", "success! response: " + response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("HttpClient", "error: " + error.toString());
                                Toast.makeText(Confirmar.this, error.toString(),Toast.LENGTH_LONG).show();
                            }
                        })
                {
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("folio",folio);
                        params.put("asistencia",Integer.toString(Asistencia));
                        return params;
                    }
                };
                queue.add(sr);
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
