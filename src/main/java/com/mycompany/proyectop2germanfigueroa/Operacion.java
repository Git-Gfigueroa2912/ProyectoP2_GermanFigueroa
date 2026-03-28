package com.mycompany.proyectop2germanfigueroa;

import java.io.Serializable;


public class Operacion implements Serializable{

    private String operador;
    private Variable var1;
    private Variable var2;
    private Variable resultado;

    public Operacion(String operador, Variable var1, Variable var2, Variable resultado) {
	this.operador = operador;
	this.var1 = var1;
	this.var2 = var2;
	this.resultado = resultado;
    }

    public String getOperador() {
	return operador;
    }

    public void setOperador(String operador) {
	this.operador = operador;
    }

    public Variable getVar1() {
	return var1;
    }

    public void setVariable1(Variable var1) {
	this.var1 = var1;
    }

    public Variable getVariable2() {
	return var2;
    }

    public void setVariable2(Variable var2) {
	this.var2 = var2;
    }

    public Variable getResultado() {
	return resultado;
    }

    public void setResultado(Variable resultado) {
	this.resultado = resultado;
    }

    @Override
    public String toString() {
	return resultado.getNombre() + " = " + var1.getNombre() + " " + operador + " " + var2.getNombre() + ";";
    }

}
