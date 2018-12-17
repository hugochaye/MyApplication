package com.example.hugoc.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
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

public class Debut extends AsyncTask<String, Integer, String> {

    private AppCompatActivity myActivity;
    public Debut(AppCompatActivity a) {
        myActivity = a;
    }


    @Override
    protected String doInBackground(String... string) {


        MediaPlayer lancement;
        lancement = MediaPlayer.create(myActivity, R.raw.lancement);
        lancement.start();
        while(lancement.isPlaying());
        String result = null;

        return result;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
    }
    @Override
    protected void onPostExecute(String s) {
        Intent Commencement = new Intent(myActivity.getApplicationContext(), JeuPrincipal.class);

        final SeekBar seekBarLife = (SeekBar) myActivity.findViewById(R.id.seekBarLife);
        final SeekBar seekBarStrenght = (SeekBar) myActivity.findViewById(R.id.seekBarStrenght);
        final SeekBar seekBarDefense = (SeekBar) myActivity.findViewById(R.id.seekBarDefense);
        final SeekBar seekBarMagic = (SeekBar) myActivity.findViewById(R.id.seekBarMagic);

        int Life = seekBarLife.getProgress();
        int Strengh = seekBarStrenght.getProgress();
        int Defense = seekBarDefense.getProgress();
        int Magic = seekBarMagic.getProgress();
        int[] Attributs = {Life, Strengh, Defense, Magic};

        Commencement.putExtra("Attributs", Attributs);
        myActivity.startActivity(Commencement);



    }

}
