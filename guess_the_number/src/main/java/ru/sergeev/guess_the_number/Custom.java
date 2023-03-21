package ru.sergeev.guess_the_number;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Custom extends AppCompatActivity {
    EditText min_value;
    EditText max_value;
    EditText tries_count;
    Button Start;
    int min;
    int max;
    int tries;
    int guess;
    TextView tvinfo_min;
    TextView tvinfo_max;
    TextView tvinfo_tries;
    boolean full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);
        min_value = (EditText) findViewById(R.id.min_value);
        max_value = (EditText) findViewById(R.id.max_value);
        tries_count = (EditText) findViewById(R.id.tries_count);
        Start = (Button) findViewById(R.id.Start);
        tvinfo_min = (TextView) findViewById(R.id.tvinfo_min);
        tvinfo_max = (TextView) findViewById(R.id.tvinfo_max);
        tvinfo_tries = (TextView) findViewById(R.id.tvinfo_tries);
        guess = 0;
        full = false;


    }

    public void Start(View v) {
        full = false;
        try {
            min = Integer.parseInt(min_value.getText().toString());
            max = Integer.parseInt(max_value.getText().toString());
            tries = Integer.parseInt(tries_count.getText().toString());
            full = true;
        } catch (NumberFormatException exception) {
            Start.setText(R.string.correct_start);
            full = false;
        }


        if (min >= max) {
            Start.setText(R.string.correct_start);
            full = false;
        }
        if (tries <=0) {
            Start.setText(R.string.correct_start);
            full = false;
        }


        if (full) {
            Intent Start = new Intent(this, Custom_gameplay.class);
            Start.putExtra("min", min);
            Start.putExtra("max", max);
            Start.putExtra("tries", tries);
            startActivity(Start);
            overridePendingTransition(0, 0);
        }
    }
        public void Exit (View v){
            finishAffinity();
            overridePendingTransition(0, 0);
        }
        public void Back (View v){
            Intent Back = new Intent(this, Menu.class);
            this.startActivity(Back);
            overridePendingTransition(0, 0);
        }
}