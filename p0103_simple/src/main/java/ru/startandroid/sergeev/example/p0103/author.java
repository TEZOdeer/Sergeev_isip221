package ru.startandroid.sergeev.example.p0103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class author extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author);
    }

    public void onClickPrevious(View v) {
        Intent home = new Intent(author.this, ru.startandroid.sergeev.example.p0103.home.class);
        author.this.startActivity(home);
    }
}