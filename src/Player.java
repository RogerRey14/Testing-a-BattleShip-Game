public abstract class Player {
	private String name;
	private GameBoard ownBoard = new Board();
	private GameBoard enemyBoard = new Board();
	
	public Player(String name) {
		this.name = name;
		positionShips();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isWinner() {
		return enemyBoard.getNumberShips() == 0;
	}
	
	public GameBoard getOwnBoard() {
		return ownBoard;
	}

	public void setOwnBoard(GameBoard board) {
		this.ownBoard = board;
	}

	public GameBoard getEnemyBoard() {
		return enemyBoard;
	}

	public void setEnemyBoard(GameBoard board) {
		this.enemyBoard = board;
	}

	public void positionShips() {
	}

	public void atack() {
	}
	
	public void sayWin() {
		
	}
}
