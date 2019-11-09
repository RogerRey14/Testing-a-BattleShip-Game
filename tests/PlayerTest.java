import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testConstruct() {
		Player player = new Player("Player 1", 1);
		assertEquals(player.getName(), "Player 1");
		assertEquals(player.getName(), "Player 1");
		assertEquals(player.getType(), 1);
		
		Player bot = new Player("Bot", 2);
		assertEquals(bot.getName(), "Bot");
		assertEquals(bot.getType(), 2);
	}
	
	@Test
	void testWinner() {
		Player player = new Player("Player 1", 1);
		assertFalse(player.isWinner());
		player.insertShips();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				player.shoot(i, j);
			}
		}
		assertTrue(player.isWinner());
	}
	
	@Test
	void testShoot() {
		Player player = new Player("Player 1", 1);
		assertEquals(player.shoot(-1, -1), "Out of board");
		assertEquals(player.shoot(-1, 0), "Out of board");
		assertEquals(player.shoot(0, -1), "Out of board");
		assertEquals(player.shoot(10, 10), "Out of board");
		assertEquals(player.shoot(10, 0), "Out of board");
		assertEquals(player.shoot(0, 10), "Out of board");
		assertTrue(player.shoot(0, 0) != "Out of board");
		assertTrue(player.shoot(9, 9) != "Out of board");	
	}
	
	@Test
	void testPositionShips() {
		
	}

}
