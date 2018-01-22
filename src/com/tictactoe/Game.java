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

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {

        if (challenging)
        {

        }
        else if (playerIsX)
        {
            ai = new DumbAI(false);
        }
        else
        {
            ai = new DumbAI(true);
        }
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
    public GameStatus getStatus()
    {
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
        if ((board.get(i,j) == ' ') && i < 3 && j < 3)
        {
			Move move = new Move(i,j, 'X');
			board = new Board(board, move);
			return true;
        }
        else
        {
            System.out.print("Invalid Selection");   //Make sure this doesn't skip the players turn and keep going
        }

		
	return false;
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece()
    {
		Move newMove = ai.chooseMove(board);
		board = new Board(board, newMove);
    }
}
