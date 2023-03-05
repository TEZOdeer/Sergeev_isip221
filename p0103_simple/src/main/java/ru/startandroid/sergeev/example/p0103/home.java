package ru.startandroid.sergeev.example.p0103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class home extends Activity {
    //Даю определение tvOut, что оно является TextView
    TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //Вызываю tvOut по его Id (нахожу его в списке R.id)
        tvOut = (TextView) findViewById(R.id.tvOut);
    }

    //Вызываю методы для каждой из кнопок
    public void onClickAuthor(View v) {
        // при нажатии на эту кнопку меняется активный слой (отображаемое окно)
        Intent author = new Intent (home.this, ru.startandroid.sergeev.example.p0103.author.class);
        home.this.startActivity(author);
    }
    public void onClickStart(View v) {
        tvOut.setText("Нажата кнопка START");
    }
    public void onClickStart2(View v) {
        tvOut.setText("Нажата кнопка START2");
    }
    public void onClickPovar(View v) {
        Intent Povar = new Intent(home.this, povar.class);
        home.this.startActivity(Povar);
    }
    public void btnAuthorApp (View v) {
        Intent AuthorApp = new Intent(home.this, author_app.class);
        home.this.startActivity(AuthorApp);
    }

    public void btnRefresh (View v) {
        Intent home = new Intent(home.this, home.class);
        home.this.startActivity(home);
    }

    public void btnExit (View v) {
        this.finishAffinity();
    }
}
