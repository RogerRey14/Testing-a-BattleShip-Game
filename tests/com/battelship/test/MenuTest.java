package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.battelship.Menu;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Menu
 */
public class MenuTest {

	public static ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta al principo de todos los test para limpiar la salida
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

		new Menu();
		assertTrue(resultado.toString().contains("------Menu Principal------"));

	}

	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetOpcion() {

		Menu testMenu = new Menu();
		testMenu.getOpcion();
		assertEquals(testMenu.getOpcion(), 1);

	}

}
