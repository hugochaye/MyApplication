package com.example.hugoc.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class Informer extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_informer);


        try {
            String s = null;
            JSONObject json = null;Iterator<String> it = null;

            Log.i("CIO", "Message 1:");
            Log.i("CIO", "----------");
            s = new String("{\n" +
                    "  \"clef1\": \"value1\",\n" +
                    "  \"clef2\": 10,\n" +
                    "  \"clef3\": \"value3\"\n" +
                    "}");

            json = new JSONObject(s);

            it = json.keys();
            while (it.hasNext())
            {
                String key = it.next();
                Log.i("CIO", "JSON key: " + key);
                Log.i("CIO", "     value: " + json.getString(key));
            }

            Log.i("CIO", "Message 2:");
            Log.i("CIO", "----------");
            s = new String("{\n" +
                    "  \"clef1\": \"value1\",\n" +
                    "  \"clef2\": 10,\n" +
                    "  \"clef3\": \"value3\",\n" +
                    "  \"objet\": { \"clefa\": \"value4\" }\n" +
                    "}");

            json = new JSONObject(s);

            it = json.keys();
            while (it.hasNext())
            {
                String key = it.next();
                Log.i("CIO", "JSON key: " + key);
                Log.i("CIO", "     value: " + json.getString(key));
                Log.i("CIO", "     value of type: " + json.get(key).getClass());
            }

            Log.i("CIO", "Sous objet, valeur: " +
                    json.getJSONObject("objet")
                            .getString("clefa"));


            Log.i("CIO", "Message 3:");
            Log.i("CIO", "----------");

            s = new String("{\n" +
                    "  \"tableau\" : [\n" +
                    "    { \"nom\" : \"objet1\" },\n" +
                    "    { \"nom\" : \"objet2\" },\n" +
                    "    { \"nom\" : \"objet3\" }\n" +
                    "    ]\n" +
                    "}");

            json = new JSONObject(s);

            JSONArray array = json.getJSONArray("tableau");
            Log.i("CIO", "Taille du tableau: " + array.length());
            for (int i=0; i<array.length(); i++)
                Log.i("CIO", "Nom: " + array.getJSONObject(i).getString("nom"));


        } catch (JSONException e) {
            e.printStackTrace();
        }



        // Extras
        Bundle extras = getIntent().getExtras();
        String login = new String(extras.getString("login"));



        //
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Click(button);
            }
        });



    }




    public void Click(View view) {
        AsyncHTTP asyncHTTP = new AsyncHTTP(this);
        asyncHTTP.execute();
    }
}
