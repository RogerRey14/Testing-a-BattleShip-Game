package com.battelship.test;

import org.junit.Test;

/*
 * Test que inicializa el juego y llama a la funcion main
 * 
 */

public class MenuTest {
	
	/*
	 * Test comprueba que inicializa el tablero correctamente
	 */
	@Test
	public void testEmpezarJuego() {
		
		Menu testMenu = new Menu();
		assertTrue(testMenu.mostrarMenu()"------Menu Principal------"));
	}
	
	
}
