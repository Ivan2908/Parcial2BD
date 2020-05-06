package com.example.parcial2bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View v) {
        Intent miIntent=null;

        switch (v.getId()) {
            case R.id.RUSER:
                miIntent = new Intent(MainActivity.this, RegistrarUsuario.class);
                startActivity(miIntent);
                break;
            case R.id.LIST_ID:
                miIntent = new Intent(MainActivity.this, Listar.class);
                startActivity(miIntent);
                break;
            case R.id.SEARCH_ID:
                miIntent = new Intent(MainActivity.this, consultar.class);
                startActivity(miIntent);
                break;
        }
    }
}
