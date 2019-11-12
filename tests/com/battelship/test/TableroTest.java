package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battelship.Tablero;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Tablero
 */
public class TableroTest {

	public static ByteArrayOutputStream resultado;
	private PrintStream systemOutOriginal;

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
		assertEquals("Tablero Iniciado!", resultado.toString());

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
	 * Test 
	 * 	 
	 */
	@Test
	public void testInsertarPosicion() {
		Tablero tableroTest = new Tablero();
		tableroTest.insertarPosicion();
		

	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testInsertPosicionRandom() {
		Tablero tableroTest = new Tablero();
		tableroTest.insertarPosicionRandom();
		

	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testInsertBarco() {

		Tablero tableroTest = new Tablero();
		tableroTest.insertarBarco();

	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testSePuedeInsertarOrientacion() {

		Tablero tableroTest = new Tablero();
		tableroTest.sePuedeInsertarOrientacion();

	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testProtecionBarco() {

		Tablero tableroTest = new Tablero();
		tableroTest.protecionBarco();


	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testGenerarOrientacion() {

		Tablero tableroTest = new Tablero();
		tableroTest.generarOrientacion();


	}
	
	/*
	 * Test 
	 * 	 
	 */
	@Test
	public void testGenerarPosicion() {

		Tablero tableroTest = new Tablero();
		tableroTest.generarPosicion();

	}


}
