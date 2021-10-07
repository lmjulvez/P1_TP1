package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Coin;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.Player;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;
	

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		// TODO fill your code
		//Chance 1
		String[] s = HELP;
		// generar cosas
		for(int l=0;l<s.length;l++)
			System.out.println(s[l]);
		game.generarCosas();
		for(int i=0;i<8;i++) {
		
		String opcion;
		Scanner sc = new Scanner(System.in);
		
		game.getGameStatus();
		if(i==0)
			printGame();
		opcion = sc.next();
		if(opcion.equalsIgnoreCase("q")) {
			game.moveUp();
		}else if(opcion.equalsIgnoreCase("a")) {
			game.moveDown();
		}else if(opcion.equalsIgnoreCase("h")) {
			for(int l=0;l<s.length;l++)
				System.out.println(s[l]);
			
		}else if(opcion.equalsIgnoreCase("r")) {
			game.resetGame(game);
		}
		game.moveForward();

		printGame();
		
		
		}
	}

}
