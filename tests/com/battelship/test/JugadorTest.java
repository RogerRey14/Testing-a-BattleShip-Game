package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import com.battelship.main.Jugador;
import com.battelship.main.Menu;
import com.battelship.mocks.ManagerIOMock;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Jugador
 */

public class JugadorTest {

	private PrintStream systemOutOriginal;
	public ByteArrayOutputStream resultado;	

	/*
	 * Función que se ejecuta antes de cada @Test 
	 * inicializa y setea un outputstream para recoger los datos printados en consola
	 */
	@Before
	public void beforeAll() {
		systemOutOriginal = System.out; 
		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}
	
	/*
	 * Función que devuelve la salida del sistema a su estado original despues de cada @Test
	 */
    @AfterEach
    public void restoreSystemOutStream() {
        System.setOut(systemOutOriginal);
    }

	/*
	 * Test 
	 */
	@Test
	public void testCreateJugador() {
		
		int[] arrayInputJugador = new int[] {  1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };
		
		Jugador jugadorTest = new Jugador(1,"Cristian",new ManagerIOMock(arrayInputJugador,arrayInputRandom));
		Jugador randomTest = new Jugador(2,"Random",new ManagerIOMock(arrayInputJugador,arrayInputRandom));
		
		assertEquals("Cristian", jugadorTest.getNombre());
		assertEquals(1, jugadorTest.getTipo());
		assertEquals("Random", randomTest.getNombre());
		assertEquals(2, randomTest.getTipo());
	}
	
	/*
	 * Test 
	 */
	@Test
	public void testFullPartida() {
		
		int[] arrayInputJugador = new int[] { 1, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1,
				0, 8, 8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1, 9, 2,
				9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugador, arrayInputRandom));

		assertTrue(resultado.toString().contains("Ganador de la partida Jugador!!!"));

	}

}
