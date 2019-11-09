public class Game {
	private Menu menu;
	private Player[] players;
	private Board[] boards;
	private Turn turn;
	
	public Game() {
		menu = new Menu();
		players = new Player[2];
		players[0] = new Human();
		players[1] = new Bot();
		boards = new Board[4];
		boards[0] = new Board();
		boards[1] = new Board();
		boards[2] = new Board();
		boards[3] = new Board();
		turn = new Turn();
	}
	
	public void play() {
		do {
			menu.show();
			boards[0].show();
			boards[1].show();
			if(!boards[0].isFull() && !boards[2].isFull()) {
				players[turn.current()].putShip(boards[turn.current()]);
			}else {
				players[turn.current()].shoot(boards[turn.current() + 1]);
			}
			turn.next();
		}while(!boards[0].isWinner() || !boards[2].isWinner());
		players[turn.notCurrent()].sayWin();
	}
	
	public void stop() {
	}
	
	
}
