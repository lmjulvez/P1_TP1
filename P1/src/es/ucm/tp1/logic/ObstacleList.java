package es.ucm.tp1.logic;

public class ObstacleList {
	private Game game;
	private int maxObstacles;
    private Obstacle ObstaclesList[];
    private int cont;
	
	
	public ObstacleList(Game game) {
		this.game = game;
		this.maxObstacles = game.getLenght();
		this.ObstaclesList = new Obstacle[maxObstacles];
		this.cont =0;
		
	}

	public void addObstacleToArray(Obstacle obstacle) {
		
		ObstaclesList[this.cont] = obstacle;
		this.cont++;
	}
	
	public int getCont() {
		return this.cont;
	}
	public Obstacle[] getArray() {
		return this.ObstaclesList;
	}
}


