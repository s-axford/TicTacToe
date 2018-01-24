/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

public class Board {

    private char[][] board = new char[3][3];

    /*
     * Construct an empty board (contains all space char's).
     */
    public Board() {
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board[i][j] = ' ';
			}
		}
		
	}

    /*
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {

		other.board[move.getI()][move.getJ()] = move.getPiece(); //Sets given spot on board as designated piece
		this.board = other.board; // sets other board with move applied as the current board
    }

    /*
     * Convert to a string that shows the board's state.
     */
    public String toString() {
		
		String currentGame = "    1   2   3  \n"; //top axis label
		
		for (int i = 0; i < 3; i++) //for all rows

			currentGame = currentGame + (i+1) + " | "; //print values and bars creating rows
			for (int j = 0; j < 3; j++) // for all columns
			{
				currentGame = currentGame + board[i][j] + " | "; //adds bars creating columns
				if ( j == 2){
					currentGame = currentGame + "\n"; // end if line
				}
			}
		}
		
		return currentGame; //returns game as string
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        return board[i][j]; //returns location on board
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        //for all rows and columns
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (board[i][j] == ' ') //if the spot on board is empty
				{
					return false; //return that the board is not full
				}
			}
		}
		return true; //return that the board is full
    }
}
