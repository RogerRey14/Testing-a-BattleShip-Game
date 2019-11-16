package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;
import com.battelship.utils.Constants;

public class Jugador implements IJugador {

	String name;
	private Tablero propio;
	private Tablero enemigo;
	int tipoJugador;

	public Tablero getPropio() {
		return propio;
	}

	public Jugador(int i, String name, IManagerIO managerIO) {
		this.tipoJugador = i;
		this.name = name;
		this.propio = new Tablero(managerIO);
		this.enemigo = new Tablero(managerIO);
		posicionarBarcos();
	}

	public String getName() {
		return name;
	}

	public int getTipoJugador() {
		return tipoJugador;
	}

	public void posicionarBarcos() {

		if (tipoJugador == 1) {
			System.out.println("Jugador: " + name + "\nPosiciona tus barcos!");
			for (int i = 0; i < Constants.LISTA_BARCOS.length; i++) {
				System.out.println(
						"Posicion (X,Y) cabeza del barco que ocupa " + Constants.LISTA_BARCOS[i] + " cuadrados (1/1)");

				propio.insertPosicion(Constants.LISTA_BARCOS[i]);
				propio.mostrarTablero();

			}
		} else {

			System.out.println("Maquina: " + name + "\nPosicionando sus barcos de manera aleatoria!");
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

		if (tipoJugador == 1) {
			System.out.println("Jugador => " + name + " ATACANTE!!!");
			System.out.println("Que posicion quieres atacar?");

			enemigo.atacar(jugador);
			enemigo.mostrarTablero();

		} else {
			System.out.println("Maquina => " + name + " ATACA ALEATORIAMENTE!");
			enemigo.atacarRandom(jugador);
			enemigo.mostrarTablero();

		}

	}

}