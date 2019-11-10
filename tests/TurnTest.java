import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {
	/*
	 * Test if the object construction is correct checking init parameters
	 */
	@Test
	void testConstruct() {
		Turn turn = new Turn();
		assertEquals(turn.current(), 0);
	}
	
	/*
	 * Test if turn change is working
	 * Boundaries: 0, 1
	 * Limits -1, 2
	 */
	@Test
	void testNext() {
		Turn turn = new Turn();
		assertFalse(turn.current() == -1);
		turn.next();
		assertEquals(turn.current(), 1);
		turn.next();
		assertFalse(turn.current() == 2);
		assertEquals(turn.current(), 0);
		turn.next();
		assertEquals(turn.current(), 1);
	}
	
	/*
	 * Test for ensure who have the opposite turn
	 * Boundaries: 0, 1
	 * limits: -1, 2
	 */
	@Test
	void testNotCurrent() {
		Turn turn = new Turn();
		turn.next();
		assertFalse(turn.notCurrent() == 1);
		assertEquals(turn.notCurrent(), 0);
		turn.next();
		assertFalse(turn.notCurrent() == -1);
		assertEquals(turn.notCurrent(), 1);
		turn.next();
		assertEquals(turn.notCurrent(), 0);
	}

}
