/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Spencer Axford and Noah Gallant
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {

        String input = null;
        while (input.matches("N") || input.matches("Y")) {
            System.out.println("Do you want to play as X? (Y/N)");
            input = scanner.next();
            if (input.matches("Y")) {
                playerIsX = true;
            } else if (input.matches("N")) {
                boolean playerIsX = false;
            }
            else {
                System.out.println("Not valid input");
            }
        }
        input = null;
        while (input.matches("N") || input.matches("Y")) {
            System.out.print("Do you want a challenge? (Y/N)");
            input = scanner.next();
            if (input.matches("Y")) {
                boolean challenging = true;
            } else if (input.matches("N")) {
                boolean challenging = false;
            }
            else {
                System.out.println("Not valid input");
            }
        }
        game = new game(playerIsX , challenging);
    }
	
    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
    
	/*
	 *	Starts collecting game options 
	 */
	System.out.print("Do you want to play as X? (Y/N)");
	String player = System.console().readLine();
	
	System.out.print("Do you want a challenge? (Y/N)");
	String difficulty = System.console().readLine();
	 
	System.out.print("Player: " + player);
	System.out.print("Difficulty: " + difficulty);
	 
	/* TBD
         *
         * Use the 'nextInt' method of Scanner class to read user responses as
         * integers.
         *
         * There is enough work to do here that you may want to introduce
         * private methods (i.e. helper methods).
         */
    }
}
