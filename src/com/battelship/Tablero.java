package com.battelship;

import java.util.Random;

import com.battelship.utils.Constants;

public class Tablero {

	int numeroBarcosPoscionados = Constants.TOTAL_BARCOS;
	int[][] tablero = new int[Constants.TAMAÑO_TABLERO][Constants.TAMAÑO_TABLERO];

	public Tablero() {
		iniciarTablero();

	}

	private void iniciarTablero() {
		System.out.print("Tablero Iniciado!");

	}

	public void mostrarTablero() {
		System.out.print("Muestra Tablero!");

	}

	public void insertarPosicion(Posicion posicionTest) {

		tablero[posicionTest.getX()][posicionTest.getY()] = 1;

	}

	public int[][] getTablero() {
		return tablero;
	}

	public void insertarPosicionRandom(Posicion testPosicion) {

		tablero[testPosicion.getX()][testPosicion.getY()] = 1;
	}

	public void insertarBarco(Posicion posicionTest) {

		for (int i = 0; i < posicionTest.getTamaño(); i++) {

			tablero[posicionTest.getX() + i][posicionTest.getY()] = 2;

		}

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

	public void protecionBarco() {
		System.out.print("Protecion Activada!");

	}

	public Posicion generaPosicion() {

		Random rn = new Random();
		int x = rn.nextInt(10) + 1;
		int y = rn.nextInt(10) + 1;
		Posicion pos = new Posicion(x, y);
		return pos;

	}

	public Object generarOrientacion() {

		Random rn = new Random();
		int x = rn.nextInt(4) + 0;
		int y = rn.nextInt(4) + 0;
		Posicion pos = new Posicion(x, y);
		return pos;
	}

}
