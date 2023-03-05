package ru.startandroid.sergeev.example.p0103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class author_app extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_app);
    }

    public void btnPrevious3 (View v) {
        Intent home = new Intent(author_app.this, ru.startandroid.sergeev.example.p0103.home.class);
        author_app.this.startActivity(home);
    }
}