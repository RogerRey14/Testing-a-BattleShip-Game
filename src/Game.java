public class Game {
	private Player[] players;
	private Board[] boards;
	private Turn turn;
	
	public Game() {
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
	
	public void start() {
		menu();
		switch(getMenuOption()) {
			case 1:
				play();
				break;
			case 2:
				//TODO
				break;
			case 3:
				exit();
				break;
		}
		play();
	}
	
	private void menu() {
		ManagerIO io = new ManagerIO();
		io.out("1. Jugar\n");
		io.out("2. Opciones\n");
		io.out("3. Salir\n");
	}
	
	private int getMenuOption() {
		int option;
		ManagerIO io = new ManagerIO();
		do {
			option = io.inInt();
		}while(option < 1 && option > 3);
		return option;
	}
	
	private void play() {
		do {
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
	
	private void options() {
		
	}
	
	private void exit() {
		System.exit(0);
	}

}
