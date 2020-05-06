package com.example.parcial2bd;

public class DefinicionBD {

    public static final String nameDb = "Almacenamiento";
    public static final String tabla= "prueba";
    public static final String col_cedula = "cedula";
    public static final String col_nombre = "nombre";
    public static final String col_estrato = "estrato";
    public static final String col_salario = "salario";
    public static final String col_nivel_educativo = "nivel_educativo";

    public static final String create_Cedulas = "CREATE TABLE IF NOT EXISTS prueba (" +
            "  cedula TEXT PRIMARY KEY," +
            "  nombre TEXT," +
            "  estrato TEXT," +
            "  salario TEXT," +
            "  nivel_educativo TEXT" +
            ");";

}
