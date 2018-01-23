/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private char playerPiece = 'W';

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {


        if (challenging) {              //Uses Smart AI
            if (playerIsX) {            //Player is X - AI is O
                ai = new SmartAI(false);//Constructs the AI
                playerPiece = 'X';
            } else {                    //Player is O - AI is X
                ai = new SmartAI(true); //Constructs the AI
                playerPiece = 'O';
            }
        }
        else {                          //Uses Dumb AI
            if (playerIsX) {            //Player is X - AI is O
                ai = new DumbAI(false); //Constructs the AI
                playerPiece = 'X';
            } else {                    //Player is O - AI is X
                ai = new DumbAI(true);  //Constructs the AI
                playerPiece = 'O';
            }
        }
        status = GameStatus.IN_PROGRESS;    //Sets the status of the game to IN_PROGRESS
    }


    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
		return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        if (board.isFull() == true) {
            status = GameStatus.DRAW;       //Changes the status of the game
        } else {
            //Conditions for X to win
            if ((board.get(0,0) == 'X' && board.get(0,1) == 'X' && board.get(0,2) == 'X') || (board.get(1,0) == 'X' && board.get(1,1) == 'X' && board.get(1,2) == 'X') || (board.get(0,2) == 'X' && board.get(1,2) == 'X' && board.get(2,2) == 'X') || (board.get(0,0) == 'X' && board.get(1,0) == 'X' && board.get(2,0) == 'X') || (board.get(0,1) == 'X' && board.get(1,1) == 'X' && board.get(2,1) == 'X') || (board.get(0,2) == 'X' && board.get(1,2) == 'X' && board.get(2,2) == 'X') || (board.get(0,0) == 'X' && board.get(1,1) == 'X' && board.get(2,2) == 'X') || ((board.get(0,2) == 'X' && board.get(1,1) == 'X' && board.get(2,0) == 'X'))) {
                status = GameStatus.X_WON;  //Changes the status of the game
            }
            // Conditions for O to win
            if ((board.get(0,0) == 'O' && board.get(0,1) == 'O' && board.get(0,2) == 'O') || (board.get(1,0) == 'O' && board.get(1,1) == 'O' && board.get(1,2) == 'O') || (board.get(0,2) == 'O' && board.get(1,2) == 'O' && board.get(2,2) == 'O') || (board.get(0,0) == 'O' && board.get(1,0) == 'O' && board.get(2,0) == 'O') || (board.get(0,1) == 'O' && board.get(1,1) == 'O' && board.get(2,1) == 'O') || (board.get(0,2) == 'O' && board.get(1,2) == 'O' && board.get(2,2) == 'O') || (board.get(0,0) == 'O' && board.get(1,1) == 'O' && board.get(2,2) == 'O') || ((board.get(0,2) == 'O' && board.get(1,1) == 'O' && board.get(2,0) == 'O'))) {
                status = GameStatus.O_WON;  //Changes the status of the game
            }
        }
        return status;
    }
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j)
    {
        System.out.println(board.get(i,j));
        if (board.get(i,j) == ' ' && i < 3 && j < 3) {      //If the space is blank and within the 9x9 grid
            Move move = new Move(i, j, playerPiece);        //Creates the given move

            board = new Board(board, move);     //Applies the move to the board
            return true;                        //Piece Successfully Placed
        }

        //Input not valid
        System.out.println ("\n\n\n\n\n\n\n\nInvalid Selection!");
	    System.out.println(board.toString());
        return false;                           //Piece Placement Failed
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece()
    {
		Move newMove = ai.chooseMove(board);    //AI selects empty space
		board = new Board(board, newMove);      //Applies the move to the board
    }
}
