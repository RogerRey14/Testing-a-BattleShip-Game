
import org.junit.Test;

import com.battelship.main.Menu;

/*
 * Test que inicializa el juego y llama a la funcion main
 * 
 */

public class MenuTest {
	
	/*
	 * Test comprueba que se crea el menu correctamente
	 */
	@Test
	public void testEmpezarJuego() {
		
		Menu testMenu = new Menu();
		assertEquals(testMenu.mostrarMenu(),"------Menu Principal------"));
	}
	
	/*
	 * Test que devuelve la opcion del menu
	 */
	@Test
	public void testGetOpcion() {

		Menu testMenu = new Menu();
		assertEquals(testMenu.getOpcion(), 1);
		

	}

	
	
}
