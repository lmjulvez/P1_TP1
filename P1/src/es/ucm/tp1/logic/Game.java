package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import java.util.Random;

public class Game {
	
	private Player player; 
	private Coin coin;
	private CoinList coinlist;
	private Random rand;
	private ObstacleList obstacleList;
	private long tiempoini;
	private int cicles;
	private boolean test=false;
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
	
	public void iniciartiempo() {
		this.tiempoini = System.currentTimeMillis();
	}
	public double tiempo() {
		if(this.tiempoini==0)
			return 0;
		return (double) ((System.currentTimeMillis()-this.tiempoini)/1000);
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
		this.test=true; 
	}
	
	public boolean isInLimints(int y) {
		
			if(y<getRoadWidth() && y>=0) {
				return true;
			}
		
		
		
		return false;
		
	}
	public void moveUp() { 
		player.moveUp();
	}
		
	
	public void moveDown() {
		player.moveDown();
	}
	
	public void moveForward() {
		player.moveForward(); 
	}
	public void UpdateXeY(Coin coin) {
		coin.UpdateXeY(coin);
		
	}
	
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
		
		System.out.println("Distance: "+(this.getLenght() - player.getX()));
		System.out.println("Coins: "+player.getcoins());
		System.out.println("Cicle: "+ this.cicles);
		System.out.println("Total obstacles: "+this.obstacleList.getCont());
		System.out.println("Total coins: "+this.coinlist.getCont());
		if(this.test)
			System.out.println("Ellaped Time: "+this.tiempo()+"s");
		return "";
	}
	public void upcicles() {
		this.cicles++;
	}
	public void resetGame() {
		player = new Player(this);
		coinlist = new CoinList(this);
		rand = new Random(seed);
		obstacleList = new ObstacleList(this);
		iniciartiempo();
		this.generarCosas();
		
		cicles=0;
		
	}
	public boolean checkImpact() {
		if(this.coin.x == 0 && this.coin.y == this.player.getY()) {
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
		if(j==player.getX() && player.getY() ==i ) {
			if(player.checkPunch(obstacleList)) {
				return "@";
				
			}
			player.checkCoins(coinlist);
			return "o^o";
		}
		
		if(CoinOrNot(j,i)) {
			return "¢";
		}
		if(ObstacleOrNot(j,i)) {
			return "░";
		}
		if(j==this.level.getInfoL()) {
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
		if(this.player.getX()>this.level.getInfoL()) {
			System.out.println("      ▄▌▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌");
			System.out.println("   ▄▄██▌█"+" [GAME OVER] Player wins!");
			System.out.println("▄▄▄▌▐██▌█"+" New Record: "+tiempo()+"s");
			System.out.println("███████▌█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▌");
			System.out.println("▀(@)▀▀▀▀▀▀▀(@)(@)▀▀▀▀▀▀▀▀▀▀▀▀(@)▀");
					
					
					

			//System.out.println("[GAME OVER] Player wins!");
			//System.out.println("New Record: "+tiempo()+"s");
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
		return player.getX();
		
	}
}
