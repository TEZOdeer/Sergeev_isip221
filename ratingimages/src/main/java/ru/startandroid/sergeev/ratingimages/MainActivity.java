package ru.startandroid.sergeev.ratingimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void btnDislike (View v) {
        Intent home = new Intent(MainActivity.this, MainActivity.class);
        MainActivity.this.startActivity(home);
    }

    public void btnLike (View v) {
        Intent home = new Intent(MainActivity.this, MainActivity.class);
        MainActivity.this.startActivity(home);
    }
}