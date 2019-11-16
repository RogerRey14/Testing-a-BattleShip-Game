package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;
import com.battelship.main.intefaces.IPartida;


public class Partida implements IPartida {

	IManagerIO managerIO;

	Jugador userPlayer;
	Jugador randomIA;

	boolean finalJuego = false;
	boolean turnoJugador = true;

	public Partida(IManagerIO managerIO) {

		this.userPlayer = new Jugador(1, "Jugador", managerIO);
		this.randomIA = new Jugador(2, "RandomIA", managerIO);
		this.empezarPartida();

	}

	public void printGanador() {
		if (userPlayer.ganador()) {
			System.out.println("Ganador de la partida " + userPlayer.getName() + "!!!");
		} else {
			System.out.println("Ganador de la partida " + randomIA.getName() + "!!!");
		}
	}

	public void empezarPartida() {

		while (!finalJuego) {

			if (turnoJugador) {
				userPlayer.atacar(randomIA);
				turnoJugador = false;
			} else {
				randomIA.atacar(userPlayer);
				turnoJugador = true;
			}

			if (userPlayer.ganador() || randomIA.ganador()) {
				finalJuego = true;
			}
		}
		printGanador();
	}
}