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
		
		//Contrustor inputs 
		Posicion posicion = new Posicion(0, 0);
		assertEquals(posicion.getX(), 0);
		assertEquals(posicion.getY(), 0);
		
		//Construsctor empty
		Posicion posicionTest = new Posicion();
		posicionTest.setX(0);
		posicionTest.setY(0);
		posicionTest.setTamaño(2);
		assertEquals(posicionTest.getX(), 0);
		assertEquals(posicionTest.getY(), 0);
		assertEquals(posicionTest.getTamaño(), 2);
		assertEquals(posicionTest.toString(), "Posicion [x=1, y=1, orientacion=Derecha]");
		
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
		assertEquals(posicion.getOrientacion(), 0);
		posicion.setOrientacion(1);
		assertEquals(posicion.getOrientacionString(), "Abajo");
		assertEquals(posicion.getOrientacion(), 1);
		posicion.setOrientacion(2);
		assertEquals(posicion.getOrientacionString(), "Arriba");
		assertEquals(posicion.getOrientacion(), 2);
		posicion.setOrientacion(3);
		assertEquals(posicion.getOrientacionString(), "Izquierda");
		assertEquals(posicion.getOrientacion(), 3);
		posicion.setOrientacion(-1);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
		posicion.setOrientacion(4);
		assertEquals(posicion.getOrientacionString(), "No tiene orientacion");
	}
	
	


}