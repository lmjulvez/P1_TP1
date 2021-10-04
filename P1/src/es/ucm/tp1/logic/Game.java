package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	
	private Player player; 
	private Coin coin;
	private CoinList coinlist;
	
	private Level level; // be quit with the warning
	private long seed;
	
	public Game(long seed, Level level) {
		this.level = level;
		this.seed = seed;
		player = new Player(this);
		coinlist = new CoinList(this);
		// TODO 	
	}
	
	public void generarCosas() {
		
		for (int x = getVisibility() / 2; x < level.getInfoL(); x++) {
			tryToAddObstacle(new Obstacle(this, x, getRandomLane()), level.obstacleFrequency());
			
			tryToAddCoin(new Coin(this, x, getRandomLane()), level.coinFrequency());
			
			}

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
	
	public void moveForward() {
		player.moveForward(); // cambiar pues no es necesario tener en cuenta la x del player.
	}
	public void UpdateXeY() {
		coin.UpdateXeY();
	}
	
	public int getVisibility() {
		
		return level.getInfoV();
	}
	
	public int getRoadWidth() {
		
		return level.getInfoR();
	}
	
	public String getGameStatus() {
		
		System.out.println("Distance: ");
		System.out.println("Coins: "+player.numCoins);
		System.out.println("Cicle: ");
		System.out.println("Total obstacles: ");
		System.out.println("Total coins: ");
		System.out.println("Ellaped Time: ");
		return "";
	}
	public void resetGame(Game game) {
		 
		 
		
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
		
		  // return rand.nextDouble();
		return 0.4;

		}

	public String positionToString(int j, int i) {
		// j e i will be called by player ( or car )
		if(j==0 && player.y ==i ) {
			if(checkImpact()) {
				player.numCoins++;;
			}
			return ">";
		}
		if(j==coin.x && i== coin.y && !checkImpact()) {
			return "¢";
		}
		
		
		
		
		return "";
	}
}
