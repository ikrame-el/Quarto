package g40156.quarto.model;

import java.io.Serializable;

/**
 * Describes a position on the board
 *
 * @author El Arabi Ikrame
 */
public class Position implements Serializable {

    private final int row;
    private final int column;

    /**
     * Allows to initialize a row and a column
     *
     * @param row the number of line in the board
     * @param column the number of column in the board
     * @throws IllegalArgumentException if parameters are negative
     */
    public Position(int row, int column) {
        /*j'ai choisi de commence la numerotation des lignes et colonnes a 0 
         car en java les tableaux commencent a 0 */
        if ((row < Board.SIZE) && (row >= 0) && (column >= 0)
                && (column < Board.SIZE)) {
            this.column = column;
            this.row = row;
        } else {
            throw new IllegalArgumentException("position incorect");
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
