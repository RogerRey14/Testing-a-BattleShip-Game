public class Position {
	private int x;
	private int y;
	private int orientation;
	private int size;
	
	public Position() {
		
	}
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return -1;
	}
	
	public void setX(int x) {
		
	}
	
	public int getY() {
		return -1;
	}
	
	public void setY(int y) {
		
	}
	
	public int getOrientation() {
		return -1;
	}
	
	public void setOrientation(int orientation) {
		
	}
	
	public int getSize() {
		return -1;
	}
	
	public void setSize(int size) {
		
	}
	
	public String getShipOrientation() {		
		switch(orientation) {
			case 0: return "Derecha";
			case 1: return "Abajo";
			case 2: return "Arriba";
			case 3: return "Izquierda";
			default: return "No tiene orientacion";
		}			
	}
	
	@Override
	public String toString() {
		return "";
	}
}
