import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testConstruct() {
	}
	
	/* 
	 * This test uses a MockBoard with ships that simulates a correct positioning by the player
	 */
	@Test
	void testBoardShips() {
		MockBoard mockBoard = new MockBoard();
		String str = "B B B B - - - - - B\n" + 
				"- - - - - B B - - -\n" + 
				"B - - - - - - - - -\n" + 
				"B - - - - - - - - -\n" + 
				"B - - - - - B B B -\n" + 
				"- - B B - - - - - -\n" + 
				"- - - - - - - - - -\n" + 
				"- - - - - B - - - -\n" + 
				"- B B - - - - B - -\n" + 
				"- - - - - - - - - B\n";
		assertTrue(mockBoard.toString().equals(str));
		assertTrue(mockBoard.isFull());
	}
	
	/* 
	 * This test uses a mock to simulate a player shoot on a ship
	 */
	@Test
	void testShoot() {
		MockBoard mockBoard = new MockBoard();
		Player player1 = new Human("Player 1");
		mockBoard.atack(player1);
		String str = "B B B B - - - - - B\n" + 
				"- - - - - B B - - -\n" + 
				"B - - - - - - - - -\n" + 
				"B - - - - - - - - -\n" + 
				"B - - - - - B B B -\n" + 
				"- - B B - - - - - -\n" + 
				"- - - - - - - - - -\n" + 
				"- - - - - B - - - -\n" + 
				"- B B - - - - B - -\n" + 
				"- - - - - - - - - T\n";
		assertTrue(mockBoard.toString().equals(str));
	}
	


}
