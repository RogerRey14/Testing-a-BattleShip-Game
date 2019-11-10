import java.util.Random;

public class Board implements GameBoard {
	
	private int[][] matrix;
	private int numberShips;

	public Board() {
		matrix = new int[10][10];
		init();
	}
	
	public int[][] getBoard() {
		return matrix;
	}
	
	public int getNumberShips() {
		return numberShips;
	}
	
	private void init() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public void show() {
		ManagerIO io = new ManagerIO();
		io.out("     _______________________________________");
		io.out("    | A | B | C | D | F | G | H | I | J | K |");
		for (int i = 0; i < 10; i++) {
			io.out("+---+---+---+---+---+---+---+---+---+---+---+");
			if ((i + 1) == 10) {
				io.out("| " + (i + 1) + "|");
			} else
				io.out("| " + (i + 1) + " |");
			for (int j = 0; j < 10; j++) {
				if (matrix[i][j] == 1) {
					io.out(" B |");
				} else if (matrix[i][j] == 0 || matrix[i][j] == 4) {
					io.out("   |");
				} else if (matrix[i][j] == 2) {
					io.out(" X |");
				} else if (matrix[i][j] == 3) {
					io.out(" # |");
				}
			}
			io.out("\n");
		}
		io.out("+---+---+---+---+---+---+---+---+---+---+---+");
	}
	
	public void positionShip(int shipSize) {
		boolean inserted = false;
		Position position = new Position();
		while (!inserted) {
			position = readCoordinate();
			position.setOrientation(readOrientation());
			position.setSize(shipSize);
			inserted = isAvailableOrientation(position);
			if (!inserted) {
				System.out.println("La posicion " + position.toString() + "\nNo es correcta!\nIntroduce una de nuevo!");
			}
		}
		insertShip(position);
	}
	
	public Position readCoordinate() {
		ManagerIO io = new ManagerIO();
		boolean aux = false;
		Position position = new Position();
		while (!aux) {
			while (!aux) {
				System.out.println("Posicion X (1-10):");
				int x = io.inInt();
				if (x > 0 && x < 11) {
					position.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				System.out.println("Posicion Y (1-10):");
				int y = io.inInt();
				if (y > 0 && y < 11) {
					position.setY(y - 1);
					aux = true;
				}
			}
		}
		return position;
	}
	
	public int readOrientation() {
		ManagerIO io = new ManagerIO();
		int orientation = -1;
		boolean aux = false;
		while (!aux) {
			System.out.println("Orientacion:");
			System.out.println(" 0-Derecha \n 1-Abajo \n 2- Arriba \n 3-Izquierda \n");
			int orientationTemp = io.inInt();
			if (orientationTemp >= 0 && orientationTemp < 4) {
				orientation = orientationTemp;
				aux = true;
			}
		}
		return orientation;
	}
	
	public boolean isAvailableOrientation(Position position) {
		boolean available = false;
		int correct = 0;
		// Comprovacion Margenes tamaño
		for (int i = 0; i < position.getSize(); i++) {
			switch (position.getOrientation()) {
			case 0:// ARRIBA
				if (position.getY() + i < 10) {
					if (matrix[position.getX()][position.getY() + i] == 0) {
						correct++;
					}
				}
				break;
			case 1:
				if (position.getX() + i < 10) {
					if (matrix[position.getX() + i][position.getY()] == 0) {
						correct++;
					}
				}
				break;
			case 2:
				if (position.getY() - i >= 0) {
					if (matrix[position.getX()][position.getY() - i] == 0) {
						correct++;
					}
				}
				break;
			case 3:
				if (position.getX() - i >= 0) {
					if (matrix[position.getX() - i][position.getY()] == 0) {
						correct++;
					}
				}
				break;
			}
		}
		if (correct == position.getSize()) {
			// Comprovacion Vacio
			if (isEmpty(position)) {
				available = true;
			}
		}
		return available;
	}
	
	public boolean isEmpty(Position position) {
		int correct = 0;
		for (int i = 0; i < position.getSize(); i++) {
			switch (position.getOrientation()) {
			case 0:
				if (matrix[position.getX()][position.getY() + i] == 0) {
					correct++;
				}
				break;
			case 1:
				if (matrix[position.getX() + i][position.getY()] == 0) {
					correct++;
				}
				break;
			case 2:
				if (matrix[position.getX()][position.getY() - i] == 0) {
					correct++;
				}
				break;
			case 3:
				if (matrix[position.getX() - i][position.getY()] == 0) {
					correct++;
				}
				break;
			}
		}
		return correct == position.getSize();
	}
	
	public void insertShip(Position position) {	
		for (int i = 0; i < position.getSize(); i++) {
			switch (position.getOrientation()) {
			case 0:// ARRIBA
				matrix[position.getX()][position.getY() + i] = 1;
				shipSafeBorder(new Position(position.getX(), position.getY() + i));
				break;
			case 1:// DEECHA
				matrix[position.getX() + i][position.getY()] = 1;
				shipSafeBorder(new Position(position.getX() + i, position.getY()));
				break;
			case 2:// ABAJO
				matrix[position.getX()][position.getY() - i] = 1;
				shipSafeBorder(new Position(position.getX(), position.getY() - i));
				break;
			case 3:
				matrix[position.getX() - i][position.getY()] = 1;
				shipSafeBorder(new Position(position.getX() - i, position.getY()));
				break;
			}

		}
	}
	
	void shipSafeBorder(Position position) {
		if (position.getX() + 1 < 10) {
			if (matrix[position.getX() + 1][position.getY()] == 0) {
				matrix[position.getX() + 1][position.getY()] = 4;// DERECHA
			}
		}

		if (position.getY() - 1 >= 0) {
			if (matrix[position.getX()][position.getY() - 1] == 0) {
				matrix[position.getX()][position.getY() - 1] = 4;// ABAJO
			}
		}
		if (position.getX() - 1 >= 0) {
			if (matrix[position.getX() - 1][position.getY()] == 0) {
				matrix[position.getX() - 1][position.getY()] = 4;// IZQUIERDA
			}
		}
		if (position.getY() + 1 < 10) {
			if (matrix[position.getX()][position.getY() + 1] == 0) {
				matrix[position.getX()][position.getY() + 1] = 4;// ARRIBA
			}
		}

		if (position.getY() + 1 < 10 && position.getX() + 1 < 10) {
			if (matrix[position.getX() + 1][position.getY() + 1] == 0) {
				matrix[position.getX() + 1][position.getY() + 1] = 4;// ARRIBA DERECHA
			}
		}
		if (position.getY() + 1 < 10 && position.getX() - 1 >= 0) {
			if (matrix[position.getX() - 1][position.getY() + 1] == 0) {
				matrix[position.getX() - 1][position.getY() + 1] = 4;// ARRIBA IZQUIERDA
			}
		}

		if (position.getY() - 1 >= 0 && position.getX() - 1 >= 0) {
			if (matrix[position.getX() - 1][position.getY() - 1] == 0) {
				matrix[position.getX() - 1][position.getY() - 1] = 4;// ABAJO IZQUIERDA
			}
		}
		if (position.getY() - 1 >= 0 && position.getX() + 1 < 10) {
			if (matrix[position.getX() + 1][position.getY() - 1] == 0) {
				matrix[position.getX() + 1][position.getY() - 1] = 4;// ABAJO DERECHA
			}
		}
	}
	
	public boolean isWinner() { return false; }
	public boolean isFull() { return false; }
	
	public void atack(GameBoard board) {
		Position position = new Position();
		position = readCoordinate();
		GameBoard aux = board;
		if (aux.getBoard()[position.getX()][position.getY()] == 1) {
			System.out.println("Barco TOCADO!");
			matrix[position.getX()][position.getY()] = 2;
			numberShips--;
		} else {
			System.out.println("AGUA!");
			matrix[position.getX()][position.getY()] = 3;
		}

	}

	public void atackRandom(GameBoard board) {
		Position position = new Position();
		position = randomPosition();
		GameBoard aux = board;
		if (aux.getBoard()[position.getX()][position.getY()] == 1) {
			System.out.println("Barco TOCADO!");
			matrix[position.getX()][position.getY()] = 2;
			numberShips--;
		} else {
			System.out.println("AGUA!");
			matrix[position.getX()][position.getY()] = 3;
		}
	}
	
	public Position randomPosition() {
		Random rn = new Random();
		boolean aux = false;
		Position position = new Position();
		while (!aux) {
			while (!aux) {
				int x = rn.nextInt(10) + 1;
				if (x > 0 && x < 11) {
					position.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				int y = rn.nextInt(10) + 1;
				if (y > 0 && y < 11) {
					position.setY(y - 1);
					aux = true;
				}
			}
		}
		return position;
	}

}