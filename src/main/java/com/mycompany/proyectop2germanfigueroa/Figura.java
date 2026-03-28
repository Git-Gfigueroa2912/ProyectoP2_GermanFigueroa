package com.mycompany.proyectop2germanfigueroa;

import java.awt.Font;
import java.io.Serializable;

public class Figura implements Serializable {

    private final TipoFigura tipo;
    private String texto;
    private String colorFondo;
    private int x, y;
    private int ancho, alto;
    private int tamanoLetra;
    private String fuente;
    private int estiloLetra;

    public Figura(TipoFigura tipo, String texto, String colorFondo,
	    int x, int y, int ancho, int alto) {
	this.tipo = tipo;
	this.texto = texto;
	this.colorFondo = colorFondo;
	this.x = x;
	this.y = y;
	this.ancho = ancho;
	this.alto = alto;
	this.tamanoLetra = 12;
	this.fuente = "Arial";
	this.estiloLetra = Font.PLAIN;
    }

    public Figura(TipoFigura tipo, String texto) {
	this(tipo, texto, "#23120b", 15, 15, 125, 50);
    }

    public TipoFigura getTipo() {
	return tipo;
    }

    public String getTexto() {
	return texto;
    }

    public void setTexto(String texto) {
	this.texto = texto;
    }

    public String getColorFondo() {
	return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
	this.colorFondo = colorFondo;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getAncho() {
	return ancho;
    }

    public void setAncho(int ancho) {
	this.ancho = ancho;
    }

    public int getAlto() {
	return alto;
    }

    public void setAlto(int alto) {
	this.alto = alto;
    }

    public int getTamanoLetra() {
	return tamanoLetra;
    }

    public void setTamanoLetra(int tamanoLetra) {
	this.tamanoLetra = tamanoLetra;
    }

    public String getFuente() {
	return fuente;
    }

    public void setFuente(String fuente) {
	this.fuente = fuente;
    }

    public int getEstiloLetra() {
	return estiloLetra;
    }

    public void setEstiloLetra(int estiloLetra) {
	if (estiloLetra >= 0 && estiloLetra <= 2) {
	    this.estiloLetra = estiloLetra;
	}
    }

    public String obtenerCodigo() {
	String codigo = "";
	switch (tipo) {
	    case TipoFigura.INICIO -> {
		codigo = "public class Main {\n    public static void main(String[] args) {\n";
	    }
	    case TipoFigura.FIN -> {
		codigo = "    \n}\n}";
	    }
	    case TipoFigura.PROCESO -> {
		codigo = String.format("    %s;\n", texto);
	    }
	    case TipoFigura.DECISION -> {
		codigo = String.format("    if (%s) {\n    } else {\n    }", texto);
	    }
	    case TipoFigura.BUCLE_FOR -> {
		codigo = String.format("    for (%s) {\n    }", texto);
	    }
	    case TipoFigura.BUCLE_WHILE -> {
		codigo = String.format("    while(%s) {\n    }", texto);
	    }
	    case TipoFigura.IMPRESION_PANTALLA -> {
		codigo = String.format("    System.out.println(\"%s\");", texto);
	    }
	    default -> {
		codigo = "";
	    }
	}
	return codigo;
    }

}
