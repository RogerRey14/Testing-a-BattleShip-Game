import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerIOTest {

	@Test
	void testGetIntFromUser() {
		ManagerIO io = new ManagerIO();
		int opt = io.inInt();
		assertEquals(opt, 1);
	}

}
