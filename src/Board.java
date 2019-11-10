public class Board implements GameBoard {
	
	private char[][] matrix;

	public Board() {
		matrix = new char[10][10];
		init();
	}
	
	public char[][] getBoard() {
		return matrix;
	}
	
	private void init() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = '-';
			}
		}
	}
	
	public void show() {
		ManagerIO io = new ManagerIO();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				io.out(matrix[i][j]);
			}
			io.out("\n");
		}
	}

	public boolean isWinner() {
		int count = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 'H') {
					count++;
				}
			}
		}
		return count == 20;
	}

	public boolean isFull() {
		int count = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 'B') {
					count++;
				}
			}
		}
		return count == 20;
	}
	
	public void atack(Player player) {
		
	}

}