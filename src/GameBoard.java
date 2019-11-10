interface GameBoard {
	public int[][] getBoard();
	public int getNumberShips();
	public void show();
	public boolean isWinner();
	public boolean isFull();
	public void insertShip(Position position);
	public void positionShip(int shipSize);
	public void atack(GameBoard board);
	public void atackRandom(GameBoard board);
	public String toString();
}
