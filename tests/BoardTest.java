import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testConstruct() {
		Board board = new Board();
		assertEquals(board.getShipsCount(), 0);
	}


}
