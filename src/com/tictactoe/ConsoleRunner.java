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
    private boolean challenging;

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
        boolean done = false;
        String input = " ";
       while (done == false){
            System.out.println("Do you want to play as X? (Y/N)");
            input = scanner.next();
            if (input.matches("Y")) {
                playerIsX = true;
                done = true;
            } else if (input.matches("N")) {
                playerIsX = false;
                done = true;
            }
            else {
                System.out.println("Not valid input");
            }
        }

        input = " ";
        done = false;
        while (done == false) {
            System.out.print("Do you want a challenge? (Y/N)");
            input = scanner.next();
            if (input.matches("Y")) {
                challenging = true;
                done = true;
            } else if (input.matches("N")) {
                challenging = false;
                done = true;
            }
            else {
                System.out.println("Not valid input");
            }
        }
        game = new Game(playerIsX , challenging);
    }

    private void oneRound(boolean playerIsX)
    {
        Integer row;
        Integer col;

        if (playerIsX)
        {
            System.out.println("What row?");
            row = scanner.nextInt();
            System.out.println("What col?");
            col = scanner.nextInt();
            game.placePlayerPiece(row - 1, col - 1);
            game.aiPlacePiece();
        }
        else
        {
            game.aiPlacePiece();

            System.out.println("What row?");
            row = scanner.nextInt();
            System.out.println("What col?");
            col = scanner.nextInt();
            game.placePlayerPiece(row - 1, col - 1);
        }
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {

        //Creates a new game

        //while (game.getStatus() == IN_PROGRESS)
        //{
            //print board before round
            Board board = game.getBoard();
            System.out.println(board.toString());

            this.oneRound(playerIsX);
            System.out.println(board.toString());
        //}


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
