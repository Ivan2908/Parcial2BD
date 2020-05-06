package com.example.parcial2bd;

public class Usuario {
    public String cedula;
    public String nombre;
    public String estrato;
    public String salario;
    public String nivel_educativo;

    public Usuario() {
    }

    public Usuario(String cedula, String nombre, String estrato, String salario, String nivel_educativo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.nivel_educativo = nivel_educativo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNivel_educativo() {
        return nivel_educativo;
    }

    public void setNivel_educativo(String nivel_educativo) {
        this.nivel_educativo = nivel_educativo;
    }
}
