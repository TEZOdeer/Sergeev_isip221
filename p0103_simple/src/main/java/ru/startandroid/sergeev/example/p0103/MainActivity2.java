package ru.startandroid.sergeev.example.p0103;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azaza);
    }

    public void onClickPrevious(View v) {
        Intent home = new Intent(MainActivity2.this, MainActivity.class);
        MainActivity2.this.startActivity(home);
    }
}