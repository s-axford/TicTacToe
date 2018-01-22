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

    public int absolute(int value)
    {
        if (value < 0)
        {
            value = value * -1;
        }
        return value;
    }

    public Move chooseMove(Board board) {

        //Finds random number
        int col = random.nextInt();
        col = this.absolute(col % 3);
        System.out.println(col);
        int row = random.nextInt();
        row = this.absolute(row % 3);
        System.out.println(row);

        do  {
            col = random.nextInt();
            col = this.absolute(col % 3);
            row = random.nextInt();
            row = this.absolute(row % 3);
            System.out.println(row);
        } while (board.get(row, col) != ' ');

        //Print AI Selection
        System.out.println("AI Selection Info: ");
        System.out.println(row + 1);
        System.out.println(col + 1);

        Move move = new Move(row, col, AIPiece);


        return move;
    }

}
