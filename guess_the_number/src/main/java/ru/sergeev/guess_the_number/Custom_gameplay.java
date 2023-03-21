package ru.sergeev.guess_the_number;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Custom_gameplay extends AppCompatActivity {

    TextView tvinfo;
    TextView lifes_count;
    EditText etinput;
    Button Btn;
    Button Restart;
    int guess;
    int value;
    boolean gameFinished;
    int lifes;
    int minimal;
    int maximal;
    int mini;
    int maxi;
    int tries;
    Button Start;
    TextView tvinfo_min;
    TextView tvinfo_tries;

    private SharedPreferences appPreferences;
    private SharedPreferences.Editor appPreferencesEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        appPreferences = getSharedPreferences("APP_PREFERENCES", MODE_PRIVATE);
        appPreferencesEdit = appPreferences.edit();

        tvinfo = (TextView) findViewById(R.id.tvinfo_min);
        etinput = (EditText) findViewById(R.id.etinput);
        Btn = (Button) findViewById(R.id.Start);
        Restart = (Button) findViewById(R.id.Restart);
        lifes_count = (TextView) findViewById(R.id.tvinfo_tries);
        Restart.setEnabled(false);
        gameFinished = false;
        Start = (Button) findViewById(R.id.Start);
        Bundle arguments = getIntent().getExtras();
        tvinfo_min = (TextView) findViewById(R.id.tvinfo_min);
        tvinfo_tries = (TextView) findViewById(R.id.tvinfo_tries);
        if (arguments != null) {
            minimal = Integer.parseInt(arguments.get("min").toString());
            maximal = Integer.parseInt(arguments.get("max").toString());
            lifes = Integer.parseInt(arguments.get("tries").toString());
            value = -1;
            lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            mini = minimal;
            maxi = maximal;
            tries = lifes;
        }
        tvinfo.setText(getResources().getString(R.string.try_to_guess_first) + String.valueOf(mini) +
                " - " + String.valueOf(maxi) + getResources().getString(R.string.try_to_guess_second));
        etinput.setHint(R.string.hint);
        guess = mini + (int) (Math.random() * ((maxi - mini) + 1));
    }

    public void BtnClick(View v) {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            minimal = Integer.parseInt(arguments.get("min").toString());
            maximal = Integer.parseInt(arguments.get("max").toString());
            mini = minimal;
            maxi = maximal;
            tries = lifes;
        }
        lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
        try {
            value = Integer.parseInt(etinput.getText().toString());
        } catch (NumberFormatException exception) {
            tvinfo.setText(R.string.error);
        }
        if (!gameFinished) {
            if (value > maximal | value < minimal) {
                tvinfo.setText(String.valueOf(getResources().getString(R.string.correct_first) + String.valueOf(mini)
                        + String.valueOf(getResources().getString(R.string.correct_second)) + String.valueOf(maxi)));
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            } else if (value > guess) {
                tvinfo.setText(R.string.ahead);
                lifes--;
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            } else if (value < guess) {
                tvinfo.setText(R.string.behind);
                lifes--;
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            } else if (value == guess) {
                tvinfo.setText(String.valueOf(getResources().getString(R.string.hit)));
                gameFinished = true;
            } else if (value < minimal) {
                tvinfo.setText(String.valueOf(getResources().getString(R.string.correct_first) + String.valueOf(mini)
                        + String.valueOf(getResources().getString(R.string.correct_second)) + String.valueOf(maxi)));
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            }
        } else {
            minimal = Integer.parseInt(arguments.get("min").toString());
            maximal = Integer.parseInt(arguments.get("max").toString());
            lifes = Integer.parseInt(arguments.get("tries").toString());
            value = -1;
            lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
            Btn.setText(R.string.input_value);
            etinput.setHint(R.string.hint);
            tvinfo.setText(getResources().getString(R.string.try_to_guess_first) + String.valueOf(mini) +
                    " - " + String.valueOf(maxi) + getResources().getString(R.string.try_to_guess_second));
            guess = mini + (int) (Math.random() * ((maxi - mini) + 1));
            gameFinished = false;
        }
        if (gameFinished == true) {
            Btn.setEnabled(false);
            Restart.setEnabled(true);
            etinput.setEnabled(false);
            lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
        }
        if (lifes == 0) {
            tvinfo.setText(R.string.over);
            Btn.setEnabled(false);
            Restart.setEnabled(true);
            etinput.setEnabled(false);
            lifes_count.setText(String.valueOf(guess));
        }
    }

    public void Exit(View v) {
        finishAffinity();
        overridePendingTransition(0, 0);
    }

    public void again(View v) {
        gameFinished = false;
        Restart.setEnabled(false);
        Start.setEnabled(true);
        etinput.setText("");
        etinput.setEnabled(true);
        Bundle arguments = getIntent().getExtras();
            if (arguments != null) {
                minimal = Integer.parseInt(arguments.get("min").toString());
                maximal = Integer.parseInt(arguments.get("max").toString());
                lifes = Integer.parseInt(arguments.get("tries").toString());
                value = -1;
                lifes_count.setText(String.valueOf(getResources().getString(R.string.left_lifes) + lifes));
                mini = minimal;
                maxi = maximal;
                tries = lifes;
            }
            tvinfo_min.setText(getResources().getString(R.string.try_to_guess_first) + String.valueOf(mini) +
                    " - " + String.valueOf(maxi) + getResources().getString(R.string.try_to_guess_second));
            etinput.setHint(R.string.hint);
            guess = mini + (int) (Math.random() * ((maxi - mini) + 1));
        }
        public void Change (View v){
            Intent Menu = new Intent(this, ru.sergeev.guess_the_number.Menu.class);
            this.startActivity(Menu);
            overridePendingTransition(0, 0);
        }
    }
