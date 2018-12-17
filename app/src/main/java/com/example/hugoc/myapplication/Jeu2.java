package com.example.hugoc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Jeu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        VideoView Video = (VideoView) findViewById(R.id.video);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(Video);
        String lien = "rtsp://r1---sn-4g5edne7.googlevideo.com/Cj0LENy73wIaNAl8nON3drsnIhMYDSANFC1i_OFbMOCoAUIASARgoODtiKTiottbigELUEpfUmR0bmsyaHMM/09BBAD17156814B4D6360F5F9BC3C06F6EF034C4.7BBA6647C5FE5361A146072100CED57155EDEBAC/yt6/1/video.3gp";
        Uri uri=Uri.parse(lien);
        Video.setMediaController(mediaController);
        Video.setVideoURI(uri);
        Video.requestFocus();
        Video.start();

        Button Bouton = (Button) findViewById(R.id.BoutonCompris);
        Bouton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent JeuC = new Intent(getApplicationContext(), JeuPrincipal.class);
                // Extras
                Bundle extras = getIntent().getExtras();
                int[] Attributs = extras.getIntArray("Attributs");

                JeuC.putExtra("Attributs", Attributs);
                startActivity(JeuC);

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

}
