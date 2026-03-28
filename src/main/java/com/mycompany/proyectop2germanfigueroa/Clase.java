package com.mycompany.proyectop2germanfigueroa;

import java.io.Serializable;
import java.util.ArrayList;

public class Clase implements Serializable {

    private String nombre;
    private Clase padre;
    private String descripcion;
    private ArrayList<Variable> propiedades;
    // private ArrayList<Metodo> metodos;

    public Clase(String nombre) {
	this.nombre = nombre;
	this.padre = null;
	this.descripcion = "";
	this.propiedades = new ArrayList();
	// this.metodos = new ArrayList();
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public Clase getPadre() {
	return padre;
    }

    public void setPadre(Clase padre) {
	if (padre == null) {
	    this.padre = padre;
	}
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public ArrayList<Variable> getPropiedades() {
	return propiedades;
    }

    public void setPropiedades(ArrayList<Variable> propiedades) {
	this.propiedades = propiedades;
    }

    public String obtenerCodigo() {
	String codigo = "public class " + nombre + (padre == null ? "" : "extends " + padre.getNombre()) + " {\n";

	codigo += "\n}";
	return codigo;
    }

    @Override
    public String toString() {
	return nombre;
    }

}
