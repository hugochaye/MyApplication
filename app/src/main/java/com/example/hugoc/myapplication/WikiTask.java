package com.example.hugoc.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

class WikiTask extends AsyncTask<Integer, Void, Integer> {

        private AppCompatActivity myActivity;
        public WikiTask(AppCompatActivity a) {
            myActivity = a;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int res = 1;

            return res;
        }

        @Override
        protected void onPostExecute(Integer res) {
            ProgressBar pb = (ProgressBar)myActivity.findViewById(R.id.progressBar);
            pb.setVisibility(View.GONE);
            TextView resultTV = (TextView)myActivity.findViewById(R.id.Texte);
            resultTV.setText("" + res);


        }
    }

