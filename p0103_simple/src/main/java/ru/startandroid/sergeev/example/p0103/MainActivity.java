package ru.startandroid.sergeev.example.p0103;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    //Даю определение tvOut, что оно является TextView
    TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Вызываю tvOut по его Id (нахожу его в списке R.id)
        tvOut = (TextView) findViewById(R.id.tvOut);
    }

    //Вызываю методы для каждой из кнопок
    public void onClickNextLayout(View v) {
        // при нажатии на эту кнопку меняется активный слой (отображаемое окно)
        Intent author = new Intent(MainActivity.this, MainActivity2.class);
        MainActivity.this.startActivity(author);
    }
    public void onClickStart(View v) {
        tvOut.setText("Нажата кнопка Start");
    }
    public void onClickStart2(View v) {
        tvOut.setText("Нажата кнопка Start2");
    }
}
