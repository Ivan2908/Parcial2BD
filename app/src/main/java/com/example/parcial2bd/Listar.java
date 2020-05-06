package com.example.parcial2bd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Listar extends AppCompatActivity {

    ListView listado;
    Controller c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);
        listado = findViewById(R.id.ListView);

        c = new Controller(getApplicationContext());

        Cursor cur = c.Listar();

        ListarCedulas eca = new ListarCedulas(this,cur,0);
        listado.setAdapter(eca);
        eca.notifyDataSetChanged();

    }


}
