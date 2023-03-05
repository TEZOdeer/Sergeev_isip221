package ru.startandroid.sergeev.example.p0103;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
    }


    public void onClickStart(View v) {
        tvOut.setText("Нажата кнопка Start");
    }
    public void onClickStart2(View v) {
        tvOut.setText("Нажата кнопка Start2");
    }
    public void onClickAzaza(View v) {
        tvOut.setText("Нажата кнопка Azaza");
    }
}