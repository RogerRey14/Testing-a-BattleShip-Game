public class Human extends Player {
	
	public Human(String name) {
		super(name);
	}
	
	@Override
	public void positionShips() {
		System.out.println("Jugador: " + super.getName() + "\nPosiciona tus barcos!");
		for (int i = 0; i < Constants.SHIPS_LIST.length; i++) {
			System.out.println(
					"Posicion (X,Y) cabeza del barco que ocupa " + Constants.SHIPS_LIST[i] + " cuadrados (1/1)");			
			super.getOwnBoard().positionShip(Constants.SHIPS_LIST[i]);
			super.getOwnBoard().show();	
		}
	}
	
	@Override
	public void atack() {
		System.out.println("Jugador => " + super.getName() + " ATACANTE!!!");
		System.out.println("Que posicion quieres atacar?");
		super.getEnemyBoard().atack(super.getEnemyBoard());
		super.getEnemyBoard().show();
	}
	
}
