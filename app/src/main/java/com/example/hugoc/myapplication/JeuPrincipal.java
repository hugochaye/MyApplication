package com.example.hugoc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.Thread.sleep;

public class JeuPrincipal extends AppCompatActivity {




    //Timer
    private static final long START_TIME_IN_MILLIS = 2100000000;
    private TextView CountDown;
    private CountDownTimer Timer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private ImageButton Monster;
    private ProgressBar MonsterLife;
    private TextView GoldInGame;
    private int Niveau;
    private TextView NiveauInGame;
    private int Gold;


    // Extras


    private int Life;
    private int Strenght;
    private int Defense;
    private int Magic;

    private int LifeA;
    private int StrenghtA;
    private int DefenseA;
    private int MagicA;

    private ProgressBar LifeInGame;
    private ProgressBar StrenghtInGame;
    private ProgressBar DefenseInGame;
    private ProgressBar MagicInGame;

    private Button LifeButton;
    private Button StrenghtButton;
    private Button DefenseButton;
    private Button MagicButton;
    private Button Shop;



    private int Maximum;
    private int VieMonstre;
    private int VieMonstreInGame;
    private int degat;

    private int QuelleMonstre;


    Isaac isaac = new Isaac(this);

    private boolean sauvegarde;

    private float Xmax;

    SensorManager m;
    private capteur accelerometre;

    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_principal);

        prefs = getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();

        Niveau = prefs.getInt("Niveau", 0);
        Gold = prefs.getInt("Gold", 0);
        LifeA = prefs.getInt("LifeA", 1);
        StrenghtA = prefs.getInt("StrenghtA", 1);
        DefenseA = prefs.getInt("DefenseA", 1);
        MagicA = prefs.getInt("MagicA", 1);
        Maximum = prefs.getInt("Maximum", 100);
        VieMonstre =prefs.getInt( "VieMonstre",100);
        degat = prefs.getInt( "degat", 0);

        QuelleMonstre = prefs.getInt("QuelleMonstre", 1);




        NiveauInGame = (TextView) findViewById(R.id.Niveau);
        NiveauInGame.setText("" + Niveau);
        CountDown = (TextView) findViewById(R.id.CountDown);
        CountDown.setText(VieMonstre + "");
        MonsterLife = (ProgressBar) findViewById(R.id.MonsterLife);
        MonsterLife.setMax(VieMonstre);
        VieMonstreInGame = prefs.getInt("VieMonstreInGame", VieMonstre);
        MonsterLife.setProgress(VieMonstreInGame);

        //Musique
        Combat(MonsterLife);


        //Attributs

        Bundle extras = getIntent().getExtras();
        int[] Attributs = extras.getIntArray("Attributs");
        Life = prefs.getInt("Life", Attributs[0]);
        Strenght = prefs.getInt("Strenght", Attributs[1]);
        Defense = prefs.getInt("Defense", Attributs[2]);
        Magic = prefs.getInt("Magic", Attributs[3]);


        LifeInGame = (ProgressBar) findViewById(R.id.Life);
        LifeInGame.setMax(Maximum);
        LifeInGame.setProgress(Life);

        StrenghtInGame = (ProgressBar) findViewById(R.id.Strenght);
        StrenghtInGame.setMax(Maximum);
        StrenghtInGame.setProgress(Strenght);

        DefenseInGame = (ProgressBar) findViewById(R.id.Defense);
        DefenseInGame.setMax(Maximum);
        DefenseInGame.setProgress(Defense);

        MagicInGame = (ProgressBar) findViewById(R.id.Magic);
        MagicInGame.setMax(Maximum);
        MagicInGame.setProgress(Magic);

        m = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Toast.makeText(this, "FIGHT !", Toast.LENGTH_LONG).show();

        m.registerListener(accelerometre, SensorManager.SENSOR_ACCELEROMETER);
        GoldInGame = (TextView) findViewById(R.id.Gold);
        Gold = prefs.getInt("Gold", 0);
        GoldInGame.setText(Gold + "");


        Xmax = 10;

        m.registerListener(new SensorEventListener() {
                               public void onSensorChanged(SensorEvent event) { // TODO method stub
                                   if (event.values[0] > Xmax){
                                       if (MonsterLife.getProgress() >0 ) {

                                           VieMonstreInGame = MonsterLife.getProgress() - 1 - Strenght - Life;
                                           MonsterLife.setProgress(VieMonstreInGame);
                                           editor.putInt("VieMonstreInGame", VieMonstreInGame);
                                           editor.commit();
                                           Gold += 1 + Defense;
                                           editor.putInt("Gold", Gold);
                                           editor.commit();
                                           GoldInGame.setText(Gold + "");
                                           CountDown.setText(MonsterLife.getProgress() + "");




                                       }

                                       if (MonsterLife.getProgress() <=0 ){
                                           VieMonstre*=1000;
                                           editor.putInt("VieMonstre", VieMonstre);
                                           editor.commit();
                                           VieMonstreInGame = VieMonstre;
                                           editor.putInt("VieMonstreInGame", VieMonstreInGame);
                                           editor.commit();
                                           CountDown.setText(VieMonstre + "");
                                           MonsterLife.setMax(VieMonstre);
                                           MonsterLife.setProgress(VieMonstre);
                                           Defense*=2;
                                           editor.putInt("Defense", Defense);
                                           editor.commit();
                                           Gold += QuelleMonstre;
                                           GoldInGame.setText(Gold + "");
                                           editor.putInt("Gold", Gold);
                                           editor.commit();
                                           QuelleMonstre *=1000;
                                           Niveau+=1;
                                           NiveauInGame.setText("" + Niveau);
                                           editor.putInt("Niveau", Niveau);
                                           editor.commit();
                                       }
                                   }

                               }

                               public void onAccuracyChanged(Sensor sensor, int accuracy) { // TODO
                               }
                           }
                , m.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                , SensorManager.SENSOR_DELAY_UI);



        LifeButton = (Button) findViewById(R.id.buttonLife);
        LifeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold > LifeA){
                    LifeInGame.setProgress(LifeInGame.getProgress() + LifeA);
                    Life+=LifeA;
                    editor.putInt("Life", Life);
                    editor.commit();
                    Gold -=LifeA;
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    GoldInGame.setText(Gold + "");
                    LifeA*=10;
                    editor.putInt("LifeA", LifeA);
                    editor.commit();
                    LifeButton.setText("Life + " + LifeA);
                }


            }
        });
        StrenghtButton = (Button) findViewById(R.id.buttonStrenght);
        StrenghtButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= StrenghtA){
                    StrenghtInGame.setProgress(StrenghtInGame.getProgress() + StrenghtA);
                    Strenght+=StrenghtA;
                    editor.putInt("Strenght", Strenght);
                    editor.commit();
                    Gold -=StrenghtA;
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    GoldInGame.setText(Gold + "");
                    StrenghtA*=10;
                    editor.putInt("StrenghtA", StrenghtA);
                    editor.commit();
                    StrenghtButton.setText("Strenght + " + StrenghtA);
                }


            }
        });
        ////////////
        //MAGIE
        ////////////

        MagicButton = (Button) findViewById(R.id.buttonMagic);

        startTimer();

        MagicButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold > MagicA){
                    MagicInGame.setProgress(MagicInGame.getProgress() + MagicA);
                    Magic+=MagicA;
                    editor.putInt("Magic", Magic);
                    editor.commit();
                    Gold -=MagicA;
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    GoldInGame.setText(Gold + "");
                    MagicA*=10;
                    editor.putInt("MagicA", MagicA);
                    editor.commit();
                    MagicButton.setText("Magic + " + MagicA);
                }


            }
        });





        Monster = (ImageButton) findViewById(R.id.Monster);
        Monster.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Punch(Monster);

                if (MonsterLife.getProgress() >0 ) {

                    MonsterLife.setProgress(MonsterLife.getProgress() - 1 - Strenght - Life);
                    Gold += 1 + Defense;
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    GoldInGame.setText(Gold + "");
                    CountDown.setText(MonsterLife.getProgress() + "");




                }

                if (MonsterLife.getProgress() <=0 ){
                    VieMonstre*=1000;
                    editor.putInt("VieMonstre", VieMonstre);
                    editor.commit();
                    CountDown.setText(VieMonstre + "");
                    MonsterLife.setMax(VieMonstre);
                    MonsterLife.setProgress(VieMonstre);
                    Defense+=1;
                    editor.putInt("Defense", Defense);
                    editor.commit();
                    Gold += QuelleMonstre;
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    GoldInGame.setText(Gold + "");
                    QuelleMonstre *=100;
                    editor.putInt("QuelleMonstre", QuelleMonstre);
                    editor.commit();
                    Niveau+=1;
                    editor.putInt("Niveau", Niveau);
                    editor.commit();
                    NiveauInGame.setText("" + Niveau);
                }




/*
                // LA IL FAUT CHOPER LES CARACTERISTIQUES RENTREE PAR LE JOUEUR
                if (MonsterLife.getProgress() >0 ){
                    MonsterLife.setProgress(MonsterLife.getProgress() - 1 - Strenght);
                }
                if (MonsterLife.getProgress() <= 0){
                    Gold += 1 + Defense;
                    GoldInGame.setText(Gold + "");
                    QuelleMonstre += 1;
                    if (QuelleMonstre == 11){
                        Timer.cancel();
                        mTimeLeftInMillis = 21000;
                        QuelleMonstre = 0;
                        Amelioration += 1;
                        Niveau += 1;
                        AmeliorationInGame.setText(Amelioration + "");
                        Monster.setImageResource(R.drawable.m1);
                    }
                    else{
                        MonsterLife.setProgress(10 + Niveau);
                        MonsterLife.setMax(10 + Niveau);
                        CountDown.setText("");
                    }


                    if (QuelleMonstre == 1) {
                        Monster.setImageResource(R.drawable.m1);
                    }
                    if (QuelleMonstre == 2) {
                        Monster.setImageResource(R.drawable.m2);
                    }
                    if (QuelleMonstre == 3) {
                        Monster.setImageResource(R.drawable.m3);
                    }
                    if (QuelleMonstre == 4) {
                        Monster.setImageResource(R.drawable.m4);
                    }
                    if (QuelleMonstre == 5) {
                        Monster.setImageResource(R.drawable.m5);
                    }
                    if (QuelleMonstre == 6) {
                        Monster.setImageResource(R.drawable.m6);
                    }
                    if (QuelleMonstre == 7) {
                        Monster.setImageResource(R.drawable.m7);
                    }
                    if (QuelleMonstre == 8) {
                        Monster.setImageResource(R.drawable.m8);
                    }
                    if (QuelleMonstre == 9) {
                        Monster.setImageResource(R.drawable.m9);
                    }
                    if (QuelleMonstre == 10) {
                        Monster.setImageResource(R.drawable.m10);
                        MonsterLife.setMax(100);
                        MonsterLife.setProgress(100);
                        startTimer();
                    }


                }
*/
            }
        });


        Shop = (Button) findViewById(R.id.Shop);
        Shop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent Epicerie = new Intent(getApplicationContext(), Magasin.class);
                Epicerie.putExtra("Gold", Gold);
                startActivity(Epicerie);
            }
        });


    }



    public void startTimer(){
        Timer = new CountDownTimer(mTimeLeftInMillis, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }



    public void updateTimer(){

        int entier = Integer.parseInt(CountDown.getText().toString());
        degat = Magic;
        CountDown.setText(entier - degat + "");
        MonsterLife.setProgress(Integer.parseInt(CountDown.getText().toString()));
        if (Integer.parseInt(CountDown.getText().toString()) <= 0){

        }
    }


    public void Punch(View view) {
        AsyncGold asyncGold = new AsyncGold(this);
        asyncGold.execute();

    }

    public void Combat(View view) {

        isaac.execute();

    }

    @Override
    protected void onPause() {
        isaac.Musique.stop();
        super.onPause();

    }


    @Override
    protected void onResume() {
        Gold = prefs.getInt("Gold", 0);
        GoldInGame.setText(Gold + "");
        super.onResume();

    }






}
