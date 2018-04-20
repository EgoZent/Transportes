package com.example.franciscogilballesteros.myapplication;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ConsultaValenbisi {
    ArrayList<LatLng> fin;
    public ConsultaValenbisi() {

    }

    public ArrayList<LatLng> getNearValenbisi(LatLng latLngOrigen, LatLng latLngDestino) throws IOException {
        String resultado="";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87Safari/537.36";
        String authorization = "Basic aW5mb3JtYXR1cHY6dHlBMGJxVWU=";
        URL url = new URL("http://mapas.valencia.es/lanzadera/opendata/Valenbisi/JSON");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("authorization", authorization);
        con.setRequestProperty("user-agent", userAgent);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        String avalaible;
        String free;
        double diferenciaorigen=10000;
        double diferenciadestino=10000;
        double latitud;
        double longitud;
        String puntos;
        String lat;
        String lng;
        double latparcial;
        double lngparcial;
        double dif;
        fin=new ArrayList<>();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String respuesta=response.toString();
        try {
            JSONObject sms= new JSONObject(respuesta);
            JSONArray vector= new JSONArray(sms.get("features").toString());
            for(int i=2;i<vector.length();i++){
                JSONObject muestra = new JSONObject(vector.get(i).toString());
                JSONObject propiedades = new JSONObject(muestra.get("properties").toString());
                avalaible = (String) propiedades.get("avalaible");
                free = (String) propiedades.get("free");
                if ((avalaible.compareTo("0")!=0)&&(free.compareTo("0")!=0)){
                    JSONObject geometria = new JSONObject(propiedades.get("geometry").toString());
                    puntos=geometria.get("coordinates").toString();
                    lat=puntos.substring(2,11);
                    latitud=Double.parseDouble(lat);
                    lng=puntos.substring(13,22);
                    longitud=Double.parseDouble(lng);
                    latparcial=latitud-latLngOrigen.latitude;
                    lngparcial=longitud-latLngOrigen.longitude;
                    dif=latparcial+lngparcial;
                    if(dif<diferenciaorigen){
                        diferenciaorigen=dif;
                        LatLng candidatoorigen=new LatLng(latitud,longitud);
                        fin.add(0,candidatoorigen);
                    }
                    latparcial=latitud-latLngDestino.latitude;
                    lngparcial=longitud-latLngDestino.longitude;
                    dif=latparcial+lngparcial;
                    dif=latparcial+lngparcial;
                    if(dif<diferenciadestino){
                        diferenciadestino=dif;
                        LatLng candidatodestino=new LatLng(latitud,longitud);
                        fin.add(1,candidatodestino);
                    }

                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fin;
    }

}
