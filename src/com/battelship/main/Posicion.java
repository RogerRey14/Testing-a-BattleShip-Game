package com.battelship.main;

/*
 * Clase que se encarga de controlar la posición la orientación y el tamaño del barco
 */
public class Posicion {
	int x;
	int y;
	int orientacion;
	int tamaño;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Posicion() {
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
	
	public int getOrientacion() {
		return orientacion;
	}
	
	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
	}
	
	public int getTamaño() {
		return tamaño;
	}
	
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
	/*
	 * Convierte el codigo de orientación a lenguaje natural
	 */
	public String getOrientacionString() {		
		switch(this.orientacion) {
		case 0: return "Derecha";
		case 1: return "Abajo";
		case 2: return "Arriba";
		case 3: return "Izquierda";
		default: return "No tiene orientacion";
		}
	}
	
	/*
	 * Sobreescritura del metodo toString para representar la información de una posición
	 */
	@Override
	public String toString() {
		return "Posicion [x=" + (x+1) + ", y=" + (y+1) + ", orientacion=" + getOrientacionString() + "]";
	}	
	
}