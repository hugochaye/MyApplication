package com.example.hugoc.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FichePersonnage extends AppCompatActivity {


    private ImageButton Personnage;
    private TextView Explication1;
    private ProgressBar pb1;
    private String lien = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Paladin";
    private int boutonPerso = 0;

    final int[] PersonnageChoisi = {1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fiche_personnage);


        pb1 = (ProgressBar) findViewById(R.id.ProgresExplication1);
        pb1.setVisibility(View.INVISIBLE);
        Personnage = (ImageButton) findViewById(R.id.ImagePersonnage);
        Explication1 = (TextView) findViewById(R.id.Explication1);

        PersonnageChoisi[0] = 1;


        //Bouton Paladin
        final Button Paladin = (Button) findViewById(R.id.button1);
        Paladin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Explication1.setText("");
                Personnage.setVisibility(View.VISIBLE);
                Personnage.setImageResource(R.drawable.paladin);
                PersonnageChoisi[0] = 1;
                lien = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Paladin";

            }
        });

        //Bouton Mage
        final Button Mage = (Button) findViewById(R.id.button2);
        Mage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Explication1.setText("");
                Personnage.setVisibility(View.VISIBLE);
                Personnage.setImageResource(R.drawable.mage1);
                PersonnageChoisi[0] = 2;
                lien = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Magician_(fantasy)";
            }
        });

        //Bouton Skeleton
        final Button Skeleton = (Button) findViewById(R.id.button3);
        Skeleton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Explication1.setText("");
                Personnage.setVisibility(View.VISIBLE);
                Personnage.setImageResource(R.drawable.skeleton);
                PersonnageChoisi[0] = 3;
                lien = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Skeleton";
            }
        });


        Personnage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Personnage.setVisibility(View.INVISIBLE);
                pb1.setVisibility(View.VISIBLE);
                Click(Personnage);


            }
        });

        // Prochaine activite
        final Button Jouer = (Button) findViewById(R.id.Jouer);
        Jouer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent Jeu = new Intent(getApplicationContext(), Jeu.class);

                // Login

                int choix = PersonnageChoisi[0];
                Jeu.putExtra("choix", choix);

                startActivity(Jeu);
            }
        });



    }


    public void Click(View view) {
        if (PersonnageChoisi[0] == 1){
            Paladin paladin1 = new Paladin(this);
            paladin1.execute();
        }
        if (PersonnageChoisi[0] == 2){
            Mage mage1 = new Mage(this);
            mage1.execute();
        }
        if (PersonnageChoisi[0] == 3){
            Skeleton skeleton1 = new Skeleton(this);
            skeleton1.execute();
        }

    }

}

