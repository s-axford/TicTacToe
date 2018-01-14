/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();

    /*
     * TBD: Create additional private members if useful.
     */
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX)
    {

    }

    public Move chooseMove(Board board) {

        //Finds random number
        int col = random.nextInt();
        int col = col % 3;
        int row = random.nextInt();
        int row = row % 3;

        if (board.get(col, row))

    }
}
