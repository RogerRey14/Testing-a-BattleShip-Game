package com.battelship.test;

import com.battelship.main.*;
import com.battelship.mocks.ManagerIOMock;
import com.battelship.utils.Constants;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	private PrintStream systemOutOriginal;
	public ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@Before
	public void beforeAll() {
		systemOutOriginal = System.out;
		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Función que devuelve la salida del sistema a su estado original despues de
	 * cada @Test
	 */
	@After
	public void restoreSystemOutStream() {
		System.setOut(systemOutOriginal);
	}

	/*
	 * Test de caja blanca para verificar que el tablero se muestra correctamente al
	 * iniciarse
	 */
	@Test
	public void testMostrarTablero() {
		Tablero tablero = new Tablero(new ManagerIOMock());
		tablero.mostrarTablero();
		String esperado = "     _______________________________________\r\n"
				+ "    | A | B | C | D | F | G | H | I | J | K |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 1 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 2 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 3 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 4 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 5 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 6 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 7 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 8 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 9 |   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n"
				+ "| 10|   |   |   |   |   |   |   |   |   |   |\r\n"
				+ "+---+---+---+---+---+---+---+---+---+---+---+\r\n";
		assertEquals(esperado, resultado.toString());
	}

	/*
	 * Test de caja blanca para verificar que el tablero se muestra correctamente al
	 * iniciarse
	 */
	@Test
	public void testIniciarTablero() {
		Tablero tablero = new Tablero(new ManagerIOMock());

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals(tablero.getTablero()[i][j], 0);
			}
		}

	}

	@Test
	public void testInsertPosicion() {

		int[] input = new int[] { 1, 1 };

		Tablero testTablero = new Tablero(new ManagerIOMock(input));
		testTablero.insertPosicion(1);

		assertEquals(testTablero.getTablero()[0][0], 1);
		assertEquals(testTablero.getTablero()[0][1], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
		assertEquals(testTablero.getTablero()[1][0], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
	}

	@Test
	public void testInsertPosicionKO() {

		// Posiciones incorrectas y luego correctas
		int[] input = new int[] { 1, 1, 2, 1 };

		Tablero testTablero = new Tablero(new ManagerIOMock(input));
		testTablero.insertPosicion(4);

		assertEquals(testTablero.getTablero()[0][0], 1);
		assertEquals(testTablero.getTablero()[1][0], 1);
		assertEquals(testTablero.getTablero()[2][0], 1);
		assertEquals(testTablero.getTablero()[3][0], 1);

		assertEquals(testTablero.getTablero()[0][1], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
		assertTrue(resultado.toString().contains(("\nNo es correcta!\nIntroduce una de nuevo!")));

	}

	@Test
	public void testInsertPosicionRandom() {

		int[] input = new int[] { 1, 1 };
		int[] empty = new int[] {};

		Tablero testTablero = new Tablero(new ManagerIOMock(empty, input));
		testTablero.insertPosicionRandom(1);

		assertEquals(testTablero.getTablero()[0][0], 1);
		assertEquals(testTablero.getTablero()[0][1], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
		assertEquals(testTablero.getTablero()[1][0], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
	}

	@Test
	public void testProteccionBarco() {

		int[] input = new int[] { 1, 1 };
		Tablero testTablero = new Tablero(new ManagerIOMock(input));
		Posicion pos = new Posicion(2, 2);
		pos.setTamaño(1);
		testTablero.proteccionBarco(pos);

		assertEquals(testTablero.getTablero()[3][3], 4);
		assertEquals(testTablero.getTablero()[3][1], 4);
		assertEquals(testTablero.getTablero()[3][2], 4);
		assertEquals(testTablero.getTablero()[2][3], 4);
		assertEquals(testTablero.getTablero()[2][1], 4);
		assertEquals(testTablero.getTablero()[1][1], 4);
		assertEquals(testTablero.getTablero()[1][2], 4);
		assertEquals(testTablero.getTablero()[1][3], 4);

		// Posiciones diferente de 0 alrededor
		testTablero.proteccionBarco(pos);

		// Limites Tablero
		pos = new Posicion(9, 0);
		pos.setTamaño(1);
		testTablero.proteccionBarco(pos);

		// Limites Tablero
		pos = new Posicion(0, 9);
		pos.setTamaño(1);
		testTablero.proteccionBarco(pos);

		// Limites Tablero
		pos = new Posicion(9, 9);
		pos.setTamaño(1);
		testTablero.proteccionBarco(pos);

		// Limites Tablero
		pos = new Posicion(0, 0);
		pos.setTamaño(1);
		testTablero.proteccionBarco(pos);

	}

	@Test
	public void testInsertarBarco() {

		int[] input = new int[] { 1, 1 };
		Tablero testTablero = new Tablero(new ManagerIOMock(input));

		Posicion pos = new Posicion(0, 0);
		pos.setTamaño(1);
		pos.setOrientacion(0);
		testTablero.insertarBarco(pos);

		pos = new Posicion(2, 2);
		pos.setTamaño(1);
		pos.setOrientacion(1);
		testTablero.insertarBarco(pos);

		pos = new Posicion(4, 4);
		pos.setTamaño(1);
		pos.setOrientacion(2);
		testTablero.insertarBarco(pos);

		pos = new Posicion(6, 6);
		pos.setTamaño(1);
		pos.setOrientacion(3);
		testTablero.insertarBarco(pos);

		// FUERA DEL SWITCH

		pos = new Posicion(6, 6);
		pos.setTamaño(1);
		pos.setOrientacion(4);
		testTablero.insertarBarco(pos);

	}

	@Test
	public void testSePuedeInsertarOrientacion() {

		int[] input = new int[] { 1, 1 };
		Tablero testTablero = new Tablero(new ManagerIOMock(input));

		// FUERA DE RANGO
		Posicion pos = new Posicion(0, 0);
		pos.setTamaño(11);
		pos.setOrientacion(0);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(1);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(2);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(3);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(4);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		// INSERTAMOS 2,2 POSICION CORRECTA
		pos = new Posicion(2, 2);
		pos.setTamaño(1);
		pos.setOrientacion(1);
		testTablero.sePuedeInsertarOrientacion(pos);
		testTablero.insertarBarco(pos);

		// VALORES DIFERENTES A 0 (CHOCA CON OTRO BARCOS)
		pos = new Posicion(2, 2);
		pos.setTamaño(2);
		pos.setOrientacion(0);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(1);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(2);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

		pos.setOrientacion(3);
		assertFalse(testTablero.sePuedeInsertarOrientacion(pos));

	}

	@Test
	public void testLeerOrientacion() {

		int[] input = new int[] { -1, 4, 1 };
		Tablero testTablero = new Tablero(new ManagerIOMock(input));
		assertEquals(testTablero.leerOrientacion(), 1);

	}

	@Test
	public void testGenerarOrientacion() {

		int[] empty = new int[] {};
		int[] input = new int[] { -1, 4, 1 };
		Tablero testTablero = new Tablero(new ManagerIOMock(empty, input));
		assertEquals(testTablero.generarOrientacion(), 1);

	}

	@Test
	public void testLeerXY() {

		int[] input = new int[] { -1, 11, 10, -1, 11, 10 };
		Tablero testTablero = new Tablero(new ManagerIOMock(input));
		Posicion testPosicion = new Posicion(9, 9);

		Posicion expectedPosicion = testTablero.leerXY();
		assertEquals(expectedPosicion.getX(), testPosicion.getX());
		assertEquals(expectedPosicion.getY(), testPosicion.getY());

	}

	@Test
	public void testGenerarXY() {

		int[] empty = new int[] {};
		int[] input = new int[] { -1, 11, 10, -1, 11, 10 };
		Tablero testTablero = new Tablero(new ManagerIOMock(empty, input));
		Posicion testPosicion = new Posicion(9, 9);

		Posicion expectedPosicion = testTablero.generarXY();
		assertEquals(expectedPosicion.getX(), testPosicion.getX());
		assertEquals(expectedPosicion.getY(), testPosicion.getY());

	}

	@Test
	public void testAtacar() {

		int[] empty = new int[] {};
		// 2,1 TOCADO TRUE TRUE
		// 2,1,2,1 TOCADO TRUE False
		// 1,2 AGUA FALSE TRUE
		// 6, 8 FALSE TRUE
		// 1,2,1,2 FALSE FALSE

		int[] input = new int[] { 2, 1, 2, 1, 1, 2, 6, 8, 1, 2, 1, 2 };

		Jugador testJugador = new Jugador(1, "Cristian", new ManagerIOMock(Constants.POSICIONA_BARCOS));
		Tablero testTablero = new Tablero(new ManagerIOMock(input));

		// 2,1 TOCADO TRUE TRUE
		testTablero.atacar(testJugador);
		// 2,1,2,1 TOCADO TRUE False
		testTablero.atacar(testJugador);
		// 1,2 AGUA FALSE TRUE
		testTablero.atacar(testJugador);
		// 6, 8 FALSE TRUE
		testTablero.atacar(testJugador);
		// 1,2,1,2 FALSE FALSE
		testTablero.atacar(testJugador);

	}
	
	@Test
	public void testAtacarRandom() {

		int[] empty = new int[] {};
		// 2,1 TOCADO TRUE TRUE
		// 2,1,2,1 TOCADO TRUE False
		// 1,2 AGUA FALSE TRUE
		// 6, 8 FALSE TRUE
		// 1,2,1,2 FALSE FALSE

		int[] input = new int[] { 2, 1, 2, 1, 1, 2, 6, 8, 1, 2, 1, 2 };

		Jugador testJugador = new Jugador(2, "Random", new ManagerIOMock(empty,Constants.POSICIONA_BARCOS));
		Tablero testTablero = new Tablero(new ManagerIOMock(empty,input));

		// 2,1 TOCADO TRUE TRUE
		testTablero.atacarRandom(testJugador);
		// 2,1,2,1 TOCADO TRUE False
		testTablero.atacarRandom(testJugador);
		// 1,2 AGUA FALSE TRUE
		testTablero.atacarRandom(testJugador);
		// 6, 8 FALSE TRUE
		testTablero.atacarRandom(testJugador);
		// 1,2,1,2 FALSE FALSE
		testTablero.atacarRandom(testJugador);

	}

}