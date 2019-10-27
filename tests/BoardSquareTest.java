import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardSquareTest {

	@Test
	void testConstructor() {
		BoardSquare square = new BoardSquare(0, ColumnLetter.A, SquareContent.EMPTY);
		assertEquals(square.getRow(), 0);
		assertEquals(square.getColumn(), ColumnLetter.A);
		assertEquals(square.getContent(), SquareContent.EMPTY);
	}
	
	@Test
	void testToogleSquareVisibility() {
		BoardSquare square = new BoardSquare(0, ColumnLetter.A, SquareContent.EMPTY);
		assertFalse(square.isVisible());
		square.toogleVisible();
		assertTrue(square.isVisible());
	}

}
