package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import java.util.Random;

public class Game {
	
	private Player player; 
	private Coin coin;
	private CoinList coinlist;
	private Random rand;
	private ObstacleList obstacleList;
	
	
	private Level level; // be quit with the warning
	private long seed;
	
	public Game(long seed, Level level) {
		this.level = level;
		this.seed = seed;
		player = new Player(this);
		coinlist = new CoinList(this);
		rand = new Random(seed);
		obstacleList = new ObstacleList(this);
		
		// TODO 	
	}
	
	public void generarCosas() {
		
		for (int x = getVisibility() / 2; x < level.getInfoL(); x++) {
			tryToAddObstacle(new Obstacle(this, x, getRandomLane()), level.obstacleFrequency());
			
			tryToAddCoin(new Coin(this, x, getRandomLane()), level.coinFrequency());
			
			}

	}
	private void tryToAddObstacle(Obstacle obstacle, double obstacleFrequency) {
	
		if(getRandomNumber() < obstacleFrequency) {	
			this.obstacleList.addObstacleToArray(obstacle);
		}
	}

	public void  tryToAddCoin(Coin coin,double frecuency) {
		
		if(getRandomNumber() < frecuency) {
				if(obstacleList.getCont() == 0 || ObstacleOrNotV2(coin.x,coin.y) == null) {
					this.coinlist.addCoinToArray(coin);
				}
		}
	}
	public boolean checkSpace(Coin coin,Obstacle obstacle) {
		
		return obstacle.getColumn() == coin.x && obstacle.getLane() == coin.y;
	}
	
	
	public void toggleTest() {
		// TODO 
	}
	
	public boolean isInLimints(int y) {
		
			if(y<getRoadWidth() && y>=0) {
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
	
	public void moveForward() {
		player.moveForward(); // cambiar pues no es necesario tener en cuenta la x del player.
	}
	public void UpdateXeY(Coin coin) {
		coin.UpdateXeY(coin);
		
	}
	//public void UpdateXeY2(Obstacle coin) {
	//	coin.UpdateXeY(coin);
		
	//}
	
	public int getVisibility() {
		
		return level.getInfoV();
	}
	
	public int getRoadWidth() {
		
		return level.getInfoR();
	}
	public int getLenght() {
		
		return level.getInfoL();
	}
	
	public String getGameStatus() {
		
		System.out.println("Distance: "+player.x);
		System.out.println("Coins: "+player.numCoins);
		System.out.println("Cicle: ");
		System.out.println("Total obstacles: "+this.obstacleList.getCont());
		System.out.println("Total coins: "+this.coinlist.getCont());
		System.out.println("Ellaped Time: ");
		return "";
	}
	public void resetGame() {
		 
		
		
	}
	public boolean checkImpact() {
		if(this.coin.x == 0 && this.coin.y == this.player.y) {
			return true;
		}
		return false;
	}
	public int getRandomLane() {
		  return (int) (getRandomNumber() *  getRoadWidth());
		}
	public Double getRandomNumber() {
		   return rand.nextDouble();
		}

	public String positionToString(int j, int i) {
		// j e i will be called by player ( or car )
		if(j==player.x && player.y ==i ) {
			if(player.checkPunch(obstacleList)) {
				return "@";
				
			}
			player.checkCoins(coinlist);
			return ">";
		}
		
		if(CoinOrNot(j,i)) {
			return "¢";
		}
		if(ObstacleOrNot(j,i)) {
			return "░";
		}
		if(j==this.level.getInfoL()-1) {
			return "¦";
		}
	return "";
		
	}
	public boolean checkEnd() {
		if(this.player.checkPunch(obstacleList)) {
			System.out.println("[GAME OVER] Player crashed!");
			return true;
		}
		//si ha llegado a la meta.
		if(this.player.x>=this.level.getInfoL()) {
			System.out.println("[GAME OVER] Player wins!");
			return true;
			
		}
		return false;
	}
	public boolean CoinOrNot(int x,int y) {
		
		
		for(int i=0;i<this.coinlist.getCont();i++) {
			if(this.coinlist.getArray()[i].x == x && this.coinlist.getArray()[i].y == y)
				return true;
		}
		
		return false;
	}
public boolean ObstacleOrNot(int x,int y) {
		
		
		for(int i=0;i<this.obstacleList.getCont();i++){
			if(this.obstacleList.getArray()[i].x == x && this.obstacleList.getArray()[i].y == y)
				return true;
		}
		return false;
	}
	public Obstacle ObstacleOrNotV2(int x,int y) {
		
		for(int i=0;i<this.obstacleList.getCont();i++)
			if(obstacleList.getArray()[i].x == x && obstacleList.getArray()[i].y == y ) {
				return obstacleList.getArray()[i];
			}
		return null;
	}
	public void UpdateCoins() {
		for(int i=0;i<this.coinlist.getCont();i++) {
			this.UpdateXeY(coinlist.getArray()[i]);
		}
		
	}
	public int getXplayer() {
		return this.player.getX();
	}
}
