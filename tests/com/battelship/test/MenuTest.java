package com.battelship.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.battelship.main.Menu;
import com.battelship.mocks.ManagerIOMock;
import com.battelship.mocks.ManagerIOMockExit;
import com.battelship.mocks.ManagerIOMockOptions;
import com.battelship.utils.Constants;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Menu
 */
public class MenuTest {

	public ByteArrayOutputStream resultado;

	/*
	 * Función que se ejecuta antes de cada @Test inicializa y setea un outputstream
	 * para recoger los datos printados en consola
	 */
	@Before
	public void beforeAll() {

		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	/*
	 * Test que ejecuta una secuncia de acciones con un mock que hace ganar al
	 * jugador
	 */
	@Test
	public void testMenuRunning() {

		new Menu(new ManagerIOMock(Constants.SECUENCIA_GANADORA, Constants.SECUENCIA_GANADORA_IA));
		assertTrue(resultado.toString().contains("Running game"));
	}

	/*
	 * Test que prueba que se printen correctamente las opciones del menu
	 */
	@Test
	public void testMenuOptions() {

		new Menu(new ManagerIOMockOptions());
		String esperado = "------Menu Principal------\n" + "1- Jugar\n" + "2- Opciones (TODO)\n" + "3- Salir\n"
				+ "Option Menu";
		assertEquals(esperado, resultado.toString());
	}

	/*
	 * Test que comprueba que se sale correctamente del juego
	 */
	@Test
	public void testMenuExit() {

		new Menu(new ManagerIOMockExit());
		String esperado = "------Menu Principal------\n" + "1- Jugar\n" + "2- Opciones (TODO)\n" + "3- Salir\n"
				+ "Saliendo de la aplicacion! Bye";
		assertEquals(esperado, resultado.toString());
	}

}