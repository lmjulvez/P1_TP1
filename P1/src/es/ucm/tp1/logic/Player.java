package es.ucm.tp1.logic;

public class Player {
	
	int x=0,y=1;
	int numCoins = 0;
	
	private Game game;

	public Player(Game game) {
		this.game = game;
	}
	
	public void moveDown() {
		if(game.isInLimints(x, y+1))
			this.y +=1;
	}
	
	public void moveUp() {
		if(game.isInLimints(x, y-1))
			this.y-= 1;
	}
	public void moveForward() {
		if(game.isInLimints(x+1, y))
			this.x +=1;
	}
	

}
