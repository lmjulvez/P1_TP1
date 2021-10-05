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
	/*public void start() {
		for(int i=0;i<5;i++) {
			coinList[i] = new Coin(game);
		}
	}
	*/
	public void addObstacleToArray(Obstacle obstacle) {
		
		ObstaclesList[this.cont] = obstacle;
		this.cont++;
	}
	public Obstacle getLatObstacle() {
		
		return ObstaclesList[cont-1];
	}
	
	public int getCont() {
		return this.cont;
	}
	
}


