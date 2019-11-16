package com.battelship.test;
import com.battelship.main.*;
import com.battelship.mocks.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


	@Test
	public void testPosicionesIncorrectasIzquierda() {

		int[] arrayInputJugador = new int[] { 1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0,
				10, 1, 0, 8, 8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1,
				9, 2, 9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugador, arrayInputRandom));
		
		assertTrue(resultado.toString().contains("La posicion Posicion [x=1, y=1, orientacion=Izquierda]"));

	}
	
	@Test
	public void testPosicionesIncorrectasArriba() {

		int[] arrayInputJugador = new int[] { 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0,
				10, 1, 0, 8, 8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1,
				9, 2, 9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugador, arrayInputRandom));
		//TODO
		//assertTrue(resultado.toString().contains("La posicion Posicion [x=1, y=1, orientacion=Izquierda]"));

	}
	
	@Test
	public void testPosicionesAguaAtacar() {

		int[] arrayInputJugadorRepitePosicionAtaque = new int[] { 1, 1, 1, 2, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0,
				10, 1, 0, 8, 8, 0, 10, 8, 0, 1, 1,1,1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1,
				9, 2, 9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugadorRepitePosicionAtaque, arrayInputRandom));
		
		//TODO
		//assertTrue(resultado.toString().contains("La posicion Posicion [x=1, y=1, orientacion=Izquierda]"));

	}
	
	
	@Test
	public void testIzquierdaArribaInsertarBarco() {

		int[] arrayInputJugador = new int[] { 1, 1, 1, 1, 1, 3, 3, 1,3,1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0,
				10, 1, 0, 8, 8, 3, 10, 8, 2, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1,
				9, 2, 9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugador, arrayInputRandom));
		//TODO
		//assertTrue(resultado.toString().contains("La posicion Posicion [x=1, y=1, orientacion=Izquierda]"));

	}
	
	

}