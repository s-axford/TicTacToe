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


        if (challenging) {
            if (playerIsX) {
                ai = new SmartAI(false);
            }
            else {
                ai = new SmartAI(true);
            }
        }
        else {
            if (playerIsX) {
                ai = new DumbAI(false);
            } else {
                ai = new DumbAI(true);
            }
        }
        status = GameStatus.IN_PROGRESS;
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
            status = GameStatus.DRAW;
        } else {
            if ((board.get(0,0) == 'X' && board.get(0,1) == 'X' && board.get(0,2) == 'X') || (board.get(1,0) == 'X' && board.get(1,1) == 'X' && board.get(1,2) == 'X') || (board.get(0,2) == 'X' && board.get(1,2) == 'X' && board.get(2,2) == 'X') || (board.get(0,0) == 'X' && board.get(1,0) == 'X' && board.get(2,0) == 'X') || (board.get(0,1) == 'X' && board.get(1,1) == 'X' && board.get(2,1) == 'X') || (board.get(0,2) == 'X' && board.get(1,2) == 'X' && board.get(2,2) == 'X') || (board.get(0,0) == 'X' && board.get(1,1) == 'X' && board.get(2,2) == 'X') || ((board.get(0,2) == 'X' && board.get(1,1) == 'X' && board.get(2,0) == 'X'))) {
                status = GameStatus.X_WON;
            }
            if ((board.get(0,0) == 'O' && board.get(0,1) == 'O' && board.get(0,2) == 'O') || (board.get(1,0) == 'O' && board.get(1,1) == 'O' && board.get(1,2) == 'O') || (board.get(0,2) == 'O' && board.get(1,2) == 'O' && board.get(2,2) == 'O') || (board.get(0,0) == 'O' && board.get(1,0) == 'O' && board.get(2,0) == 'O') || (board.get(0,1) == 'O' && board.get(1,1) == 'O' && board.get(2,1) == 'O') || (board.get(0,2) == 'O' && board.get(1,2) == 'O' && board.get(2,2) == 'O') || (board.get(0,0) == 'O' && board.get(1,1) == 'O' && board.get(2,2) == 'O') || ((board.get(0,2) == 'O' && board.get(1,1) == 'O' && board.get(2,0) == 'O'))) {
                status = GameStatus.O_WON;
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
        if (board.get(i,j) == ' ' && i < 3 && j < 3) {
            Move move = new Move(i, j, 'X');


            board = new Board(board, move);
            return true;
        }

        System.out.println ("\n\n\n\n\n\n\n\nInvalid Selection!");
	    System.out.println(board.toString());
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
