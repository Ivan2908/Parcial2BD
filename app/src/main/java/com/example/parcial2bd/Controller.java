package com.example.parcial2bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Controller {

    private ConexionSQLiteHelper db;

    public Controller(Context context) {
        this.db = new ConexionSQLiteHelper(context);
    }

    public long agregarUsuario(Usuario e){
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefinicionBD.col_cedula,e.getCedula());
            valores.put(DefinicionBD.col_nombre,e.getNombre());
            valores.put(DefinicionBD.col_estrato,e.getEstrato());
            valores.put(DefinicionBD.col_salario,e.getSalario());
            valores.put(DefinicionBD.col_nivel_educativo,e.getNivel_educativo());
            long id = database.insert(DefinicionBD.tabla,null,valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }

    public boolean buscarUsuario(String cod){
        String[] args = new String[] {cod};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("prueba", null, "cedula=?", args, null, null, null);
        if (c.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}

    }


    public long actualizarUsuario(Usuario e){

        try{
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            String[] args = new String[] {e.getCedula()};
            valores.put(DefinicionBD.col_nombre,e.getNombre());
            valores.put(DefinicionBD.col_estrato,e.getEstrato());
            valores.put(DefinicionBD.col_salario,e.getSalario());
            valores.put(DefinicionBD.col_nivel_educativo,e.getNivel_educativo());
            long id = database.update(DefinicionBD.tabla, valores,"cedula=?",args);
            database.close();
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al actualizar");
            return 0;
        }

    }

    public Cursor Listar() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select cedula as _id, nombre, estrato, salario, nivel_educativo from prueba", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public Cursor ConsultarUsuario(String parametro) {

        String[] campos= {DefinicionBD.col_nombre,DefinicionBD.col_estrato,DefinicionBD.col_salario,DefinicionBD.col_nivel_educativo};
        String[] parametros = {parametro};
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cur = database.query(DefinicionBD.tabla,campos,"cedula=?",parametros,null,null,null);
        return cur;

    }

}
