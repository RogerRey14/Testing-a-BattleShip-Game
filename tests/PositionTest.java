import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	void testConstruct() {
		Position position = new Position(0, 0);
		assertEquals(position.getX(), 0);
		assertEquals(position.getY(), 0);
	}
	
	@Test
	void testShipOrientation() {
		Position position = new Position(0, 0);
		position.setOrientation(0);
		assertEquals(position.getShipOrientation(), "Derecha");
		position.setOrientation(1);
		assertEquals(position.getShipOrientation(), "Abajo");
		position.setOrientation(2);
		assertEquals(position.getShipOrientation(), "Arriba");
		position.setOrientation(3);
		assertEquals(position.getShipOrientation(), "Izquierda");
		position.setOrientation(4);
		assertEquals(position.getShipOrientation(), "No tiene orientacion");
	}
	
	@Test
	void testToString() {
		Position position = new Position(0, 0);
		assertEquals(position.toString(), "Posicion [x=1, y=1 , orientacion=No tiene orientacion]");
		position.setOrientation(0);
		assertEquals(position.toString(), "Posicion [x=1, y=1 , orientacion=Derecha]");
		position.setOrientation(1);
		assertEquals(position.toString(), "Posicion [x=1, y=1 , orientacion=Abajo]");
		position.setOrientation(2);
		assertEquals(position.toString(), "Posicion [x=1, y=1 , orientacion=Arriba]");
		position.setOrientation(3);
		assertEquals(position.toString(), "Posicion [x=1, y=1 , orientacion=Izquierda]");	
	}

}
