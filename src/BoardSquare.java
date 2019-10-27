public class BoardSquare {
	private int row;
	private ColumnLetter column;
	private SquareContent content;
	private boolean visible;
	
	public BoardSquare(int row, ColumnLetter column, SquareContent content) {
		this.row = row;
		this.column = column;
		this.content = content;
	}
	
	public int getRow() {
		return row;
	}
	
	public ColumnLetter getColumn() {
		return column;
	}
	
	public SquareContent getContent() {
		return content;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void toogleVisible() {
		visible = !visible;
	}
	
	@Override
	public String toString() {
		String str = "";
		if(visible) {
			switch(content) {
				case WATER:
					str += "~";
				case SHIP:
					str += "^";
			}
		}
		return "("+row+", "+column+")";
	}
}
