package com.battelship.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.battelship.main.Posicion;



/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Posición
 */
public class PosicionTest {

	/*
	 * Test de caja negra para asegurar que el constructor setea correctamente los parametros
	 */
	@Test
	public void testConstructor() {
		Posicion posicion = new Posicion(0, 0);
		assertEquals(posicion.getX(), 0);
		assertEquals(posicion.getY(), 0);
	}
	
	/*
	 * Test de caja negra del metodo getOrientacionString
	 * particiones equivalentes (-inf, 0), [0, 3], [4, inf)
	 * frontera 0, 3
	 * limites: -1, 1, 3, 4
	 */
	@Test
	public void testOrientacion() {
		Posicion posicion = new Posicion(0, 0);
		posicion.setOrientacion(0);
		assertEquals(posicion.getOrientacionString(), "Derecha");
		posicion.setOrientacion(1);
		assertEquals(posicion.getOrientacionString(), "Abajo");
		posicion.setOrientacion(2);
		assertEquals(posicion.getOrientacionString(), "Arriba");
		posicion.setOrientacion(3);
		assertEquals(posicion.getOrientacionString(), "Izquierda");
		posicion.setOrientacion(-1);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
		posicion.setOrientacion(4);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
	}

}