/* 
 * This class controls a flip flop turn between two players.
 * It's represented by an integer that says who is playing right now.
 */

class Turn {
	private static final int MAX_TURNS = 2;
	private int num;
	
	public Turn() {
		num = 0;
	}

	/*
	 * Change turn to the next player
	 */
	public void next() {
		num = notCurrent();
	}

	/*
	 * Gives the current turn
	 */
	public int current() {
		return num;
	}

	/*
	 * Gives the player that is not currently playing
	 */
	public int notCurrent() {
		return (num + 1) % MAX_TURNS;
	}
}
