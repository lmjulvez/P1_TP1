package es.ucm.tp1.logic;

public class Player {
	
	private int x=0,y=1;
	private int numCoins = 5;
	
	private Game game;

	public Player(Game game) {
		this.game = game;
		y=game.getRoadWidth()/2;
	}
	
	public void moveDown() {
		if(game.isInLimints(y+1))
			this.y +=1;
	}
	
	public void moveUp() {
		if(game.isInLimints(y-1))
			this.y-= 1;
	}
	public void moveForward() {
			this.x +=1;
	}
	public int getX() {
		
		return this.x;
		
		
	}
	public int getcoins() {
		
		return this.numCoins;
		
		
	}
	public int getY() {
		
		return this.y;
		
		
	}
	public boolean checkCoins(CoinList coinlist) {
		
		for(int i=0;i<coinlist.getCont();i++) {
			if(coinlist.getArray()[i].x == this.x && coinlist.getArray()[i].y== this.y) {
				this.numCoins++;
				coinlist.eraseCoin(i);
				return true;
			}
		}
		
		return false;
	}
	

	
	
	
	
public boolean checkPunch(ObstacleList obstaclelist) {
		
		for(int i=0;i<obstaclelist.getCont();i++) {
			if(obstaclelist.getArray()[i].x == this.x && obstaclelist.getArray()[i].y== this.y) {
				return true;
			}
		}
		
		return false;
	}
	

}
