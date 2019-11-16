package com.battelship.test;




import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import com.battelship.main.Jugador;
import com.battelship.main.ManagerIO;
import com.battelship.utils.Constants;

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
	 * Test Caja Negra comprueba que se crea un Jugador con nombre y tipo. Tipo
	 * Humano = 1
	 */
	@Test
	public void testCreateJugador() {

		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR,new ManagerIO());
		assertEquals(Constants.NOMBRE_JUGADOR, jugadorTest.getNombre());
		assertEquals(Constants.TIPO_HUMANO, jugadorTest.getTipo());

	}

	/*
	 * Test Caja Negra comprueba que se crea un Jugador con nombre y tipo. Tipo
	 * RandomIA = 2
	 */
	@Test
	public void testCreateRandomIA() {

		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA,new ManagerIOMock(arrayInputJugador,arrayInputRandom));
		assertEquals(Constants.NOMBRE_RANDOM_IA, randomIATest.getNombre());
		assertEquals(Constants.TIPO_RANDOM_IA, randomIATest.getTipo());

	}

	/*
	 * Test Posicionar Barco Jugador
	 */
	@Test
	public void testPosicionaBarcoJugador() {

		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
		assertEquals("Barco Posicionado!", jugadorTest.posicionarBarco());

	}

	/*
	 * Test Posicionar Barco RandomIA
	 */
	@Test
	public void testPosicionaBarcoRandomIA() {

		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
		assertEquals("Barco Posicionado Aleatoriamente!", randomIATest.posicionarBarco());

	}

	/*
	 * Test Atacar Barco Jugador
	 */
	@Test
	public void testAtacarJugador() {

		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
		assertEquals("Atacando!", jugadorTest.atacar());

	}

	/*
	 * Test Atacar Barco RandomIA
	 */
	@Test
	public void testAtacarRandomIA() {

		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
		assertEquals("Atacando Aleatoriamente!", randomIATest.atacar());

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
		
		assertEquals("Cristian", jugadorTest.getName());
		assertEquals(1, jugadorTest.getTipoJugador());
		assertEquals("Random", randomTest.getName());
		assertEquals(2, randomTest.getTipoJugador());
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
