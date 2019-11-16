package com.battelship.main;

import com.battelship.main.intefaces.IJugador;
import com.battelship.main.intefaces.IManagerIO;
import com.battelship.utils.Constants;

public class Jugador implements IJugador {

	String nombre;
	int tipo;
	private Tablero propio;
	public Tablero enemigo;
	

	public Tablero getPropio() {
		return propio;
	}

	public Jugador(int i, String name, IManagerIO managerIO) {
		this.tipo = i;
		this.nombre = name;
		this.propio = new Tablero(managerIO);
		this.enemigo = new Tablero(managerIO);
		posicionarBarcos();
	}


	public void posicionarBarcos() {

		if (tipo == 1) {
			System.out.println("Jugador: " + nombre + "\nPosiciona tus barcos!");
			for (int i = 0; i < Constants.LISTA_BARCOS.length; i++) {
				System.out.println(
						"Posicion (X,Y) cabeza del barco que ocupa " + Constants.LISTA_BARCOS[i] + " cuadrados (1/1)");

				propio.insertPosicion(Constants.LISTA_BARCOS[i]);
				propio.mostrarTablero();

			}
		} else {

			System.out.println("Maquina: " + nombre + "\nPosicionando sus barcos de manera aleatoria!");
			for (int i = 0; i < Constants.LISTA_BARCOS.length; i++) {

				propio.insertPosicionRandom(Constants.LISTA_BARCOS[i]);
				// propio.mostrarTablero();

			}
		}

	}

	public boolean ganador() {
		if (enemigo.numeroBarcosPoscionados == 0) {
			return true;
		}
		return false;
	}

	public void atacar(IJugador jugador) {

		if (tipo == 1) {
			System.out.println("Jugador => " + nombre + " ATACANTE!!!");
			System.out.println("Que posicion quieres atacar?");

			enemigo.atacar(jugador);
			enemigo.mostrarTablero();

		} else {
			System.out.println("Maquina => " + nombre + " ATACA ALEATORIAMENTE!");
			enemigo.atacarRandom(jugador);
			enemigo.mostrarTablero();

		}

	}

	
	public String getNombre() {
		return nombre;
	}


	public int getTipo() {
		return tipo;
	}

}