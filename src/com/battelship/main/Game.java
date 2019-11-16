package com.battelship.main;

import com.battelship.main.intefaces.IManagerIO;
import com.battelship.mocks.ManagerIOMock;

public class Game {

	static IManagerIO managerIO = new ManagerIO();

	public static void main(String[] args) {

	
		new Menu(managerIO);

	}

	public static void setManager(IManagerIO manager) {
		Game.managerIO = manager;
	}

}
