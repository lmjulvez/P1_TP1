package es.ucm.tp1.logic;

public class CoinList {
	
	private Game game;

	Coin coinList[] = new Coin[5];
	
	public CoinList(Game game) {
		this.game = game;
	}
	public void start() {
		for(int i=0;i<5;i++) {
			coinList[i] = new Coin(game);
		}
	}
	
	
	
	
	
	
}
