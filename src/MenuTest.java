import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTest {

	ByteArrayOutputStream resultado;
	Menu testMenu;
	private static final Logger LOG = Logger.getLogger(MenuTest.class.getName());

	@BeforeEach
	public void before() {
		System.out.println("Before()");
		testMenu = new Menu();
		resultado = new ByteArrayOutputStream();
		System.setOut(new PrintStream(resultado));
	}

	@Test
	void testInitMessage() {

		testMenu.initMessage();
		String esperado = "Hello Battleship Arcade Testing Game!\n";
		assertEquals(esperado.toString(), resultado.toString());

		LOG.info("testInitMessage()");
	}

	@Test
	void testShowMenu() {

		testMenu.showMenu();
		String esperado = "---Battleship---\n1- Jugar\n2- Exit\n";
		assertEquals(esperado, resultado.toString());

		LOG.info("testShowMenu()");
	}

	/*
	 * @Test void testPlaying() { testMenu = new Menu(); resultado = new
	 * ByteArrayOutputStream(); System.setOut(new PrintStream(resultado));
	 * testMenu.showMenu();
	 * 
	 * String esperado = "Jugando"; assertEquals(esperado, resultado.toString());
	 * LOG.info("testShowMenu()"); }
	 * 
	 * @Test void testExit() { testMenu = new Menu(); resultado = new
	 * ByteArrayOutputStream(); System.setOut(new PrintStream(resultado));
	 * testMenu.showMenu();
	 * 
	 * String esperado = "Exit"; assertEquals(esperado, resultado.toString());
	 * LOG.info("testShowMenu()"); }
	 */

}
