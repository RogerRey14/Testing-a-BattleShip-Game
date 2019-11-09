import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {

	@Test
	void testConstruct() {
		Turn turn = new Turn();
		assertEquals(turn.current(), 0);
	}
	
	@Test
	void testNext() {
		Turn turn = new Turn();
		turn.next();
		assertEquals(turn.current(), 1);
		turn.next();
		assertEquals(turn.current(), 0);
		turn.next();
		assertEquals(turn.current(), 1);
	}
	
	@Test
	void testNotCurrent() {
		Turn turn = new Turn();
		turn.next();
		assertEquals(turn.notCurrent(), 0);
		turn.next();
		assertEquals(turn.notCurrent(), 1);
		turn.next();
		assertEquals(turn.notCurrent(), 0);
	}

}
