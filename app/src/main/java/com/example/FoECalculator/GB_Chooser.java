package com.example.FoECalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GB_Chooser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb__chooser);
    }

    public void buttonPress(View v) {
        startActivity(new Intent(GB_Chooser.this, GB_Calculator.class).putExtra("chosed",v.getTag().toString()));
    }
}
