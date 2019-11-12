package com.battelship.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.battelship.Jugador;
import com.battelship.utils.Constants;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Jugador
 */
public class JugadorTest {


	/*
	 * Test comprueba que se crea un Jugador con nombre y tipo. Tipo Humano = 1
	 */
	@Test
	public void testCreateJugador() {

		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
		assertEquals(Constants.NOMBRE_JUGADOR, jugadorTest.getNombre(), "El nombre del Jugador debe coincidir");
		assertEquals(Constants.TIPO_HUMANO, jugadorTest.getTipo(), "El tipo de Jugador debe coincidir");

	}

	/*
	 * Test comprueba que se crea un Jugador con nombre y tipo. Tipo RandomIA = 2
	 */
	@Test
	public void testCreateRandomIA() {

		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
		assertEquals(Constants.NOMBRE_RANDOM_IA, randomIATest.getNombre(), "El nombre del RandomIA debe coincidir");
		assertEquals(Constants.TIPO_RANDOM_IA, randomIATest.getTipo(), "El tipo de RandomIA debe coincidir");

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
	 * Test Posicionar Barco Jugador
	 */
	@Test
	public void testAtacarJugador() {

		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
		assertEquals("Atacando!", jugadorTest.atacar());

	}
	
	/*
	 * Test Posicionar Barco RandomIA
	 */
	@Test
	public void testAtacarRandomIA() {

		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
		assertEquals("Atacando Aleatoriamente!", randomIATest.atacar());

	}
	
}
