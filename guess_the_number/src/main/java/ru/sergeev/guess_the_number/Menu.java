package ru.sergeev.guess_the_number;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    Button BtnEasy;
    Button BtnNormal;
    Button BtnHard;
    Button BtnCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        BtnEasy = (Button) findViewById(R.id.BtnEasy);
        BtnNormal = (Button) findViewById(R.id.BtnNormal);
        BtnHard = (Button) findViewById(R.id.BtnHard);
        BtnCustom = (Button) findViewById(R.id.BtnCustom);
        BtnCustom.setEnabled(true);
        BtnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Easy = new Intent(Menu.this, Easy.class);
                Menu.this.startActivity(Easy);
                overridePendingTransition(0, 0);
            }
        });

        BtnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Normal = new Intent(Menu.this, Normal.class);
                Menu.this.startActivity(Normal);
                overridePendingTransition(0, 0);
            }
        });
        BtnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Hard = new Intent(Menu.this, Hard.class);
                Menu.this.startActivity(Hard);
                overridePendingTransition(0, 0);
            }
        });
    }
    public void Exit (View v) {
        finishAffinity();
        overridePendingTransition(0, 0);
    }
    public void About (View v) {
        Intent About = new Intent(this, ru.sergeev.guess_the_number.About.class);
        this.startActivity(About);
        overridePendingTransition(0, 0);

    }

    public void BtnCustom (View v) {
        Intent Custom = new Intent(this, ru.sergeev.guess_the_number.Custom.class);
        startActivity(Custom);
        overridePendingTransition(0, 0);
    }

    /*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnEasy:
                Intent Easyl = new Intent(Menu.this, Easy.class);
                Menu.this.startActivity(Easyl);
                break;
            case R.id.BtnNormal:
                Intent Normall = new Intent(Menu.this, Normal.class);
                Menu.this.startActivity(Normall);
                break;
            case R.id.BtnHard:
                Intent Hardl = new Intent(Menu.this, Hard.class);
                Menu.this.startActivity(Hardl);
        }
    }
     */

    /*public void easyl (View v) {
        Intent Easy = new Intent(Menu.this, Easy.class);
        Menu.this.startActivity(Easy);
    }
    public void normall (View v) {
        Intent Normal = new Intent(Menu.this, Normal.class);
        Menu.this.startActivity(Normal);
    }
    public void hardl(View v) {
        Intent Hard = new Intent(Menu.this, Hard.class);
        Menu.this.startActivity(Hard);
    }
     */
}
