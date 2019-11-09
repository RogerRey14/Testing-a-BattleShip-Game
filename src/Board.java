public class Board {
	private int shipsCount;
	private int[][] matrix; 

	public Board() {
		shipsCount = 0;
		matrix = new int[10][10]; 
		init();
	}

	private void init() {

	}

	void show() {

	}

	public int getShipsCount() {
		return -1;
	}

	public void setShipsCount(int shipsCount) {
		
	}

	public int[][] getBoard() {
		return matrix;
	}

	public void setBoard(int[][] board) {
	
	}

	public void insertShip(int shipSize) {


	}

	public void insertRandomShip(int tamañoBarcoActual) {

	}

	private void shipLimit(Position position) {


	}

	private void insertShip(Position position) {

	}

	private boolean isCorrectOrientation(Position position) {
		return false;
	}

	private boolean isEmpty(Position position) {
		return false;
	}

	private int readOrientation() {
		return -1;
	}

	public Position readPosition() {
		return new Position(0,0);
	}

	public Position generatePosition() {
		return new Position(0,0);
	}

	private int generateOrientation() {
		return -1;
	}

	public void shoot(Player bot) {

	}

	public void shootBot(Player player) {

	}

}