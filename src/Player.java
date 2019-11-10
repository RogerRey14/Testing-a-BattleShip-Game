public abstract class Player {
	private String name;
	
	public Player() {		
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isWinner() {
		return false;
	}
	
	public void putShip(GameBoard board) {
		// TODO Auto-generated method stub
		
	}

	public void shoot(GameBoard board) {
		// TODO Auto-generated method stub
		
	}

	public void sayWin() {
		// TODO Auto-generated method stub
		
	}
}
