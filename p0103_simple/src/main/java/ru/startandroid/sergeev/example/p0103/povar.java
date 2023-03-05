package ru.startandroid.sergeev.example.p0103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class povar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.povar);
    }

    public void btnPrevious2 (View v) {
        Intent home = new Intent(povar.this, ru.startandroid.sergeev.example.p0103.home.class);
        povar.this.startActivity(home);
    }
}