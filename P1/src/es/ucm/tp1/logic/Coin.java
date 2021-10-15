package es.ucm.tp1.logic;

public class Coin {
	
	private int x=4,y=1;
	
	private Game game;
	
	public Coin(Game game,int x,int lineaRan) {
		this.x =x;
		this.y = lineaRan;
		this.game = game;
	}
	public int  getXcoin() {
		return this.x;
	}

	public int getYcoin() {
		return this.y;
	}
}
