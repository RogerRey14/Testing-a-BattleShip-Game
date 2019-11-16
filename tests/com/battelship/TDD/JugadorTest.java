//package com.battelship.TDD;
//
//
//
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import com.battelship.main.Jugador;
//import com.battelship.utils.Constants;
//
///*
// * Esta clase de test se encarga de las pruebas unitarias de la clase Jugador
// */
//
//public class JugadorTest {
//
//	/*
//	 * Test Caja Negra comprueba que se crea un Jugador con nombre y tipo. Tipo
//	 * Humano = 1
//	 */
//	@Test
//	public void testCreateJugador() {
//
//		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
//		assertEquals(Constants.NOMBRE_JUGADOR, jugadorTest.getNombre());
//		assertEquals(Constants.TIPO_HUMANO, jugadorTest.getTipo());
//
//	}
//
//	/*
//	 * Test Caja Negra comprueba que se crea un Jugador con nombre y tipo. Tipo
//	 * RandomIA = 2
//	 */
//	@Test
//	public void testCreateRandomIA() {
//
//		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
//		assertEquals(Constants.NOMBRE_RANDOM_IA, randomIATest.getNombre());
//		assertEquals(Constants.TIPO_RANDOM_IA, randomIATest.getTipo());
//
//	}
//
//	/*
//	 * Test Posicionar Barco Jugador
//	 */
//	@Test
//	public void testPosicionaBarcoJugador() {
//
//		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
//		assertEquals("Barco Posicionado!", jugadorTest.posicionarBarco());
//
//	}
//
//	/*
//	 * Test Posicionar Barco RandomIA
//	 */
//	@Test
//	public void testPosicionaBarcoRandomIA() {
//
//		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
//		assertEquals("Barco Posicionado Aleatoriamente!", randomIATest.posicionarBarco());
//
//	}
//
//	/*
//	 * Test Atacar Barco Jugador
//	 */
//	@Test
//	public void testAtacarJugador() {
//
//		Jugador jugadorTest = new Jugador(Constants.TIPO_HUMANO, Constants.NOMBRE_JUGADOR);
//		assertEquals("Atacando!", jugadorTest.atacar());
//
//	}
//
//	/*
//	 * Test Atacar Barco RandomIA
//	 */
//	@Test
//	public void testAtacarRandomIA() {
//
//		Jugador randomIATest = new Jugador(Constants.TIPO_RANDOM_IA, Constants.NOMBRE_RANDOM_IA);
//		assertEquals("Atacando Aleatoriamente!", randomIATest.atacar());
//
//	}
//
//
//}
