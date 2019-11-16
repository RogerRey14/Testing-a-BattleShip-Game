package com.battelship.main.intefaces;

import com.battelship.main.Tablero;

public interface IJugador {
	
	public Tablero getPropio();
	public void posicionarBarcos();
	public boolean  ganador();
	public void atacar(IJugador jugador);
}
