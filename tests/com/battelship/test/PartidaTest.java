package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battelship.Partida;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Partida
 */
public class PartidaTest {

	public static ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta una vez para limpiar la salida
	 */
	@BeforeClass
	public static void beforeClass() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Test comprueba que se crea una Partida correctamente
	 */
	@Test
	public void testCreatePartida() {

		Partida partidaTest = new Partida();
		assertEquals("RandomIA", partidaTest.getRandomIA().getNombre());
		assertEquals("Jugador", partidaTest.getUserPlayer().getNombre());
		assertFalse(partidaTest.isFinalJuego());
		assertTrue(partidaTest.isTurnoJugador());

	}

	/*
	 * Test comprueba que se empieza la partida
	 */
	@Test
	public void testEmpezarPartida() {

		Partida partidaTest = new Partida();
		partidaTest.empezarPartida();
		assertTrue(resultado.toString().contains("Partida Empezada!"));

	}

	/*
	 * Test comprueba quien es el ganador
	 */
	@Test
	public void testMostrarGanador() {

		Partida partidaTest = new Partida();
		assertEquals("Jugador", partidaTest.mostrarGanador());

	}

}
