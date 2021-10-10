package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;

import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	
	private long timeIni;
	

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

	public long getTime() {
		return this.timeIni;
	}
		
	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		//Chance 1
		this.scanner = new Scanner(System.in);
		String[] s = HELP;
		String opcion;
		boolean gameEnd = false;
		// generar cosas
		  System.currentTimeMillis();
		for(int l=0;l<s.length;l++)
			System.out.println(s[l]);
		game.generarCosas();
		game.getGameStatus();
		printGame();
		System.out.print(PROMPT);
		opcion = this.scanner.next();
		while(!gameEnd) {
			if(opcion.equalsIgnoreCase("q")) {
				game.moveUp();
				}else if(opcion.equalsIgnoreCase("a")) {
					game.moveDown();
					}else if(opcion.equalsIgnoreCase("h")) {
						for(int l=0;l<s.length;l++)
							System.out.println(s[l]);
							}else if(opcion.equalsIgnoreCase("r")) {
								
			}
			game.moveForward();
			System.out.println("[DEBUG] "+ "Executing: "+opcion);
			game.getGameStatus();
			printGame();
			gameEnd=game.checkEnd();
			if(!gameEnd) {
			System.out.print(PROMPT);
			opcion = this.scanner.next();
			}
		}
	}

}
