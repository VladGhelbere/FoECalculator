package com.example.FoECalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper gbDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gbDB = new DatabaseHelper(this);
    }

    public void buttonPress(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(MainActivity.this, GB_Chooser.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, GvG_Calculator.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this, GB_bonus_calculator.class));
                break;
            case R.id.button5:
                System.exit(0);
                break;
        }
    }
}
