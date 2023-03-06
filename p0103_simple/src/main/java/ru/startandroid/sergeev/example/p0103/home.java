package ru.startandroid.sergeev.example.p0103;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kotlin.internal.DynamicExtension;

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

    public void btnAuthorApp (View v) {
        Intent AuthorApp = new Intent(home.this, author_app.class);
        home.this.startActivity(AuthorApp);
    }

    public void btnRefresh (View v) {
        Intent home = new Intent(home.this, home.class);
        home.this.startActivity(home);
    }


    public void btnDY(View v) {
        Intent DY = new Intent();
        DY.setAction(Intent.ACTION_VIEW);
        DY.addCategory(Intent.CATEGORY_BROWSABLE);
        DY.setData(Uri.parse("https://do.yakse.ru/"));
        startActivity(DY);
    }

    public void btnExit (View v) {
        this.finishAffinity();
    }
}
