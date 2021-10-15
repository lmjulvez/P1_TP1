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
		
	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage() {
		System.out.print(printer.endMessage());
	}
	
	public void run() {
		//Chance 1
		this.scanner = new Scanner(System.in);
		String[] s = HELP;
		String[] in=INFO;
		String opcion;
		boolean gameEnd = false;
		boolean pintar=true;
		for(int l=0;l<s.length;l++)
			System.out.println(s[l]);
		game.generarCosas();
		game.getGameStatus();
		printGame();
		System.out.print(PROMPT);
		opcion = this.scanner.nextLine();
		System.out.println();
		System.out.println("[DEBUG] "+ "Executing: "+opcion);
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
					}else if(opcion.equalsIgnoreCase("h")||opcion.equalsIgnoreCase("help")) {
						pintar=false;
						for(int l=0;l<s.length;l++)
							System.out.println(s[l]);
					}
						else if(opcion.equalsIgnoreCase("r")||opcion.equalsIgnoreCase("reset")) {
								game.resetGame();
						}
								else if(opcion.equalsIgnoreCase("")) {
									game.moveForward();
									game.upcicles();
								}
										else if(opcion.equalsIgnoreCase("t")||opcion.equalsIgnoreCase("test")) {
											game.toggleTest();
											
										}
											else if(opcion.equalsIgnoreCase("i")||opcion.equalsIgnoreCase("info")) {
												for(int l=0;l<in.length;l++)
													System.out.println(in[l]);
												pintar=false;
											}
												else if(opcion.equalsIgnoreCase("e")||opcion.equalsIgnoreCase("exit")) {
													gameEnd=true;
													this.printEndMessage();
													System.out.println(" Player leaves the game");
													pintar=false;
												}
													else {
														System.out.println("[ERROR]: Unknown command");
														pintar =false;
													}
										
			
			
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
			System.out.println();
			System.out.println("[DEBUG] "+ "Executing: "+opcion);
			}
		}
	}

}
