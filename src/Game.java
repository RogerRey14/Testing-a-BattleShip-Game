public class Game {
	private boolean play = true;
	private Menu menu;
	
	public Game() {
		menu = new Menu();
	}
	
	public void start() {
		while (play) {
			InputData input = new InputData();
			switch (input.getIntInput()) {
			case 1:
				menu.playing();
				break;
			case 2:
				menu.exit();
				stop();
				break;
			}
		}
	}
	
	public void stop() {
		play = false;
	}
}
