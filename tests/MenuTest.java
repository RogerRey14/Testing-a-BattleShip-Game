import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest{

	@Test
	void testConstruct() {
		Menu menu = new Menu();
		assertTrue(menu.getPlaying());
		assertEquals(menu.getOption(), -1);
		assertEquals(menu.getNumOptions(), 0);
	}
	
	@Test
	void testGetOption() {
		Menu menu = new Menu();
		int option = menu.getOption();
		assertTrue(option <= menu.getNumOptions());
		int option2 = menu.getOption();
		assertFalse(option2 <= menu.getNumOptions());
	}

}
