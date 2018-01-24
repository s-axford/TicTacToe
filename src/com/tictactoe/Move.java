/**
 * Represents a move (by the player or the AI) to a particular cell.
 *
 * STUDENTS: Nothing to change here.
 *
 * @author Andrew Vardy
 */

public class Move {
    private int i;
    private int j;
    private char piece;

    /**
     * Construct a move, which represents placing the given type of piece in
     * column i, row j.
     */
    public Move(int i, int j, char piece) {
        this.piece = piece;
        this.i = i;
        this.j = j;
    }
    
    public int getI() {
        return i;
    } //returns row
    
    public int getJ() {
        return j;
    } //returns column
    
    public char getPiece() {
        return piece;
    } //returns piece to be placed on board
}
