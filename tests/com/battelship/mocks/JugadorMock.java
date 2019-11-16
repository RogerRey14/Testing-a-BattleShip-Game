package com.battelship.mocks;

import com.battelship.main.Tablero;
import com.battelship.main.intefaces.IJugador;
import com.battelship.main.intefaces.IManagerIO;

public class JugadorMock implements IJugador {
	
	String nombre;
	int tipo;
	private Tablero propio;
	private Tablero enemigo;
	
	
	public JugadorMock(int i, String name) {
	
		this.tipo = i;
		this.nombre = name;
	
		posicionarBarcos();
		
	}
	
	
	@Override
	public Tablero getPropio() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void posicionarBarcos() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean ganador() {
		return true;
	}

	@Override
	public void atacar(IJugador jugador) {
		
		if (tipo == 1) {
		
		System.out.println("Jugador Ataca!");

		} else {
			System.out.println("Random Ataca!");

		}

	}


	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public int getTipo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}
}
