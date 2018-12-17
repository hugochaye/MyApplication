package com.example.hugoc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;



public class MainActivity extends AppCompatActivity {

    private int boutonPaladin = 0;
    private ImageView PaladinD;
    private TextView Explication;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("JFL", "Une ligne de log");

        pb = (ProgressBar) findViewById(R.id.ProgresExplication);
        pb.setVisibility(View.INVISIBLE);
    PaladinD = (ImageView) findViewById(R.id.PaladinAccueil);
    Explication = (TextView) findViewById(R.id.Explication);

        // Bouton Informe
        final Button Informe = (Button) findViewById(R.id.Informe);
        Informe.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*Intent page2 = new Intent(getApplicationContext(), Informer.class);
                startActivity(page2);*/
                if (boutonPaladin == 0){
                    PaladinD.setVisibility(View.INVISIBLE);
                    pb.setVisibility(View.VISIBLE);
                    Click(Informe);
                    boutonPaladin = 1;

                }
                else{
                    PaladinD.setVisibility(View.VISIBLE);
                    Explication.setText("");
                    boutonPaladin = 0;
                }


            }
        });
        // Bouton Création Personnage
        final Button Perso = (Button) findViewById(R.id.CreationPersonnage);
        Perso.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ficheperso = new Intent(getApplicationContext(), FichePersonnage.class);

                startActivity(ficheperso);
            }
        });

        // Bouton pour quitter
        Button QuitButton = (Button) findViewById(R.id.QuitButton);
        QuitButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

    }

    public void Click(View view) {
        AsyncHTTP asyncHTTP = new AsyncHTTP(this);
        asyncHTTP.execute();
    }
}