import java.util.Scanner;

public class Menu {

	boolean exit = false;

	Menu() {

		System.out.println("Hello Batterlship Arcade Testing Game!");
		this.showMenu();
		this.optionMenu();

	}

	public void showMenu() {
		System.out.print("---Batterlship---\n1- Jugar\n2- Exit\n");
		
	}

	public void optionMenu() {
		
		while (!exit) {
			Scanner scan = new Scanner(System.in);
			int opcio = scan.nextInt();
			switch (opcio) {
			case 1:
				System.out.println("Jugando");
				break;
			case 2:
				System.out.println("Exit");
				exit=true;
				break;
			}
		}

	}
}
