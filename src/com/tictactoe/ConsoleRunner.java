/*
  ConsoleRunner:  Prompts the user to determine the parameters of the Game
  constructor.  Creates a Game and manages the alternating calls to the
  ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
  of the board to the console.

  @author Spencer Axford and Noah Gallant
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

        //Will repeat if player inputs invalid characters
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

        //Will repeat if player inputs invalid characters
        while (done == false) {
            System.out.print("Do you want a challenge? (Y/N)");
            input = scanner.next();     //Expecting 'Y' or 'N'
            if (input.matches("Y")) {           //If the user wants a challenge
                challenging = true;     //Sets to SmartAI
                done = true;
            } else if (input.matches("N")) {    //If the user doesn't want a challenge
                challenging = false;    //Sets to DumbAI
                done = true;
            }
            else {
                System.out.println("Not valid input");  //User inputted an invalid character
            }
        }
        game = new Game(playerIsX , challenging);       //Creates a new game
    }


    /*
     *  One round is considered a single piece placemed by both the player and the AI
     */
    private void oneRound(boolean playerIsX)
    {
        Integer row;        //Stores the user inputted row
        Integer col;        //Stores the user inputted col
        Board board = game.getBoard();  //Creates a new board in the current state

        if (playerIsX) {

            //Places the users piece
            do {
                //Prompts the player to choose a move
                System.out.println ("\n\n\n\n\n\n\n\nMake Your Move");
                System.out.println(board.toString());
                System.out.println("What row?");
                row = scanner.nextInt() - 1;            //Users row selection
                System.out.println("What col?");
                col = scanner.nextInt() - 1;            //Users col selection
            } while (game.placePlayerPiece(row, col) == false); //Will continue prompting the user if invalid input is entered

            //Places the AI piece
            if (game.getStatus() == GameStatus.IN_PROGRESS) {
                game.aiPlacePiece();
            }

        } else {

            //Places the AI piece first
            if (game.getStatus() == GameStatus.IN_PROGRESS) {
                game.aiPlacePiece();
            }

            //Places the player piece second
            if (game.getStatus() == GameStatus.IN_PROGRESS) {
                do {
                    //Prompts the player to choose a move
                    System.out.println ("\n\n\n\n\n\n\n\nMake Your Move");
                    System.out.println(board.toString());
                    System.out.println("What row?");
                    row = scanner.nextInt() - 1;
                    System.out.println("What col?");
                    col = scanner.nextInt() - 1;
                } while (game.placePlayerPiece(row, col) == false);         //Will repeat if incorrect input is entered by the user
            }
        }
    }


    /*
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {

        //Creates a new game
        Board board;

        //Calls another round until the game status changes
        do
        {
            this.oneRound(playerIsX);       //Calls the next round of the game
        } while (game.getStatus() == GameStatus.IN_PROGRESS);       //Will repeat until someone has one, or the board is full

        //Continues below when the game is finished
        board = game.getBoard();
        System.out.println("\n\n\n\n\n\n\n\n\nGame Over\n");
        System.out.println(board.toString());

        //Checks if 'O' has won
        if (game.getStatus() == GameStatus.O_WON) {
            System.out.println("'O' wins");
        }

        //Checks if 'X' has won
        if (game.getStatus() == GameStatus.X_WON) {
            System.out.println("'X' wins");
        }

        //Check if there has been a draw
        if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("Draw");
        }

    }
}
