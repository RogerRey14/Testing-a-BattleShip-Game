package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;

public class Partida {

	Jugador userPlayer;
	Jugador randomIA;
	boolean finalJuego = false;
	boolean turnoJugador = true;

	public Partida() {

		this.userPlayer = new Jugador(1, "Jugador");
		this.randomIA = new Jugador(2, "RandomIA");

	}

	public Partida(IManagerIO managerIO) {
		// TODO Auto-generated constructor stub
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

	public String empezarPartida() {
		return "Partida Empezada!";

	}

	public String mostrarGanador() {
		return userPlayer.getNombre();

	}

}
