package es.ucm.tp1.logic;

public class Coin {
	
	int x=4,y=1;
	
	private Game game;
	
	public Coin(Game game,int x,int lineaRan) {
		this.game = game;
	}

	public void UpdateXeY() {
		this.x -= 1;
	}
}
