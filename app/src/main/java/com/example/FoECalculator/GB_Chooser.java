package com.example.FoECalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GB_Chooser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb__chooser);
    }

    public void buttonPress(View v) {
        switch (v.getId()) {
            case R.id.Arc:
                startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed","THE ARC"));
                break;
            case R.id.Alcatraz:
                startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed","ALCATRAZ"));
                break;
            case R.id.Zeus:
                startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed","ZEUS"));
                break;
            case R.id.Aachen:
                startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed","AACHEN"));
                break;
            case R.id.Monte:
                startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed","MONTE"));
                break;
        }
    }
}
