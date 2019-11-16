package com.battelship.main;

public class Jugador {

	private String nombre;
	private int tipo;

	public Jugador(int tipoHumano, String nombreJugador) {
		tipo = tipoHumano;
		nombre = nombreJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public String posicionarBarco() {
		if (tipo == 1) {
			return "Barco Posicionado!";
		} else
			return "Barco Posicionado Aleatoriamente!";
	}

	public String atacar() {
		if (tipo == 1) {
			return "Atacando!";
		} else
			return "Atacando Aleatoriamente!";
	}

}
