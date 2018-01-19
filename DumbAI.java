/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Random;

public class DumbAI implements AI {

    private Random random = new Random();
    private char AIPiece;
    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a DumbAI.
     *
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        if (aiIsX)
        {
            AIPiece = 'X';
        }
        else
        {
            AIPiece = 'O';
        }
    }

    public Move chooseMove(Board board) {
        bool found = false;
        //Finds random number
        while (found == false && board.isFull() == false){
            int col = random.nextInt();
            col = col % 3;
            int row = random.nextInt();
            row = row % 3;

            if (board.get(col, row) == ' ') {
                found = true;
                Move move = new Move(row, col, AIPiece);
            }
            return move;
        }
    }
}
