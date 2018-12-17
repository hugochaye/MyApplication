package com.example.hugoc.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class Paladin extends AsyncTask<String, Integer, String> {

    private AppCompatActivity myActivity;
    public Paladin(AppCompatActivity a) {
        myActivity = a;
    }
    JSONObject jsonObject = null;

    @Override
    protected String doInBackground(String... string) {


        publishProgress(1);
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        publishProgress(20);



        try {
            url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Paladin");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            result = readStream(in);
            Iterator<String> it = null;

            try {
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                /*
                jsonObject = new JSONObject(in.toString());
                result = jsonObject.getString(extract);
                */

                result = jsonObject.getString("query");
                JSONObject Object1 = new JSONObject(result);
                result = Object1.getString("pages");
                JSONObject Object2 = new JSONObject(result);
                result = Object2.getString("15400699");
                JSONObject Object3 = new JSONObject(result);
                result = Object3.getString("extract");



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        catch (MalformedURLException e) { e.printStackTrace();}
        catch (IOException e){ e.printStackTrace();}
        finally {if (urlConnection != null)
            urlConnection.disconnect();}
        publishProgress(90);
        return result;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        ProgressBar pb = (ProgressBar) myActivity.findViewById(R.id.ProgresExplication1);
        pb.setProgress(values[0]);

    }
    @Override
    protected void onPostExecute(String s) {
        TextView text = (TextView) myActivity.findViewById(R.id.Explication1);
        text.setText(s);
        ProgressBar pb = (ProgressBar) myActivity.findViewById(R.id.ProgresExplication1);
        pb.setProgress(100);
        pb.setVisibility(View.INVISIBLE);

    }
    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }
}
