package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private Player player; 
	private Coin coin;
	
	private Level level; // be quit with the warning
	private long seed;
	
	public Game(long seed, Level level) {
		this.level = level;
		this.seed = seed;
		player = new Player(this);
		coin = new Coin(this);
		
		// TODO 	
	}
	
	public void toggleTest() {
		// TODO 
	}
	
	public boolean isInLimints(int x,int y) {
		
			if(x<getVisibility() && y<getRoadWidth() && y>=0) {
				return true;
			}
		
		
		
		return false;
		
	}
	public void moveUp() { // probar unir moveUp y moveDown en una misma funcion con el argumento "op".
		player.moveUp();
	}
		
	
	public void moveDown() {
		player.moveDown();
	}
	
	
	public int getVisibility() {
		
		return level.getInfoV();
	}
	
	public int getRoadWidth() {
		
		return level.getInfoR();
	}
	
	public String getGameStatus() {
		return "";
	}

	public String positionToString(int j, int i) {
		// j e i will be called by player ( or car )
		if(j==0 && player.y ==i ) {
			return ">";
		}
		
		
		
		
		return "";
	}
}
