package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;

public class Jugador {

	private String nombre;
	private int tipo;

	public Jugador(int tipoHumano, String nombreJugador) {
		tipo = tipoHumano;
		nombre = nombreJugador;
	}

	public Jugador(int i, String string, IManagerIO managerIO) {
		// TODO Auto-generated constructor stub
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

	public boolean ganador() {
		// TODO Auto-generated method stub
		return false;
	}

	public void atacar(Jugador userPlayer) {
		// TODO Auto-generated method stub
		
	}

}
