public class BoardSquare {
	private int row;
	private ColumnLetter column;
	private SquareContent content;
	private boolean visible;
	
	public BoardSquare(int row, ColumnLetter column, SquareContent content) {

	}
	
	public int getRow() {
		return 0;
	}
	
	public ColumnLetter getColumn() {
		return ColumnLetter.J;
	}
	
	public SquareContent getContent() {
		return SquareContent.SHIP;
	}
	
	public boolean isVisible() {
		return false;
	}
	
	public void toogleVisible() {
		
	}
}
