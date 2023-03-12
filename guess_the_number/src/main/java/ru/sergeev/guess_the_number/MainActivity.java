package ru.sergeev.guess_the_number;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvinfo;
    TextView lifes_count;
    EditText etinput;
    Button Btn;
    Button Restart;
    int guess;
    int value;
    boolean gameFinished;
    int lifes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvinfo = (TextView) findViewById(R.id.tvinfo);
        etinput = (EditText) findViewById(R.id.etinput);
        Btn = (Button) findViewById(R.id.Btn);
        Restart = (Button) findViewById(R.id.Restart);
        lifes_count = (TextView) findViewById(R.id.lifes_count);
        Restart.setEnabled(false);
        gameFinished = false;
        guess = (int)(Math.random()*10);
        lifes = 3;
        value=-1;
        lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
    }

    public void BtnClick(View v) {
        lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
        try {
            value = Integer.parseInt(etinput.getText().toString());
        } catch (NumberFormatException exception) {
            tvinfo.setText(R.string.error);
        }


        if (!gameFinished) {
            if (value > 10 | value < 0) {
                tvinfo.setText(R.string.correct);
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            }
            else if (value > guess) {
                tvinfo.setText(R.string.ahead);
                lifes --;
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            }
            else if (value < guess) {
                tvinfo.setText(R.string.behind);
                lifes --;
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            }
            else if (value == guess) {
                tvinfo.setText(R.string.hit);
                gameFinished = true;
            }
            else if (value < 0) {
                tvinfo.setText(R.string.correct);
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            }
        }
        else {
            guess = (int) (Math.random() * 10);
            Btn.setText(R.string.input_value);
            tvinfo.setText(R.string.try_to_guess);
            gameFinished = false;
            lifes = 3;
            lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
        }
        if (gameFinished==true) {
            Btn.setEnabled(false);
            Restart.setEnabled(true);
            etinput.setEnabled(false);
            lifes = 3;
            lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
        }
        if (lifes==0) {
            tvinfo.setText(R.string.over);
            Btn.setEnabled(false);
            Restart.setEnabled(true);
            etinput.setEnabled(false);
            lifes_count.setText(String.valueOf(guess));
        }

    }
    public void Exit (View v) {
        finishAffinity();
    }
    public void again (View v) {
        Intent Main = new Intent(this, MainActivity.class);
        this.startActivity(Main);
    }
}
