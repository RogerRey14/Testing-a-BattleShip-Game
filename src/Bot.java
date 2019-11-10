class Bot extends Player {
	
	public Bot(String name) {
		super(name);
	}
	
	public void positionShips() {
		System.out.println("Maquina: " + super.getName() + "\nPosicionando sus barcos de manera aleatoria!");
		for (int i = 0; i < Constants.SHIPS_LIST.length; i++) {	
			super.getOwnBoard().positionShip(Constants.SHIPS_LIST[i]);	
		}
	}
	
	public void atack() {
		System.out.println("Maquina => " + super.getName() + " ATACA ALEATORIAMENTE!");
		super.getEnemyBoard().atackRandom(super.getEnemyBoard());
		super.getEnemyBoard().show();
	}
	
}
