package ru.sergeev.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] countries = {"Япония", "Россия", "Польша", "Швейцария", "Уругвай"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        setListAdapter(adapter);


        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    switch (position) {
                        case 0:
                            Intent Japan = new Intent(MainActivity.this, ru.sergeev.listview.Japan.class);
                            startActivity(Japan);
                            break;
                        case 1:
                            Intent Russia = new Intent(MainActivity.this, ru.sergeev.listview.Russia.class);
                            startActivity(Russia);
                            break;
                        case 2:
                            Intent Poland = new Intent(MainActivity.this, ru.sergeev.listview.Poland.class);
                            startActivity(Poland);
                            break;
                        case 3:
                            Intent Switzerland = new Intent(MainActivity.this, ru.sergeev.listview.Switzerland.class);
                            startActivity(Switzerland);
                            break;
                        case 4:
                            Intent Uruguay = new Intent(MainActivity.this, ru.sergeev.listview.Uruguay.class);
                            startActivity(Uruguay);
                            break;
                    }

                }
                Toast.makeText(getApplicationContext(), "Вы выбрали " +
                        parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }


        };
        getListView().setOnItemClickListener(itemListener);
    }


}