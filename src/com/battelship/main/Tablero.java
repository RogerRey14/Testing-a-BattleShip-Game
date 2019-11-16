package com.battelship.main;

import java.util.Random;

import com.battelship.utils.Constants;

public class Tablero {

	int numeroBarcosPoscionados = Constants.TOTAL_BARCOS;
	int[][] tablero = new int[Constants.TAMA�O_TABLERO][Constants.TAMA�O_TABLERO];

	public String mostrarTablero() {
		return "Muestra Tablero!";
	}

	public String iniciarTablero() {

		return "Tablero Iniciado!";
	}

	public void insertarPosicion(Posicion posicionTest) {
		tablero[posicionTest.getX()][posicionTest.getY()] = 1;

	}

	public void insertarPosicionRandom(Posicion testPosicion) {

		tablero[testPosicion.getX()][testPosicion.getY()] = 1;

	}

	public int[][] crearTablero() {
		return tablero;
	}

	public Boolean sePuedeInsertarOrientacion(Posicion posicionTest) {

		switch (posicionTest.getOrientacion()) {
		case 0:
			return true;

		case 1:
			return true;

		case 2:
			return true;

		case 3:
			return true;

		}
		return null;

	}

	public String protecionBarco() {
		return "Protecion Activada";
	}

	public Object generarOrientacion() {
		Random rn = new Random();
		int x = rn.nextInt(10) + 1;
		int y = rn.nextInt(10) + 1;
		Posicion pos = new Posicion(x, y);
		return pos;
	}

	public Object generaPosicion() {
		Random rn = new Random();
		int x = rn.nextInt(4) + 0;
		int y = rn.nextInt(4) + 0;
		Posicion pos = new Posicion(x, y);
		return pos;
	}

	public String insertarBarco() {
		return "Barco Insertado!";
	}

}
