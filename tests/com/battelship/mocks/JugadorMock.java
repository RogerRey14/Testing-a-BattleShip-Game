package com.battelship.mocks;

import com.battelship.main.Tablero;
import com.battelship.main.intefaces.IJugador;

class JugadorMock implements IJugador {

	String name = "TestName";
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atacar(IJugador jugador) {
		// TODO Auto-generated method stub

	}

}
