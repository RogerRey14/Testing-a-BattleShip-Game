public class Menu {

	public Menu() {
		initMessage();
		showMenu();
	}
	
	public void initMessage() {
		System.out.print("Hello Battleship Arcade Testing Game!\n");
	}

	public void showMenu() {
		System.out.print("---Battleship---\n1- Jugar\n2- Exit\n");		
	}
	
	public void playing() {
		System.out.println("Jugando");
	}
	
	public void exit() {
		System.out.println("Exit");
	}
}
