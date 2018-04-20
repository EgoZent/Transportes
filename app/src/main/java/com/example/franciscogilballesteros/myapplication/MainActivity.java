package com.example.franciscogilballesteros.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button ubicarme;
    Button mapa;
    EditText editText3;
    String latitud="lat";
    String longitud="long";
    TextView origen;
    TextView destino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ubicarme= findViewById(R.id.ubicarme);
        ubicarme.setOnClickListener(this); //para que el boton haga algo al pulsarlo
        mapa= findViewById(R.id.mapa);
        mapa.setOnClickListener(this); //para que el boton haga algo al pulsarlo
        editText3=findViewById(R.id.editText3);
        origen=findViewById(R.id.origen);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ubicarme:
                new GetCoordinates().execute(editText3.getText().toString().replace(" ","+"));
                //Intent intent = new Intent(this,MapsActivity.class);
                //intent.putExtra("latitud",latitud);
                //intent.putExtra("longitud",longitud);
                //startActivity(intent);
                break;
            case R.id.mapa:
                //Toast.makeText(getApplicationContext(),"Coordenadas: "+latitud+" / "+longitud , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,MapsActivity.class);
                intent.putExtra("latitud",latitud);
                intent.putExtra("longitud",longitud);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onSearch(View view) {

    }

    public class GetCoordinates extends AsyncTask<String, Void, String> {
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Por favor, espera...");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);

                String lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lat").toString();
                String lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lng").toString();

                latitud=lat;
                longitud=lng;
                //Toast.makeText(getApplicationContext(),"Coordenadas: "+lat+" / "+lng , Toast.LENGTH_LONG).show();
                origen.setText("Coordenadas: "+lat+" / "+lng);
                if (dialog.isShowing())
                    dialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            String response;
            try {
                String address = strings[0];
                HttpDataHandler http = new HttpDataHandler();
                String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s",address);
                response = http.getHTTPData(url);
                return response;
            }
            catch (Exception ex)
            {

            }
            return null;
        }
    }
}
