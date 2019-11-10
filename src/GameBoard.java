interface GameBoard {
	public char[][] getBoard();
	public void atack(Player player);
	public void show();
	public boolean isWinner();
	public boolean isFull();
	public String toString();
}
