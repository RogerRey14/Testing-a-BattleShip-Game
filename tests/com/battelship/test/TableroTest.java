package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battelship.Posicion;
import com.battelship.Tablero;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Tablero
 */
public class TableroTest {

	public static ByteArrayOutputStream resultado;


	/*
	 * Función que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@BeforeClass
	public static void beforeClass() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Test comprueba que se crea una Tablero correctamente
	 */
	@Test
	public void testCreateTablero() {

		
		new Tablero();
		assertTrue(resultado.toString().contains("Tablero Iniciado!"));

	}

	/*
	 * Test comprueba que se muestra un Tablero correctamente
	 */
	@Test
	public void testMostrarTablero() {

		Tablero tableroTest = new Tablero();
		tableroTest.mostrarTablero();
		assertTrue(resultado.toString().contains("Muestra Tablero!"));

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
		int[][] tablero = tableroTest.getTablero();

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
		int[][] tablero = tableroTest.getTablero();

		assertTrue(tablero[x][y] == 1);
	}

	

	/*
	 * Test comprueba si puedes insertar a partir de una orientacion y el tamaño del barco
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
	 * Test
	 * 
	 */
	@Test
	public void testProtecionBarco() {

		Tablero tableroTest = new Tablero();
		tableroTest.protecionBarco();
		assertTrue(resultado.toString().contains("Protecion Activada"));

	}

	/*
	 * Test
	 * 
	 */
	@Test
	public void testGenerarOrientacion() {

		Tablero tableroTest = new Tablero();
		assertEquals(Posicion.class,tableroTest.generarOrientacion().getClass());
		assertNotEquals(tableroTest.generarOrientacion(), tableroTest.generarOrientacion());

	}

	/*
	 * Test genera posiciones X-Y aleatorias entre 10 y 1
	 * 
	 */
	@Test
	public void testGenerarPosicion() {

		Tablero tableroTest = new Tablero();
		assertEquals(Posicion.class,tableroTest.generaPosicion().getClass());
		assertNotEquals(tableroTest.generaPosicion(), tableroTest.generaPosicion());

	}
	
	/*
	 * Test insertar un barco con su correspondiente tamaño.
	 * Para simpliar no tendremos encuentra la orientacion (Temporal)
	 * y no comprobamos los margenes
	 */
	@Test
	public void testInsertBarco() {

		Posicion posicionTest = new Posicion(0, 0);
		posicionTest.setOrientacion(0);
		posicionTest.setTamaño(2);
		
		Tablero tableroTest = new Tablero();
		tableroTest.insertarBarco(posicionTest);
		int[][] tablero = tableroTest.getTablero();

		assertTrue(tablero[0][0] == 2);
		assertTrue(tablero[1][0] == 2);
		assertFalse(tablero[1][1] == 2);

	}

}
