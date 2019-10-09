public class Menu {

	public Menu() {
		initMessage();
		showMenu();
	}
	
	private void initMessage() {
		System.out.println("Hello Batterlship Arcade Testing Game!");
	}

	public void showMenu() {
		System.out.print("---Batterlship---\n1- Jugar\n2- Exit\n");		
	}
	
	public void playing() {
		System.out.println("Jugando");
	}
	
	public void exit() {
		System.out.println("Exit");
	}
}
