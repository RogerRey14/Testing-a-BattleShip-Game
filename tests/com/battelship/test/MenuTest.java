package com.battelship.test;
import com.battelship.main.*;
import com.battelship.mocks.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;





/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Menu
 */
public class MenuTest {
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
	 * Test que ejecuta una secuncia de acciones con un mock que hace ganar al jugador
	 */
	@Test
	public void testMenuRunning() {
		
	
		int[] arrayInputJugador = new int[] { 1, 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1,
				0, 8, 8, 0, 10, 8, 0, 1, 1, 2, 1, 3, 1, 4, 1, 1, 3, 2, 3, 3, 3, 1, 5, 2, 5, 3, 5, 1, 7, 2, 7, 1, 9, 2,
				9, 6, 1, 6, 2, 8, 1, 8, 8, 10, 1, 10, 8 };
		int[] arrayInputRandom = new int[] { 1, 1, 1, 1, 3, 1, 1, 5, 1, 1, 7, 1, 1, 9, 1, 6, 1, 0, 8, 1, 0, 10, 1, 0, 8,
				8, 0, 10, 8, 0, 1, 1, 1, 3, 1, 5, 1, 7, 1, 9, 6, 1, 8, 1, 10, 1, 8, 8, 10, 8 };

		new Menu(new ManagerIOMock(arrayInputJugador, arrayInputRandom));
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