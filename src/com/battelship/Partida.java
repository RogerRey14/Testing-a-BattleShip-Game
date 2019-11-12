package com.battelship;

public class Partida {

	Jugador userPlayer;
	Jugador randomIA;
	boolean finalJuego = false;
	boolean turnoJugador = true;

	public Partida() {

		this.userPlayer = new Jugador(1, "Jugador");
		this.randomIA = new Jugador(2, "RandomIA");

	}

	public Jugador getUserPlayer() {
		return userPlayer;
	}

	public Jugador getRandomIA() {
		return randomIA;
	}

	public boolean isFinalJuego() {
		return finalJuego;
	}

	public boolean isTurnoJugador() {
		return turnoJugador;
	}

	public void empezarPartida() {
		System.out.println("Partida Empezada!");

	}

	public String mostrarGanador() {
		return userPlayer.getNombre();

	}

}
