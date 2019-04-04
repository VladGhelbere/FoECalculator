package com.example.FoECalculator;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GB_Calculator extends AppCompatActivity {

    DatabaseHelper db;
    private EditText input_text;
    String lvl;

    private TextView total;
    private TextView self_donated;

    private TextView place1x1;
    private TextView place2x1;
    private TextView place3x1;
    private TextView place4x1;
    private TextView place5x1;

    private TextView place1x2;
    private TextView place2x2;
    private TextView place3x2;
    private TextView place4x2;
    private TextView place5x2;

    private TextView place1x3;
    private TextView place2x3;
    private TextView place3x3;
    private TextView place4x3;
    private TextView place5x3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb__calculator);

        input_text= findViewById(R.id.input1);

        total = findViewById(R.id.total);
        self_donated = findViewById(R.id.self_donated);

        place1x1 = findViewById(R.id.t1x1);
        place2x1 = findViewById(R.id.t2x1);
        place3x1 = findViewById(R.id.t3x1);
        place4x1 = findViewById(R.id.t4x1);
        place5x1 = findViewById(R.id.t5x1);

        place1x2 = findViewById(R.id.t1x2);
        place2x2 = findViewById(R.id.t2x2);
        place3x2 = findViewById(R.id.t3x2);
        place4x2 = findViewById(R.id.t4x2);
        place5x2 = findViewById(R.id.t5x2);

        place1x3 = findViewById(R.id.t1x3);
        place2x3 = findViewById(R.id.t2x3);
        place3x3 = findViewById(R.id.t3x3);
        place4x3 = findViewById(R.id.t4x3);
        place5x3 = findViewById(R.id.t5x3);

        db = new DatabaseHelper(this);
    }

    public void onClick(View v) {
        lvl = input_text.getText().toString();
        if (lvl.matches("")) {
            Toast.makeText(getApplicationContext(), "Please insert a number", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = getIntent();
            String chosed = i.getStringExtra("chosed");
            Cursor cursor = db.getData1("gb_table", chosed, lvl);
            closekeyboard();
            if (cursor.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "Choose a level between 1 and 80", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {

                    total.setText(cursor.getString(2));
                    self_donated.setText(cursor.getString(3));

                    place1x1.setText(cursor.getString(4));
                    place2x1.setText(cursor.getString(5));
                    place3x1.setText(cursor.getString(6));
                    place4x1.setText(cursor.getString(7));
                    place5x1.setText(cursor.getString(8));

                    place1x2.setText(cursor.getString(9));
                    place2x2.setText(cursor.getString(10));
                    place3x2.setText(cursor.getString(11));
                    place4x2.setText(cursor.getString(12));
                    place5x2.setText(cursor.getString(13));

                    place1x3.setText(cursor.getString(14));
                    place2x3.setText(cursor.getString(15));
                    place3x3.setText(cursor.getString(16));
                    place4x3.setText(cursor.getString(17));
                    place5x3.setText(cursor.getString(18));

                }
            }
        }
    }


    private void closekeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}