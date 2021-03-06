package com.battelship.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.battelship.main.Game;
import com.battelship.mocks.ManagerIOMock;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Game
 */
public class GameTest {

	public ByteArrayOutputStream resultado;

	/*
	 * Funci�n que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@Before
	public void beforeAll() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Test que llama a la funcion Main Game que inicializa el Menu
	 */
	@Test
	public void testGame() {

		// Opcion 3 del menu -> Exit

		int[] input = new int[] { 3 };
		Game.setManager(new ManagerIOMock(input));
		Game.main(null);
		new Game();
		assertTrue(resultado.toString().contains("------Menu Principal------"));

	}

}
