import java.util.Scanner;

public class ManagerIO {
	private Scanner scanner;
	
	public ManagerIO() {
	
	}	

	public int inInt() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public void out(String data) {
		System.out.print(data);
	}
	
	public void out(char data) {
		System.out.print(data);
	}
}
