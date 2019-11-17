package com.battelship.main;

import com.battelship.main.intefaces.IJugador;
import com.battelship.main.intefaces.IManagerIO;
import com.battelship.utils.Constants;


/* 
 * Clase que gestiona el tablero del juego
 */
public class Tablero {
	IManagerIO managerIO;
	int numeroBarcosPoscionados = Constants.TOTAL_BARCOS;
	int[][] tablero = new int[Constants.TAMAÑO_TABLERO][Constants.TAMAÑO_TABLERO];

	public int[][] getTablero() {
		return tablero;
	}

	public Tablero(IManagerIO managerIO) {
		this.managerIO = managerIO;
		iniciarTablero();
	}

	/*
	 * Inicializa el tablero con todas las casillas como agua
	 */
	private void iniciarTablero() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.tablero[i][j] = 0;
			}
		}
	}

	/*
	 * Muestra el tablero por consola
	 */
	public void mostrarTablero() {
		System.out.println("     _______________________________________");
		System.out.println("    | A | B | C | D | F | G | H | I | J | K |");
		for (int i = 0; i < 10; i++) {
			System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
			if ((i + 1) == 10) {
				System.out.print("| " + (i + 1) + "|");
			} else {
				System.out.print("| " + (i + 1) + " |");
			}
			for (int j = 0; j < 10; j++) {
				if (tablero[i][j] == 1) {
					System.out.print(" B |");
				} else if (tablero[i][j] == 0 || tablero[i][j] == 4) {
					System.out.print("   |");
				} else if (tablero[i][j] == 2) {
					System.out.print(" X |");
				} else if (tablero[i][j] == 3) {
					System.out.print(" # |");
				}
				/*
				 * else if (tablero[i][j] == 4) { System.out.print(" P |"); }
				 */
			}
			System.out.println();
		}
		System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
	}

	/*
	 * Inserta un barco de tamaño N en una posición del tablero proporcionada por el
	 * usuario
	 */
	public void insertPosicion(int tamañoBarcoActual) {
		boolean insertada = false;
		Posicion posicion = new Posicion();
		while (!insertada) {
			posicion = leerXY();
			posicion.setOrientacion(leerOrientacion());
			posicion.setTamaño(tamañoBarcoActual);
			insertada = sePuedeInsertarOrientacion(posicion);

			if (!insertada) {
				System.out.println("La posicion " + posicion.toString() + "\nNo es correcta!\nIntroduce una de nuevo!");
			}
		}
		// System.out.println("Se puede insertar!!!\n");
		insertarBarco(posicion);
		posicion.toString();
	}

	/*
	 * Inserta un barco de tamaño N en una posición del tablero aleatoria
	 */
	public void insertPosicionRandom(int tamañoBarcoActual) {
		boolean insertada = false;
		Posicion posicion = new Posicion();
		while (!insertada) {
			posicion = generarXY();
			posicion.setOrientacion(generarOrientacion());
			posicion.setTamaño(tamañoBarcoActual);
			insertada = sePuedeInsertarOrientacion(posicion);
		}
		System.out.println("La IA-Random ya ha posicionado sus barcos!\n");
		insertarBarco(posicion);
		posicion.toString();
	}

	/*
	 * Hace que alrededor de un barco no pueda haber otro barco cumpliendo así una
	 * de las reglas del juego
	 */
	public void proteccionBarco(Posicion pos) {

		if (pos.getX() + 1 < 10) {
			if (tablero[pos.getX() + 1][pos.getY()] == 0) {
				tablero[pos.getX() + 1][pos.getY()] = 4;// DERECHA
			}
		}
		if (pos.getY() - 1 >= 0) {
			if (tablero[pos.getX()][pos.getY() - 1] == 0) {
				tablero[pos.getX()][pos.getY() - 1] = 4;// ABAJO
			}
		}
		if (pos.getX() - 1 >= 0) {
			if (tablero[pos.getX() - 1][pos.getY()] == 0) {
				tablero[pos.getX() - 1][pos.getY()] = 4;// IZQUIERDA
			}
		}
		if (pos.getY() + 1 < 10) {
			if (tablero[pos.getX()][pos.getY() + 1] == 0) {
				tablero[pos.getX()][pos.getY() + 1] = 4;// ARRIBA
			}
		}
		if (pos.getY() + 1 < 10 && pos.getX() + 1 < 10) {
			if (tablero[pos.getX() + 1][pos.getY() + 1] == 0) {
				tablero[pos.getX() + 1][pos.getY() + 1] = 4;// ARRIBA DERECHA
			}
		}
		if (pos.getY() + 1 < 10 && pos.getX() - 1 >= 0) {
			if (tablero[pos.getX() - 1][pos.getY() + 1] == 0) {
				tablero[pos.getX() - 1][pos.getY() + 1] = 4;// ARRIBA IZQUIERDA
			}
		}
		if (pos.getY() - 1 >= 0 && pos.getX() - 1 >= 0) {
			if (tablero[pos.getX() - 1][pos.getY() - 1] == 0) {
				tablero[pos.getX() - 1][pos.getY() - 1] = 4;// ABAJO IZQUIERDA
			}
		}
		if (pos.getY() - 1 >= 0 && pos.getX() + 1 < 10) {
			if (tablero[pos.getX() + 1][pos.getY() - 1] == 0) {
				tablero[pos.getX() + 1][pos.getY() - 1] = 4;// ABAJO DERECHA
			}
		}

	}

	/*
	 * Inserta un barco en una posicion del tablero
	 */
	public void insertarBarco(Posicion pos) {
		for (int i = 0; i < pos.tamaño; i++) {
			switch (pos.getOrientacion()) {
			case 0:// ARRIBA
				tablero[pos.getX()][pos.getY() + i] = 1;
				proteccionBarco(new Posicion(pos.getX(), pos.getY() + i));
				break;
			case 1:// DEECHA
				tablero[pos.getX() + i][pos.getY()] = 1;
				proteccionBarco(new Posicion(pos.getX() + i, pos.getY()));
				break;
			case 2:// ABAJO
				tablero[pos.getX()][pos.getY() - i] = 1;
				proteccionBarco(new Posicion(pos.getX(), pos.getY() - i));
				break;
			case 3:
				tablero[pos.getX() - i][pos.getY()] = 1;
				proteccionBarco(new Posicion(pos.getX() - i, pos.getY()));
				break;
			}
		}
	}

	/*
	 * Comprueba si se puede insertar un barco en cierta orientación
	 */
	public boolean sePuedeInsertarOrientacion(Posicion pos) {
		boolean respuesta = false;
		int correcte = 0;
		// Comprovacion Margenes tamaño
		for (int i = 0; i < pos.getTamaño(); i++) {
			switch (pos.getOrientacion()) {
			case 0:// ARRIBA
				if (pos.getY() + i < 10) {
					if (tablero[pos.getX()][pos.getY() + i] == 0) {
						correcte++;
					}
				}
				break;
			case 1:
				if (pos.getX() + i < 10) {
					if (tablero[pos.getX() + i][pos.getY()] == 0) {
						correcte++;
					}
				}
				break;
			case 2:
				if (pos.getY() - i >= 0) {
					if (tablero[pos.getX()][pos.getY() - i] == 0) {
						correcte++;
					}
				}
				break;
			case 3:
				if (pos.getX() - i >= 0) {
					if (tablero[pos.getX() - i][pos.getY()] == 0) {
						correcte++;
					}
				}
				break;
			}
		}
		if (correcte == pos.getTamaño()) {

			respuesta = true;

		}
		return respuesta;
	}

	/*
	 * Recibir la orientación del barco por parte del jugador
	 */
	public int leerOrientacion() {

		int orientacion = -1;
		boolean aux = false;
		while (!aux) {
			System.out.println("Orientacion:");
			System.out.println(" 0-Derecha \n 1-Abajo \n 2- Arriba \n 3-Izquierda \n");
			int ori = managerIO.inInt();

			if (ori >= 0 && ori < 4) {
				orientacion = ori;
				aux = true;
			}
		}
		return orientacion;
	}

	/*
	 * Genera una orientación de barco aleatoria
	 */
	public int generarOrientacion() {

		int orientacion = -1;
		boolean aux = false;
		while (!aux) {
			int ori = managerIO.getRandomInt();
			if (ori >= 0 && ori < 4) {
				orientacion = ori;
				aux = true;
			}
		}
		return orientacion;
	}

	/*
	 * Pide una posicion de colocación al jugador
	 */
	public Posicion leerXY() {

		boolean aux = false;
		Posicion lectura = new Posicion();
		while (!aux) {

			while (!aux) {
				System.out.println("Posicion X (1-10):");
				int x = managerIO.inInt();
				if (x > 0 && x < 11) {
					lectura.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				System.out.println("Posicion Y (1-10):");
				int y = managerIO.inInt();
				if (y > 0 && y < 11) {
					lectura.setY(y - 1);
					aux = true;
				}
			}
		}
		return lectura;
	}

	/*
	 * Genera una posicion colocación aleatoria
	 */
	public Posicion generarXY() {

		boolean aux = false;
		Posicion generado = new Posicion();
		while (!aux) {

			while (!aux) {
				int x = managerIO.getRandomInt();

				if (x > 0 && x < 11) {
					generado.setX(x - 1);
					aux = true;
				}
			}
			aux = false;
			while (!aux) {
				int y = managerIO.getRandomInt();
				if (y > 0 && y < 11) {
					generado.setY(y - 1);
					aux = true;
				}
			}
		}
		return generado;
	}

	/*
	 * El jugador ataca a la maquina
	 */
	public void atacar(IJugador randomIA) {
		Posicion posicion = new Posicion();
		posicion = leerXY();
		Tablero aux = randomIA.getPropio();
		
		boolean pos = aux.tablero[posicion.getX()][posicion.getY()] ==1;
		boolean pos2 = this.tablero[posicion.getX()][posicion.getY()]< 2;
		
		if (aux.tablero[posicion.getX()][posicion.getY()] == 1 
				&& this.tablero[posicion.getX()][posicion.getY()] < 2) {
			System.out.println("Barco TOCADO!");
			this.tablero[posicion.getX()][posicion.getY()] = 2;
			this.numeroBarcosPoscionados--;
		} else {
			System.out.println("AGUA!");
			this.tablero[posicion.getX()][posicion.getY()] = 3;
		}

	}

	/*
	 * La maquina ataca aleatoriamente al jugador
	 */
	public void atacarRandom(IJugador jugador) {
		Posicion posicion = new Posicion();
		posicion = generarXY();
		Tablero aux = jugador.getPropio();

		if (aux.tablero[posicion.getX()][posicion.getY()] == 1 && this.tablero[posicion.getX()][posicion.getY()] < 2) {
			System.out.println("Barco TOCADO!");
			this.tablero[posicion.getX()][posicion.getY()] = 2;
			this.numeroBarcosPoscionados--;
		} else {
			System.out.println("AGUA!");
			this.tablero[posicion.getX()][posicion.getY()] = 3;
		}
	}

}