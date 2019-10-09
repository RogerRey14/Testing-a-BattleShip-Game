import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MenuTest {

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	
	@Test
	void testShowMenu() {		
		final ByteArrayOutputStream contenidoSalida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contenidoSalida));
        Menu testMenu = new Menu();
        testMenu.showMenu();
        assertEquals("---Batterlship---\n1- Jugar\n2- Exit\n", contenidoSalida.toString());
	
	}

	@Test
	void testOptionMenu() {
		fail("Not yet implemented");
	}

}
