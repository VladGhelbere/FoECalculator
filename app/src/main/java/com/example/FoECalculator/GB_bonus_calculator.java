package com.example.FoECalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GB_bonus_calculator extends AppCompatActivity implements View.OnClickListener{

    private Button compute_button;
    private TextView output_text;
    private EditText input_text;
    String text;
    String exceptionMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb_bonus_calculator);

        compute_button= findViewById(R.id.gb_calculator_compute);
        output_text= findViewById(R.id.gb_calculator_output_text);
        input_text= findViewById(R.id.gb_calculator_input_text);

        compute_button.setOnClickListener(this);

    }

    public void onClick(View v) {
            if(v.getId()==compute_button.getId()){
                try {
                    text = input_text.getText().toString();
                    closekeyboard();
                    double text_int = Integer.parseInt(text);
                    text_int = Math.ceil(text_int * 1.9);
                    text = Double.toString(text_int);
                    output_text.setText(text);
                } catch(NumberFormatException e) {
                    // in case of no input
                    exceptionMessage = "NumberFormatException";
                    Toast.makeText(getApplicationContext(), "Please insert a number", Toast.LENGTH_SHORT).show();
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
