package com.social.servicio.actuaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Validar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validar);

        final int Asistencia = (int)getIntent().getExtras().getSerializable("Asistencia");
        String NombreEvento = (String)getIntent().getExtras().getSerializable("NombreEvento");

        final Button folioButton = (Button)findViewById(R.id.folioButton);
        Button qrButton = (Button)findViewById(R.id.qrButton);
        final EditText folioEdit = (EditText)findViewById(R.id.folioText);
        final Button confirmar = (Button)findViewById(R.id.confirmarButton);
        TextView ejemplo = (TextView)findViewById(R.id.textoPrueba);

        folioEdit.setVisibility(View.GONE);
        confirmar.setVisibility(View.GONE);
        ejemplo.setText(NombreEvento);

        final Toast mensajeError = Toast.makeText(this, "Soy un error", Toast.LENGTH_LONG);
        final Toast mensajeExitoc= Toast.makeText(this, "Exito", Toast.LENGTH_LONG);

        folioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(folioEdit.getVisibility()==View.GONE){
                    folioEdit.setVisibility(View.VISIBLE);
                    confirmar.setVisibility(View.VISIBLE);
                }
                else{
                    folioEdit.setVisibility(View.GONE);
                    confirmar.setVisibility(View.GONE);
                }
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String folio = folioEdit.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(Validar.this);
                //for POST requests, only the following line should be changed to

                StringRequest sr = new StringRequest(Request.Method.POST, "http://192.168.43.33/dashboard/webservice/asistencia.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                mensajeExitoc.setText("Respuesta" + response.toString());
                                mensajeExitoc.show();
                                Log.e("HttpClient", "success! response: " + response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                mensajeError.setText("error" + error.toString());
                                mensajeError.show();
                                Log.e("HttpClient", "error: " + error.toString());
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

        qrButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Validar.this, LectorQR.class);
                i.putExtra("Asistencia", Asistencia);
                startActivity(i);
            }
        });
    }
}
