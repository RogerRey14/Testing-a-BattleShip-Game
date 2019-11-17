package com.battelship.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.battelship.main.Jugador;
import com.battelship.main.Menu;
import com.battelship.mocks.ManagerIOMock;
import com.battelship.utils.Constants;

/*
 * Esta clase de test se encarga de las pruebas unitarias de la clase Jugador
 */

public class JugadorTest {


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
	 * Test para comprobar la creacion de los objetos Jugador
	 */
	@Test
	public void testCreateJugador() {

		Jugador jugadorTest = new Jugador(1, "Cristian",
				new ManagerIOMock(Constants.SECUENCIA_GANADORA_PLAYER, Constants.SECUENCIA_GANADORA_PLAYER_IA));
		Jugador randomTest = new Jugador(2, "Random",
				new ManagerIOMock(Constants.SECUENCIA_GANADORA_PLAYER, Constants.SECUENCIA_GANADORA_PLAYER_IA));

		assertEquals("Cristian", jugadorTest.getNombre());
		assertEquals(1, jugadorTest.getTipo());
		assertEquals("Random", randomTest.getNombre());
		assertEquals(2, randomTest.getTipo());
	}

	/*
	 * Test para comprobar que los jugadores atacan correctamente
	 */
	@Test
	public void testJugadorAtacar() {

		Jugador jugadorTest = new Jugador(1, "Cristian",
				new ManagerIOMock(Constants.SECUENCIA_JUGADOR_PLAYER, Constants.SECUENCIA_GANADORA_PLAYER_IA));
		Jugador randomTest = new Jugador(2, "Random",
				new ManagerIOMock(Constants.SECUENCIA_JUGADOR_PLAYER, Constants.SECUENCIA_GANADORA_PLAYER_IA));

		jugadorTest.atacar(randomTest);
		assertTrue(resultado.toString().contains("Jugador => Cristian ATACANTE!!!"));

		randomTest.atacar(jugadorTest);
		assertTrue(resultado.toString().contains("Maquina => Random ATACA ALEATORIAMENTE!"));

	}

	/*
	 * Test para comprobar comprueba correctamente cuando un Jugador/Random gana la
	 * partida (todos los barcos enemigos hundidos)
	 */
	@Test
	public void testJugadorGana() {

		new Menu(new ManagerIOMock(Constants.SECUENCIA_GANADORA_PLAYER, Constants.SECUENCIA_GANADORA_PLAYER_IA));
		assertTrue(resultado.toString().contains("Ganador de la partida Jugador!!!"));

	}

}
