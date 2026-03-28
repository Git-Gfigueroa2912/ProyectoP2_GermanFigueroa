package com.mycompany.proyectop2germanfigueroa;

import java.io.Serializable;
import java.util.ArrayList;

public class Metodo implements Serializable {

    private String nombre;
    private String desc;
    private String retorno;
    private String alcance;
    private ArrayList<Variable> parametros;

    public Metodo(String nombre, String retorno, String alcance) {
        this.nombre = nombre;
        this.desc = "";
        this.retorno = retorno;
        this.alcance = alcance;
        this.parametros = new ArrayList<>();
    }

    public Metodo(String nombre, String retorno, String alcance, ArrayList<Variable> parametros) {
        this.nombre = nombre;
        this.desc = "";
        this.retorno = retorno;
        this.alcance = alcance;
        this.parametros = parametros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return desc;
    }

    public void setDescripcion(String desc) {
        this.desc = desc;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public ArrayList<Variable> getParametros() {
        return parametros;
    }

    public void addParametro(Variable variable) {
        if (variable != null) {
            this.parametros.add(variable);
        }
    }

    public String generarCodigo() {
        String listaDeParametros = "";
        for (int i = 0; i < parametros.size(); i++) {
            Variable parametro = parametros.get(i);
            listaDeParametros += parametro.getTipo() + " " + parametro.getNombre();
            if (i < parametros.size() - 1) {
                listaDeParametros += ", ";
            }
        }
        return "    " + alcance + " " + retorno + " " + nombre + "(" + listaDeParametros + ") {\n\n    }";
    }

    @Override
    public String toString() {
        return "(" + retorno + ") " + nombre;
    }

}
