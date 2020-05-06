package com.example.parcial2bd;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class RegistrarUsuario extends AppCompatActivity  {

    EditText cedula,nombre,salario;
    Spinner estrato,nivel_educativo;
    Button guardar;
    String[] estrato1;
    String seleccionado;

    String[] nivel_educativo1;
    String seleccionado2;

    Controller c;

    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario);

        cedula = findViewById(R.id.editText_cedula);
        nombre = findViewById(R.id.editText_nombre);
        salario = findViewById(R.id.editText_salario);
        estrato1 = getResources().getStringArray(R.array.Estratos);
        c = new Controller(getApplicationContext());

        guardar = findViewById(R.id.button_guardar);

        estrato = findViewById(R.id.spinner_estrato);
        nivel_educativo = findViewById(R.id.spinner_NE);
        nivel_educativo1 = getResources().getStringArray(R.array.niveleducativo);

        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,R.array.Estratos,android.R.layout.simple_dropdown_item_1line);
        estrato.setAdapter(adapter);

        estrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccionado = estrato1[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapter1 =  ArrayAdapter.createFromResource(this,R.array.niveleducativo,android.R.layout.simple_dropdown_item_1line);
        nivel_educativo.setAdapter(adapter1);

        nivel_educativo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccionado2 = nivel_educativo1[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario(cedula.getText().toString(),nombre.getText().toString(),seleccionado, salario.getText().toString(), seleccionado2);

                if(!c.buscarUsuario(usuario.getCedula())) {
                    Log.d("Buscar", "No encontrado");
                    long id = c.agregarUsuario(usuario);
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Buscar", "encontrado");
                    Toast.makeText(getApplicationContext(),"Estudiante ya esta registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}
