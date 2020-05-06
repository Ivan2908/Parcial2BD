package com.example.parcial2bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class consultar extends AppCompatActivity {

    Controller c;
    ConexionSQLiteHelper con;
    EditText ingrearcampo,nombre,salario;
    Spinner estrato,nivel_educativo;
    Button buscar,actualizar,eliminar;


    String[] estrato1;
    String seleccionado;

    String[] nivel_educativo1;
    String seleccionado2;

    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_total);

        c = new Controller(getApplicationContext());
        con = new ConexionSQLiteHelper(getApplicationContext());

        ingrearcampo = findViewById(R.id.editText_ingresarcedula);
        buscar = findViewById(R.id.button_BUSCAR);
        nombre = findViewById(R.id.editText_NOMBRESALIO);
        salario = findViewById(R.id.editText_SALARIOAC);
        estrato = findViewById(R.id.spinner_ESTRATO);
        estrato1 = getResources().getStringArray(R.array.Estratos);
        actualizar = findViewById(R.id.button_ACTUALIZAR);
        eliminar = findViewById(R.id.button_ELIMINAR);

        nivel_educativo= findViewById(R.id.spinner2_NE) ;
        nivel_educativo1=getResources().getStringArray(R.array.niveleducativo);


        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(getApplicationContext(),R.array.Estratos,android.R.layout.simple_dropdown_item_1line);
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



        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Cursor cur = c.ConsultarUsuario(ingrearcampo.getText().toString());
                    cur.moveToFirst();
                    nombre.setText(cur.getString(0));
                    int uno3 = uno1(cur.getString(1));
                    estrato.setSelection(uno3);
                    salario.setText(cur.getString(2));
                    int uno4 = dos2(cur.getString(3));
                    nivel_educativo.setSelection(uno4);
                }catch (Exception e) {
                    System.out.println("Error al consultar");
                }
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();

                usuario.setCedula(ingrearcampo.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                usuario.setEstrato(seleccionado);
                usuario.setSalario(salario.getText().toString());
                usuario.setNivel_educativo(seleccionado2);

                long id = c.actualizarUsuario(usuario);
                Toast.makeText(getApplicationContext(),"Usuario actualizado", Toast.LENGTH_SHORT).show();
                
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = con.getWritableDatabase();
                String[] args ={ingrearcampo.getText().toString()};

                database.delete(DefinicionBD.tabla,"cedula=?",args);
                Toast.makeText(getApplicationContext(),"Se elimino el Usuario",Toast.LENGTH_LONG).show();
                ingrearcampo.setText("");
                limpiar();
                database.close();


            }
        });



    }

    private void limpiar() {
        nombre.setText("");
        salario.setText("");
    }

    public int uno1 (String Estrato) {
        switch (Estrato){
            case "1":
                return 0;
            case "2":
                return 1;
            case "3":
                return 2;
            case "4":
                return 3;
            case "5":
                return 4;
            case " 6":
                return 5;
        }
        return 0;
    };
    public int dos2 (String NivelEducativo) {
        switch (NivelEducativo){
            case "Bachillerato":
                return 0;
            case "Pregrado":
                return 1;
            case "Maestria":
                return 2;
            case "Doctorado":
                return 3;
        }
        return 0;
    };

}



