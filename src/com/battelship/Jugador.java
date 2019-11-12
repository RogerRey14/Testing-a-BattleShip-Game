package com.battelship;

public class Jugador {

	private int tipo;
	private String nombre;

	public Jugador(int tipo, String nombre) {

		this.tipo = tipo;
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String posicionarBarco() {

		if (this.tipo == 1) {
			return "Barco Posicionado!";
		} else
			return "Barco Posicionado Aleatoriamente!";

	}

	public String atacar() {
		if (this.tipo == 1) {
			return "Atacando!";
		} else
			return "Atacando Aleatoriamente!";

	}

}
