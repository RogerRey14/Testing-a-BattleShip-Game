package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;

/*
 * Clase que se encarga de gestionar el menu del juego
 */
public class Menu {
	IManagerIO managerIO;

	/* 
	 * Constructor principal de la clase se encarga de gestionar las elecciones en el menu del jugador
	 */
	public Menu(IManagerIO managerIO) {
		this.managerIO = managerIO;
		this.showMenu();
		int option = managerIO.inInt();
		switch (option) {
		case 1:			
			System.out.print("Running game"); // RUN GAME
			new Partida(this.managerIO);
			break;
		case 2:
			System.out.print("Option Menu"); // OPEN OPTIONS
			break;
		case 3:
			System.out.print("Saliendo de la aplicacion! Bye");// EXIT
			break;
		}
	}

	/*
	 * Función que muestra el menu por consola
	 */
	public void showMenu() {
		System.out.print("------Menu Principal------\n");
		System.out.print("1- Jugar\n");
		System.out.print("2- Opciones (TODO)\n");
		System.out.print("3- Salir\n");
	}

}