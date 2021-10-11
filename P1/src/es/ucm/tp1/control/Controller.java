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
	
	private static final String[] INFO = new String[] {
			"Available objects:",
			"[Car] the racing car",
			"[Coin] gives 1 coin to the player",
			"[Obstacle] hits car"	,
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
		String[] in=INFO;
		String opcion;
		boolean gameEnd = false;
		boolean pintar=true;
		  System.currentTimeMillis();
		for(int l=0;l<s.length;l++)
			System.out.println(s[l]);
		game.generarCosas();
		game.getGameStatus();
		printGame();
		System.out.print(PROMPT);
		opcion = this.scanner.nextLine();
		game.iniciartiempo();
		while(!gameEnd) {
			if(opcion.equalsIgnoreCase("q")) {
				game.moveUp();
				game.moveForward();
				game.upcicles();
				}else if(opcion.equalsIgnoreCase("a")) {
					game.moveDown();
					game.moveForward();
					game.upcicles();
					}else if(opcion.equalsIgnoreCase("h")) {
						pintar=false;
						for(int l=0;l<s.length;l++)
							System.out.println(s[l]);
					}
						else if(opcion.equalsIgnoreCase("r")) {
								game.resetGame();
						}
								else if(opcion.equalsIgnoreCase("")) {
									game.moveForward();
									game.upcicles();
								}
										else if(opcion.equalsIgnoreCase("t")) {
											game.toggleTest();
											
										}
											else if(opcion.equalsIgnoreCase("i")) {
												for(int l=0;l<in.length;l++)
													System.out.println(in[l]);
												pintar=false;
											}
												else if(opcion.equalsIgnoreCase("e")) {
													gameEnd=true;
													System.out.println("[GAME OVER]: Player leaves the game");
													pintar=false;
												}
													else {
														System.out.println("[ERROR]: Unknown command");
													}
										
			System.out.println("[DEBUG] "+ "Executing: "+opcion);
			
			if(pintar) {
				game.getGameStatus();
				printGame();
			}
			pintar=true;
			if(!gameEnd)
				gameEnd=game.checkEnd();
			if(!gameEnd) {
			System.out.print(PROMPT);
			opcion = this.scanner.nextLine();
			}
		}
	}

}
