import java.util.ArrayList;

public class Board {
	private int COLS = 10;
	private int ROWS = 10;
	ArrayList<ArrayList<BoardSquare>> matrix = new ArrayList<ArrayList<BoardSquare>>();
	private BoardSquare matrix2[][] = new BoardSquare[COLS][ROWS];
	
	public Board() {
		matrix2[0][0] = new BoardSquare(0, ColumnLetter.A, SquareContent.EMPTY);
		System.out.println(matrix2[0][0]);
	}
	
	public boolean shoot(int row, ColumnLetter column) {
		return false;
	}
	
	private int columnToNumber(ColumnLetter column) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
