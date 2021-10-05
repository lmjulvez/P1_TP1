package es.ucm.tp1.logic;

public class CoinList {
	
	private Game game;
	private int maxCoins;
    private Coin coinList[];
    private int cont;
	
	
	public CoinList(Game game) {
		this.game = game;
		this.maxCoins = game.getLenght();
		this.coinList = new Coin[maxCoins];
		this.cont =0;
		
	}
	/*public void start() {
		for(int i=0;i<5;i++) {
			coinList[i] = new Coin(game);
		}
	}
	*/
	public void addCoinToArray(Coin coin) {
		
		coinList[this.cont] = coin;
		this.cont++;
	}
}
