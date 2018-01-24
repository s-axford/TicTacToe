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
            AIPiece = 'X';      //Sets the AI as the X player
        }
        else
        {
            AIPiece = 'O';      //Sets the AI as the O player
        }
    }

    public int absolute(int value)      //Finds the absolute value of an integer
    {
        if (value < 0)  //If the value is a negative number
        {
            value = value * -1; //Changes the number to positive
        }
        return value;   //Returns either the same value or modified integer
    }

    public Move chooseMove(Board board) {

        //Finds random number
        int col = random.nextInt();         //Finds a random integer
        col = this.absolute(col % 3);  //Modifies the random integer to be 0, 1, or 2
        int row = random.nextInt();         //Finds a random integer
        row = this.absolute(row % 3);  //Modifies the random integer to be 0, 1, or 2

        do  {
            //Finds a random location on the board
            col = random.nextInt();         //Finds a random integer
            col = this.absolute(col % 3);   //Modifies the random integer to be 0, 1, or 2
            row = random.nextInt();         //Finds a random integer
            row = this.absolute(row % 3);   //Modifies the random integer to be 0, 1, or 2
        } while (board.get(row, col) != ' ');   //Repeats if the board location is not empty



        Move move = new Move(row, col, AIPiece);    //Creates a move based on the AI selection


        return move;    //Returns the AI's move
    }

}
