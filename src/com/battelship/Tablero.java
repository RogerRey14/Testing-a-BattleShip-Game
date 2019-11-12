package com.battelship;

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


	
}
