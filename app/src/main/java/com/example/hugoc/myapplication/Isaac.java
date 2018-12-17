package com.example.hugoc.myapplication;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class Isaac extends AsyncTask<String, Integer, String> {

    static MediaPlayer Musique;
    private AppCompatActivity myActivity;
    public Isaac(AppCompatActivity a) {
        myActivity = a;
    }


    @Override
    protected String doInBackground(String... string) {


        Musique = MediaPlayer.create(myActivity, R.raw.combat);
        Musique.setLooping(true);
        Musique.start();

        if(isCancelled())
            Musique.stop();

        String result = null;




        return result;
    }



    @Override
    protected void onProgressUpdate(Integer... values) {
    }
    @Override
    protected void onPostExecute(String s) {


    }
    @Override
    protected void onCancelled(){

    }

}
