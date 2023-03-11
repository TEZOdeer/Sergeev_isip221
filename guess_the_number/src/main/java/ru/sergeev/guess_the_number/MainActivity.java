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
    EditText etinput;
    Button Btn;
    Button Restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvinfo = (TextView) findViewById(R.id.tvinfo);
        etinput = (EditText) findViewById(R.id.etinput);
        Btn = (Button) findViewById(R.id.Btn);
        Restart = (Button) findViewById(R.id.Restart);
        Restart.setEnabled(false);
    }



    public void BtnClick(View v) {
        int guess = (int) (Math.random() * 10);
        boolean gameFinished = false;
        if (!gameFinished) {
            //int value= Integer.parseInt(etinput.getText().toString());
            int value = Integer.parseInt(etinput.getText().toString());

            if (TextUtils.isEmpty(etinput.getText().toString())) {
                return;
            }
            else if (value > 100 | value < 1)
                tvinfo.setText(R.string.correct);
            else if (value > guess)
                tvinfo.setText(R.string.ahead);
            else if (value < guess)
                tvinfo.setText(R.string.behind);
            else if (value == guess) {
                tvinfo.setText(R.string.hit);
                gameFinished = true;
            }
        }
        if (gameFinished==true) {
            Btn.setEnabled(false);
            Restart.setEnabled(true);
            etinput.setEnabled(false);
        }

    }
    public void Exit (View v) {
        finishAffinity();
    }
    protected boolean isEmpty(EditText etinput) {
        return (etinput.getText().toString().equals(""));
    }
    public void again (View v) {
        Intent Main = new Intent(this, MainActivity.class);
        this.startActivity(Main);
    }
}