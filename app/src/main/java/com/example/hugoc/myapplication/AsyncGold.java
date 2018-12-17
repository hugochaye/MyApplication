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

public class AsyncGold extends AsyncTask<String, Integer, String> {

    private AppCompatActivity myActivity;
    public AsyncGold(AppCompatActivity a) {
        myActivity = a;
    }


    @Override
    protected String doInBackground(String... string) {
        MediaPlayer punch;
        punch = MediaPlayer.create(myActivity, R.raw.punch);
        punch.start();
        String result = null;




    return result;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
    }
    @Override
    protected void onPostExecute(String s) {


    }

}
