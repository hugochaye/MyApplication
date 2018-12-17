package com.example.hugoc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Magasin extends AppCompatActivity {

    private ImageButton axe1;
    private ImageButton axe2;
    private ImageButton axe3;
    private ImageButton axe4;
    private ImageButton axe5;
    private ImageButton axe6;
    private ImageButton axe7;
    private ImageButton axe8;
    private ImageButton axe9;
    private ImageButton axe10;
    private ImageButton axe11;
    private ImageButton axe12;

    private TextView prixaxe1;
    private TextView prixaxe2;
    private TextView prixaxe3;
    private TextView prixaxe4;
    private TextView prixaxe5;
    private TextView prixaxe6;
    private TextView prixaxe7;
    private TextView prixaxe8;
    private TextView prixaxe9;
    private TextView prixaxe10;
    private TextView prixaxe11;
    private TextView prixaxe12;

    private int paxe1;
    private int paxe2;
    private int paxe3;
    private int paxe4;
    private int paxe5;
    private int paxe6;
    private int paxe7;
    private int paxe8;
    private int paxe9;
    private int paxe10;
    private int paxe11;
    private int paxe12;



    private TextView Argent;

    private int Gold;

    private int Strenght;

    SharedPreferences.Editor editor;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magasin);

        Bundle extras = getIntent().getExtras();
        Gold = extras.getInt("Gold");

        prefs = getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();

        Argent = (TextView) findViewById(R.id.Argent);
        Argent.setText("Gold : " + Gold);


        paxe1 = prefs.getInt("axe1", 0);
        paxe2 = prefs.getInt("axe2", 0);
        paxe3 = prefs.getInt("axe3", 0);
        paxe4 = prefs.getInt("axe4", 0);
        paxe5 = prefs.getInt("axe5", 0);
        paxe6 = prefs.getInt("axe6", 0);
        paxe7 = prefs.getInt("axe7", 0);
        paxe8 = prefs.getInt("axe8", 0);
        paxe9 = prefs.getInt("axe9", 0);
        paxe10 = prefs.getInt("axe10", 0);
        paxe11 = prefs.getInt("axe11", 0);
        paxe12 = prefs.getInt("axe12", 0);

        axe1 = (ImageButton) findViewById(R.id.axe1);
        axe2 = (ImageButton) findViewById(R.id.axe2);
        axe3 = (ImageButton) findViewById(R.id.axe3);
        axe4 = (ImageButton) findViewById(R.id.axe4);
        axe5 = (ImageButton) findViewById(R.id.axe5);
        axe6 = (ImageButton) findViewById(R.id.axe6);
        axe7 = (ImageButton) findViewById(R.id.axe7);
        axe8 = (ImageButton) findViewById(R.id.axe8);
        axe9 = (ImageButton) findViewById(R.id.axe9);
        axe10 = (ImageButton) findViewById(R.id.axe10);
        axe11 = (ImageButton) findViewById(R.id.axe11);
        axe12 = (ImageButton) findViewById(R.id.axe12);

        prixaxe1 = (TextView) findViewById(R.id.prixaxe1);
        prixaxe2 = (TextView) findViewById(R.id.prixaxe2);
        prixaxe3 = (TextView) findViewById(R.id.prixaxe3);
        prixaxe4 = (TextView) findViewById(R.id.prixaxe4);
        prixaxe5 = (TextView) findViewById(R.id.prixaxe5);
        prixaxe6 = (TextView) findViewById(R.id.prixaxe6);
        prixaxe7 = (TextView) findViewById(R.id.prixaxe7);
        prixaxe8 = (TextView) findViewById(R.id.prixaxe8);
        prixaxe9 = (TextView) findViewById(R.id.prixaxe9);
        prixaxe10 = (TextView) findViewById(R.id.prixaxe10);
        prixaxe11 = (TextView) findViewById(R.id.prixaxe11);
        prixaxe12 = (TextView) findViewById(R.id.prixaxe12);

        if ( paxe1 == 1){
            prixaxe1.setVisibility(View.INVISIBLE);
            axe1.setImageResource(R.drawable.sold);
            axe1.setClickable(false);
        }
        if ( paxe2 == 1){
            prixaxe2.setVisibility(View.INVISIBLE);
            axe2.setImageResource(R.drawable.sold);
            axe2.setClickable(false);
        }
        if ( paxe3 == 1){
            prixaxe3.setVisibility(View.INVISIBLE);
            axe3.setImageResource(R.drawable.sold);
            axe3.setClickable(false);
        }
        if ( paxe4 == 1){
            prixaxe4.setVisibility(View.INVISIBLE);
            axe4.setImageResource(R.drawable.sold);
            axe4.setClickable(false);
        }
        if ( paxe5 == 1){
            prixaxe5.setVisibility(View.INVISIBLE);
            axe5.setImageResource(R.drawable.sold);
            axe5.setClickable(false);
        }
        if ( paxe6 == 1){
            prixaxe6.setVisibility(View.INVISIBLE);
            axe6.setImageResource(R.drawable.sold);
            axe6.setClickable(false);
        }
        if ( paxe7 == 1){
            prixaxe7.setVisibility(View.INVISIBLE);
            axe7.setImageResource(R.drawable.sold);
            axe7.setClickable(false);
        }
        if ( paxe8 == 1){
            prixaxe8.setVisibility(View.INVISIBLE);
            axe8.setImageResource(R.drawable.sold);
            axe8.setClickable(false);
        }
        if ( paxe9 == 1){
            prixaxe9.setVisibility(View.INVISIBLE);
            axe9.setImageResource(R.drawable.sold);
            axe9.setClickable(false);
        }
        if ( paxe10 == 1){
            prixaxe10.setVisibility(View.INVISIBLE);
            axe10.setImageResource(R.drawable.sold);
            axe10.setClickable(false);
        }
        if ( paxe11 == 1){
            prixaxe11.setVisibility(View.INVISIBLE);
            axe11.setImageResource(R.drawable.sold);
            axe11.setClickable(false);
        }
        if ( paxe12 == 1){
            prixaxe12.setVisibility(View.INVISIBLE);
            axe12.setImageResource(R.drawable.sold);
            axe12.setClickable(false);
        }


        // faire ça pour toutes les haches
        axe1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                    if (Gold >= Integer.parseInt(prixaxe1.getText() + "")){
                        prixaxe1.setVisibility(View.INVISIBLE);
                        axe1.setImageResource(R.drawable.sold);
                        axe1.setClickable(false);
                        editor.putInt("axe1", 1);
                        editor.commit();
                        Gold -= Integer.parseInt(prixaxe1.getText() + "");
                        Argent.setText(Gold + "");
                        editor.putInt("Gold", Gold);
                        editor.commit();
                        Argent.setText("Gold : " + Gold);
                        Strenght = prefs.getInt("Strenght", 0);
                        editor.putInt("Strenght", Strenght + 10000);

                    }
            }
        });

        axe2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe2.getText() + "")){
                    prixaxe2.setVisibility(View.INVISIBLE);
                    axe2.setImageResource(R.drawable.sold);
                    axe2.setClickable(false);
                    editor.putInt("axe2", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe2.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 100000);

                }
            }
        });

        axe3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe3.getText() + "")){
                    prixaxe3.setVisibility(View.INVISIBLE);
                    axe3.setImageResource(R.drawable.sold);
                    axe3.setClickable(false);
                    editor.putInt("axe3", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe3.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000);

                }
            }
        });

        axe4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe4.getText() + "")){
                    prixaxe4.setVisibility(View.INVISIBLE);
                    axe4.setImageResource(R.drawable.sold);
                    axe4.setClickable(false);
                    editor.putInt("axe4", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe4.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 100000000);

                }
            }
        });

        axe5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe5.getText() + "")){
                    prixaxe5.setVisibility(View.INVISIBLE);
                    axe5.setImageResource(R.drawable.sold);
                    axe5.setClickable(false);
                    editor.putInt("axe5", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe5.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe6.getText() + "")){
                    prixaxe6.setVisibility(View.INVISIBLE);
                    axe6.setImageResource(R.drawable.sold);
                    axe6.setClickable(false);
                    editor.putInt("axe6", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe6.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 100000000);

                }
            }
        });

        axe7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe7.getText() + "")){
                    prixaxe7.setVisibility(View.INVISIBLE);
                    axe7.setImageResource(R.drawable.sold);
                    axe7.setClickable(false);
                    editor.putInt("axe7", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe7.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe8.getText() + "")){
                    prixaxe8.setVisibility(View.INVISIBLE);
                    axe8.setImageResource(R.drawable.sold);
                    axe8.setClickable(false);
                    editor.putInt("axe8", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe8.getText() + "");
                    Argent.setText(Gold + 33);
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe9.getText() + "")){
                    prixaxe9.setVisibility(View.INVISIBLE);
                    axe9.setImageResource(R.drawable.sold);
                    axe9.setClickable(false);
                    editor.putInt("axe9", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe9.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe10.getText() + "")){
                    prixaxe10.setVisibility(View.INVISIBLE);
                    axe10.setImageResource(R.drawable.sold);
                    axe10.setClickable(false);
                    editor.putInt("axe10", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe10.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe11.getText() + "")){
                    prixaxe11.setVisibility(View.INVISIBLE);
                    axe11.setImageResource(R.drawable.sold);
                    axe11.setClickable(false);
                    editor.putInt("axe11", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe11.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);

                }
            }
        });

        axe12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Gold >= Integer.parseInt(prixaxe12.getText() + "")){
                    prixaxe12.setVisibility(View.INVISIBLE);
                    axe12.setImageResource(R.drawable.sold);
                    axe12.setClickable(false);
                    editor.putInt("axe12", 1);
                    editor.commit();
                    Gold -= Integer.parseInt(prixaxe12.getText() + "");
                    Argent.setText(Gold + "");
                    editor.putInt("Gold", Gold);
                    editor.commit();
                    Argent.setText("Gold : " + Gold);
                    Strenght = prefs.getInt("Strenght", 0);
                    editor.putInt("Strenght", Strenght + 1000000000);
                    editor.commit();

                }
            }
        });




    }

}
