import java.util.Scanner;

public class InputData {
	private Scanner scanner;
	
	public InputData() {
		scanner = new Scanner(System.in);
	}
	
	public int getIntInput() {
		return scanner.nextInt();
	}
}
