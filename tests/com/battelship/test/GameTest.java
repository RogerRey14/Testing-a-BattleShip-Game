package com.battelship.test;

import org.junit.Test;

import com.battelship.Game;

public class GameTest {


	/*
	 * Test que inicializa el juego y llama a la funcion main
	 * 
	 */
	
	@Test
	public void testStartGame() {
	
		String[] args = null;
		new Game();
		Game.main(args);
		

	}
	
	
	
	

}
