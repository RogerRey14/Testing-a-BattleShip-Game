import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testConstruct() {
		Player player = new Human("Player 1");
		assertEquals(player.getName(), "Player 1");
		
		Player bot = new Bot("Bot");
		assertEquals(player.getName(), "Bot");
	}
	
	@Test
	void testWinner() {
		Player player = new Human("Player 1");
		assertFalse(player.isWinner());
		Board board = new Board();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				player.atack();
			}
		}
		assertTrue(player.isWinner());
	}
	
	@Test
	void testShoot() {
		Player player = new Human("Player 1");

	}
	
	@Test
	void testPositionShips() {
		
	}

}
