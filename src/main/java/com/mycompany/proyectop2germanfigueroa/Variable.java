package com.mycompany.proyectop2germanfigueroa;

import java.io.Serializable;

public class Variable implements Serializable {

    private final String tipo;
    private final String nombre;
    private String alcance;

    public Variable(String tipo, String nombre, String alcance) {
	this.tipo = tipo;
	this.nombre = nombre;
	this.alcance = alcance;
    }

    public String getTipo() {
	return tipo;
    }

    public String getNombre() {
	return nombre;
    }

    public String getAlcance() {
	return alcance;
    }

    public void setAlcance(String alcance) {
	this.alcance = alcance;
    }

    @Override
    public String toString() {
	return String.format("(%s) %s", tipo, nombre);
    }
}
