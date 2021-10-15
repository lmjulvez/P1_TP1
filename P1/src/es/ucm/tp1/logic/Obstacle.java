package es.ucm.tp1.logic;

public class Obstacle {
	
	private Game game;
	
	private  int x , y; // 
	
	
	
	
	public Obstacle(Game game,int x,int lineaRan) {
		this.game = game;
		this.x = x;
		this.y = lineaRan;
	}
	
	public int getColumn() {
		return this.x;
	}
	
	public int getLane() {
		return this.y;
	}

}
