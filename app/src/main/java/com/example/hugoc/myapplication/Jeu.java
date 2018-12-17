package com.example.hugoc.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Jeu extends AppCompatActivity {

    MediaPlayer Hobbits;
    int EtatMusique = 0;

    @Override
    protected void onPause() {
        super.onPause();
        Hobbits.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Hobbits = MediaPlayer.create(this, R.raw.hobbits);


        //SeekBar


        final int MAX = 4;


        final SeekBar seekBarLife = (SeekBar) findViewById(R.id.seekBarLife);
        final SeekBar seekBarStrenght = (SeekBar) findViewById(R.id.seekBarStrenght);
        final SeekBar seekBarDefense = (SeekBar) findViewById(R.id.seekBarDefense);
        final SeekBar seekBarMagic = (SeekBar) findViewById(R.id.seekBarMagic);

        final TextView Life = (TextView) findViewById(R.id.Life);
        final TextView Strenght = (TextView) findViewById(R.id.Strenght);
        final TextView Defense = (TextView) findViewById(R.id.Defense);
        final TextView Magic = (TextView) findViewById(R.id.Magic);


        final TextView TotalText = (TextView) findViewById(R.id.Total);


        // BOUTON JOUER

        final Button BoutonJouer = (Button) findViewById(R.id.BoutonJouer);
        final Button FakeButton = (Button) findViewById(R.id.FakeButton);

        seekBarLife.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Life.setText(progress + "");

                int Total = Integer.parseInt(String.valueOf(Life.getText())) + Integer.parseInt(String.valueOf(Defense.getText())) + Integer.parseInt(String.valueOf(Strenght.getText())) + Integer.parseInt(String.valueOf(Magic.getText()));

                TotalText.setText("Total : " + Total + " (Max = " + MAX + ")");
                if (Total > MAX){
                    TotalText.setTextColor(Color.RED);
                }
                else{
                    TotalText.setTextColor(Color.BLACK);
                }
                if (Total == MAX){
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.buttonshapecolor));
                }
                else{
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.fakebutton));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }});

        seekBarDefense.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Defense.setText(progress + "");

                int Total = Integer.parseInt(String.valueOf(Life.getText())) + Integer.parseInt(String.valueOf(Defense.getText())) + Integer.parseInt(String.valueOf(Strenght.getText())) + Integer.parseInt(String.valueOf(Magic.getText()));

                TotalText.setText("Total : " + Total + " (Max = " + MAX + ")");
                if (Total > MAX){
                    TotalText.setTextColor(Color.RED);
                }
                else{
                    TotalText.setTextColor(Color.BLACK);
                }
                if (Total == MAX){
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.buttonshapecolor));
                }
                else{
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.fakebutton));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }});

        seekBarStrenght.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Strenght.setText(progress + "");

                int Total = Integer.parseInt(String.valueOf(Life.getText())) + Integer.parseInt(String.valueOf(Defense.getText())) + Integer.parseInt(String.valueOf(Strenght.getText())) + Integer.parseInt(String.valueOf(Magic.getText()));

                TotalText.setText("Total : " + Total + " (Max = " + MAX + ")");
                if (Total > MAX){
                    TotalText.setTextColor(Color.RED);
                }
                else{
                    TotalText.setTextColor(Color.BLACK);
                }
                if (Total == MAX){
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.buttonshapecolor));
                }
                else{
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.fakebutton));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }});

        seekBarMagic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Magic.setText(progress + "");

                int Total = Integer.parseInt(String.valueOf(Life.getText())) + Integer.parseInt(String.valueOf(Defense.getText())) + Integer.parseInt(String.valueOf(Strenght.getText())) + Integer.parseInt(String.valueOf(Magic.getText()));

                TotalText.setText("Total : " + Total + " (Max = " + MAX + ")");
                if (Total > MAX){
                    TotalText.setTextColor(Color.RED);
                }
                else{
                    TotalText.setTextColor(Color.BLACK);
                }
                if (Total == MAX){
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.buttonshapecolor));
                }
                else{
                    BoutonJouer.setBackground(getResources().getDrawable(R.drawable.fakebutton));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }});




        // Extras
        Bundle extras = getIntent().getExtras();
        int choix = extras.getInt("choix");
        android.support.constraint.ConstraintLayout Background = (android.support.constraint.ConstraintLayout) findViewById(R.id.Background);

        //Image
        ImageView ImagePersonnage = (ImageView) findViewById(R.id.ImagePersonnage);
        ImagePersonnage.setImageResource(R.drawable.paladin);
        if (choix == 1){
            ImagePersonnage.setImageResource(R.drawable.paladin);
            }
            if (choix == 2){
                ImagePersonnage.setImageResource(R.drawable.mage1);
            }
            if (choix == 3){
                ImagePersonnage.setImageResource(R.drawable.skeleton);
            }


            final Button Jouer = (Button) findViewById(R.id.BoutonJouer);
            Jouer.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int TotalFin = Integer.parseInt(String.valueOf(Life.getText())) + Integer.parseInt(String.valueOf(Defense.getText())) + Integer.parseInt(String.valueOf(Strenght.getText())) + Integer.parseInt(String.valueOf(Magic.getText()));

                    if (TotalFin == MAX) {
                        int Life = seekBarLife.getProgress();
                        int Strengh = seekBarStrenght.getProgress();
                        int Defense = seekBarDefense.getProgress();
                        int Magic = seekBarMagic.getProgress();
                        int[] Attributs = {Life, Strengh, Defense, Magic};

                        debut(Jouer);


                    }
                }
            });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void debut(Button jouer) {
        Debut debut = new Debut(this);
        debut.execute();
    }


    public void playMusic(View view) {
        if (EtatMusique == 0){
            Hobbits.start();
            EtatMusique = 1;
        }
        else{
            Hobbits.pause();
            EtatMusique = 0;
        }
    }
}
