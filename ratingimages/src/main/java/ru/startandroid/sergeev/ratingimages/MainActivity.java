package ru.startandroid.sergeev.ratingimages;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }
/*
    public void btnDislike (View v) {
        Intent home = new Intent(MainActivity.this, MainActivity.class);
        MainActivity.this.startActivity(home);
    }

    public void btnLike (View v) {
        Intent home = new Intent(MainActivity.this, MainActivity.class);
        MainActivity.this.startActivity(home);
    }
 */
}