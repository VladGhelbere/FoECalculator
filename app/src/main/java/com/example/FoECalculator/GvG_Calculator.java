package com.example.FoECalculator;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GvG_Calculator extends AppCompatActivity {

    DatabaseHelper db;
    private EditText input_text;
    private TextView output;
    String sectors;
    String exceptionMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv_g__calculator);


        input_text = findViewById(R.id.input_sector_number);
        output = findViewById(R.id.output);
        db = new DatabaseHelper(this);
    }

    public void onClick(View v) {
        try {
            sectors = input_text.getText().toString();

            Cursor cursor = db.getData2("gvg_table",sectors);
            closekeyboard();

            if (sectors.matches("")){
                Toast.makeText(getApplicationContext(), "Please insert a number", Toast.LENGTH_SHORT).show();
            }
            else {
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Choose a number between 0 and 50", Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor.moveToNext()) {
                        output.setText(cursor.getString(1));
                    }
                }
            }

        } catch(NumberFormatException e) {
            // in case of no input
            exceptionMessage = "NumberFormatException";
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
