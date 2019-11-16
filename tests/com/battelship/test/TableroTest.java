package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.battelship.main.Posicion;
import com.battelship.main.Tablero;



/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Tablero
 */
public class TableroTest {



	/*
	 * Test comprueba que se crea una Tablero correctamente
	 */
	@Test
	public void testCreateTablero() {
		
		Tablero tableroTest = new Tablero();
		assertEquals(tableroTest.iniciarTablero(),"Tablero Iniciado!");

	}

	/*
	 * Test comprueba que se muestra un Tablero correctamente
	 */
	@Test
	public void testMostrarTablero() {

		Tablero tableroTest = new Tablero();
		assertEquals(tableroTest.mostrarTablero(),"Muestra Tablero!");

	}

	/*
	 * Test comprueba que se inserta correctamente una posicion en el Tablero
	 * 
	 */
	@Test
	public void testInsertarPosicion() {


		Posicion posicionTest = new Posicion(0, 0);
		posicionTest.setOrientacion(0);

		Tablero tableroTest = new Tablero();
		tableroTest.insertarPosicion(posicionTest);
		int[][] tablero = tableroTest.crearTablero();

		assertTrue(tablero[0][0] == 1);
		assertFalse(tablero[0][1] == 1);
		assertFalse(tablero[1][0] == 1);
	}

	/*
	 * Test que comprueba la insercion de una posicion aleatoria
	 * 
	 */
	@Test
	public void testInsertPosicionRandom() {

		
		
		Random rn = new Random();
		Tablero tableroTest = new Tablero();
		int x = rn.nextInt(10) + 1;
		int y = rn.nextInt(10) + 1;
		Posicion testPosicion = new Posicion(x, y);
		tableroTest.insertarPosicionRandom(testPosicion);
		int[][] tablero = tableroTest.crearTablero();

		assertTrue(tablero[x][y] == 1);
	}

	/*
	 * Test comprueba si puedes insertar a partir de una orientacion y el tama�o del
	 * barco
	 * 
	 */
	@Test
	public void testSePuedeInsertarOrientacion() {

		Posicion posicionTest = new Posicion(0, 0);
		posicionTest.setOrientacion(0);
		posicionTest.setTamaño(2);

		Tablero tableroTest = new Tablero();
		assertTrue(tableroTest.sePuedeInsertarOrientacion(posicionTest));
		posicionTest.setOrientacion(1);
		assertTrue(tableroTest.sePuedeInsertarOrientacion(posicionTest));
		posicionTest.setOrientacion(2);
		assertTrue(tableroTest.sePuedeInsertarOrientacion(posicionTest));
		posicionTest.setOrientacion(3);
		assertTrue(tableroTest.sePuedeInsertarOrientacion(posicionTest));
		posicionTest.setOrientacion(4);
		assertNull(tableroTest.sePuedeInsertarOrientacion(posicionTest));

	}

	/*
	 * Test Poner margen de proteccion al barco (1 Cuadrado)
	 * 
	 */
	@Test
	public void testProtecionBarco() {

		Tablero tableroTest = new Tablero();
		assertEquals(tableroTest.protecionBarco(),"Protecion Activada");

	}

	/*
	 * Test Genera Orientacion Aleatoria
	 * 
	 */
	@Test
	public void testGenerarOrientacion() {

		Tablero tableroTest = new Tablero();
		assertEquals(Posicion.class, tableroTest.generarOrientacion().getClass());
		assertNotEquals(tableroTest.generarOrientacion(), tableroTest.generarOrientacion());

	}

	/*
	 * Test genera posiciones X-Y aleatorias entre 10 y 1
	 * 
	 */
	@Test
	public void testGenerarPosicion() {


		Tablero tableroTest = new Tablero();
		assertEquals(Posicion.class, tableroTest.generaPosicion().getClass());
		assertNotEquals(tableroTest.generaPosicion(), tableroTest.generaPosicion());

	}

	/*
	 * Test insertar un barco con su correspondiente tama�o. Para simpliar no
	 * tendremos encuentra la orientacion (Temporal) y no comprobamos los margenes
	 */
	@Test
	public void testInsertBarco() {
		
		Tablero tableroTest = new Tablero();
		assertEquals(tableroTest.insertarBarco(),"Barco Insertado!");
		


	}

}
