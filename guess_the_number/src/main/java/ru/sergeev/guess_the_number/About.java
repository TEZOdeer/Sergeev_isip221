package ru.sergeev.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void Exit (View v) {
        finishAffinity();
        overridePendingTransition(0, 0);
    }
    public void Back (View v) {
        Intent Back = new Intent(this,Menu.class);
        this.startActivity(Back);
        overridePendingTransition(0, 0);
    }
}