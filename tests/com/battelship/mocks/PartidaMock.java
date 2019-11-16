package com.battelship.mocks;

import com.battelship.main.intefaces.IPartida;

class PartidaMock implements IPartida {

	JugadorMock userPlayer ;
	JugadorMock randomIA ;
	boolean finalJuego = false;
	boolean turnoJugador = true;

	public PartidaMock(JugadorMock player1, JugadorMock player2) {

		this.userPlayer = player1;
		this.randomIA = player2;

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

	public void printGanador() {
		if (userPlayer.ganador()) {
			System.out.println("Ganador de la partida " + userPlayer.name + "!!!");
		} else {
			System.out.println("Ganador de la partida " + randomIA.name + "!!!");
		}
	}

}
