class MockBoard implements GameBoard{
	private char[][] matrix;

	public MockBoard() {
		matrix = new char[10][10];
		init();
		boardOne();
	}
	
	private void init() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = '-';
			}
		}
	}
	
	/*
	 *    0 1 2 3 4 5 6 7 8 9
	 *    
	 * 0  B B B B - - - - - B
	 * 1  - - - - - B B - - -
	 * 2  B - - - - - - - - -
	 * 3  B - - - - - - - - -
	 * 4  B - - - - - B B B -
	 * 5  - - B B - - - - - -
	 * 6  - - - - - - - - - -
	 * 7  - - - - - B - - - -
	 * 8  - B B - - - - B - -
	 * 9  - - - - - - - - - B
	 */
	private void boardOne() {
		matrix[0][0] = 'B';
		matrix[0][1] = 'B';
		matrix[0][2] = 'B';
		matrix[0][3] = 'B';
		matrix[0][9] = 'B';
		matrix[1][5] = 'B';
		matrix[1][6] = 'B';
		matrix[2][0] = 'B';
		matrix[3][0] = 'B';
		matrix[4][0] = 'B';
		matrix[4][6] = 'B';
		matrix[4][7] = 'B';
		matrix[4][8] = 'B';
		matrix[5][2] = 'B';
		matrix[5][3] = 'B';
		matrix[7][5] = 'B';
		matrix[8][1] = 'B';
		matrix[8][2] = 'B';
		matrix[8][7] = 'B';
		matrix[9][9] = 'B';
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				str += matrix[i][j];
				if(j < 9) {
					str += " ";
				}
			}
			str += "\n";
		}
		return str;
	}
	

	
	/* 
	 * Simulates an atack at coordinate (9,9)
	 */
	public void atack(Player player) {
		matrix[9][9] = 'T';
	}
	
	public void show() {
		//do nothing
	}
	
	public boolean isWinner() {
		//do nothing
		return false;
	}
	
	public boolean isFull() {
		//do nothing
		return true;
	}

	@Override
	public int[][] getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberShips() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertShip(Position position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void positionShip(int shipSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atack(GameBoard board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atackRandom(GameBoard board) {
		// TODO Auto-generated method stub
		
	}
}
