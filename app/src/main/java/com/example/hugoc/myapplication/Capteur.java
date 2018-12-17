package com.example.hugoc.myapplication;

import android.hardware.SensorListener;

class capteur implements SensorListener {

    float x, y, z;

    public void onSensorChanged(int sensor, float[] values) {
        x = values[0];

        y = values[1];

        z = values[2];
    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }

};
