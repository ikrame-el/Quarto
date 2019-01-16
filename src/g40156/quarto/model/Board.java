package g40156.quarto.model;

import java.io.Serializable;

/**
 * Describe the board of game.
 *
 * @author El Arabi Ikrame
 */
public class Board implements Serializable {

    public static final int SIZE = 4;
    private Piece[][] pieces;

    /**
     * Allows to initialize the board.
     */
    public Board() {
        this.pieces = new Piece[SIZE][SIZE];
    }

    /**
     * Allows to initialize the board.
     *
     * @param pieces the board of game
     */
    public Board(Piece[][] pieces) {
        this.pieces = pieces;
    }

    /**
     * Allows to know if the array is free at the given position
     *
     * @param position the position to assess
     * @return a boolean for know if the position is free or not
     */
    public boolean isFree(Position position) {
        return (pieces[position.getRow()][position.getColumn()]) == null;
    }

    /**
     * Place the piece at the given position.
     *
     * @param piece the piece to place
     * @param position the position where we must to place the piece
     * @throws QuartoException if the position is not free
     */
    public void addPiece(Piece piece, Position position)
            throws QuartoException {
        if (isFree(position) == false) {
            throw new QuartoException("The position is not free");
        } else {
            pieces[position.getRow()][position.getColumn()] = piece;
        }
    }

    /**
     * Allows you to view the game board.
     *
     * @return a string which allows to visualize the board
     */
    @Override
    public String toString() {
        String myString = "   ";
        myString = for1(myString);
        return myString;
    }

    /**
     * Allows have to dashes that separated the rows.
     *
     * @return the string that displays dashes in the board
     */
    public String tiret() {
        String myString = "";
        for (Piece[] piece : pieces) {
            myString = myString + "----";
        }
        return myString;
    }

    /**
     * Allows to have the header of board and the line with index.
     *
     * @param myString string to assess
     * @return a string which contains header of board
     */
    public String for1(String myString) {
        for (int i = 0; i < pieces.length; i++) {
            myString = myString + i + "   ";
        }
        myString = (myString + "\n -" + tiret() + "\n");
        for (int i = 0; i < pieces.length; i++) {
            myString = myString + (i);
            myString = for2(myString, i);
            myString = myString + "|" + "\n |";
            myString = for3(myString, i);
            myString = myString + ("\n -" + tiret() + "\n");
        }
        return myString;
    }

    /**
     * Allows to have the line without the index
     *
     * @param myString the string to assess
     * @param row index of line where to begin
     * @return a string which contains the middle of the method toString
     */
    public String for2(String myString, int row) {
        for (int column = 0; column < pieces[0].length; column++) {
            myString = myString + "|";
            if (pieces[row][column] != null) {
                myString = myString + (pieces[row][column].
                        toSstring().substring(0, 3));
            } else {
                myString = myString + ("   ");
            }
        }
        return myString;
    }

    /**
     * Allows to have the line without the index
     *
     * @param s the string to assess
     * @param i index of line where to begin
     * @return a string which contains the middle of the method toString
     */
    public String for3(String s, int i) {
        for (int j = 0; j < pieces[0].length; j++) {
            if (pieces[i][j] != null) {
                s = s + (pieces[i][j].toSstring().substring(3, 6));
            } else {
                s = s + ("   ");
            }
            s = s + ("|");
        }
        return s;
    }

    /**
     * Allow to know if the board is full.
     *
     * @return a boolean for say if the board is full or no
     */
    public boolean isFull() {
        boolean isFull = true;
        int row = 0;
        int column;
        while ((row < pieces.length) && (isFull)) {
            column = 0;
            while ((column < pieces.length) && (isFull)) {
                if (pieces[row][column] == null) {
                    isFull = false;
                }
                column++;
            }
            row++;
        }
        return isFull;
    }

    /**
     * Allows to know if one the diagonal contains a correct alignment.
     *
     * @return a boolean pour say if we manage to do an alignment correct
     */
    public boolean diagonal() {
        int size = pieces.length;
        /*le 1er parametre correspond a la ligne le 2eme a la colonne le 3eme
         incrementeur de la ligne et le 4eme incrementeur de la coolonne*/
        return ((cptColor(0, 0, 1, 1) == size - 1)
                || (cptFill(0, 0, 1, 1) == size - 1)
                || (cptForm(0, 0, 1, 1) == size - 1)
                || (cptSize(0, 0, 1, 1) == size - 1)
                || (cptColor(0, size - 1, 1, -1) == size - 1)
                || (cptFill(0, size - 1, 1, -1) == size - 1)
                || (cptForm(0, size - 1, 1, -1) == size - 1)
                || (cptSize(0, size - 1, 1, -1) == size - 1));
    }

    /**
     * Allows to know if a row or column contains a correct alignment.
     *
     * @return a boolean pour say if we manage to do an alignment correct
     */
    public boolean RowColumn() {
        int i = 0;
        boolean win = false;
        while ((i < pieces.length) && (!win)) {
            /*pour les ligne on va à chaque fois ajouter 1 à la colonne(column+1) 
             et la ligne restera la même(row+0) tandis que pour les colonnes
             on va ajouter 1 a la ligne (row+1) et la colonne restera la même 
             (column+0) */
            if ((cptColor(i, 0, 0, 1) == pieces.length - 1)
                    || (cptFill(i, 0, 0, 1) == pieces.length - 1)
                    || (cptForm(i, 0, 0, 1) == pieces.length - 1)
                    || (cptSize(i, 0, 0, 1) == pieces.length - 1)
                    || (cptColor(0, i, 1, 0) == pieces.length - 1)
                    || (cptFill(0, i, 1, 0) == pieces.length - 1)
                    || (cptForm(0, i, 1, 0) == pieces.length - 1)
                    || (cptSize(0, i, 1, 0) == pieces.length - 1)) {
                win = true;
            }
            i++;
        }
        return win;
    }

    /**
     * Allows to know if the boxes containing dirRow piece.
     *
     * @param row the row to assess
     * @param column the column to assess
     * @param dirRow what to add to the row
     * @param dirColumn what to add to the column
     * @return dirRow boolean for say if the boxes is null or no
     */
    public boolean free(int row, int column, int dirRow, int dirColumn) {
        return ((!isFree(new Position(row, column)))
                && ((!isFree(new Position(row + dirRow, column + dirColumn)))));
    }

    /**
     * Allows to know how many pieces have the same color
     *
     * @param row the row to assess
     * @param col the col to assess
     * @param dirR what to add to the row
     * @param dirC what to add to the col
     * @return the number of pieces that have the same color
     */
    public int cptColor(int row, int col, int dirR, int dirC) {
        int cpt = 0;
        //je sauvegarde dirR et dirC car ils vont changer de valeur dans la boucle
        int a = dirR;
        int b = dirC;
        while ((dirR < pieces.length) && (dirC < pieces.length)
                && (free(row, col, dirR, dirC)) && (pieces[row][col].getColor()
                == pieces[row + dirR][col + dirC].getColor())) {
            cpt++;
            dirR = dirR + a;
            dirC = dirC + b;
        }
        return cpt;
    }

    /**
     * Allows to know how many pieces have the same shape.
     *
     * @param row the row to assess
     * @param col the column to assess
     * @param dirR what to add to the row
     * @param dirC what to add to the column
     * @return the number of pieces that have the same shape
     */
    public int cptForm(int row, int col, int dirR, int dirC) {
        int cpt = 0;
        //je sauvegarde a et b car ils vont changer de valeur dans la boucle
        int a = dirR;
        int b = dirC;
        while ((dirR < pieces.length) && (dirC < pieces.length)
                && free(row, col, dirR, dirC) && (pieces[row][col].getForm()
                == pieces[row + dirR][col + dirC].getForm())) {
            cpt++;
            dirR = dirR + a;
            dirC = dirC + b;
        }
        return cpt;
    }

    /**
     * Allows to know how many pieces have the same filling.
     *
     * @param row the row to assess
     * @param col the column to assess
     * @param dirR what to add to the row
     * @param dirC what to add to the column
     * @return the number of pieces that have the same filling
     */
    public int cptFill(int row, int col, int dirR, int dirC) {
        int cpt = 0;
        //je sauvegarde dirR et dirC car ils vont changer de valeur dans 
        //la boucle
        int a = dirR;
        int b = dirC;
        while ((dirR < pieces.length) && (dirC < pieces.length)
                && free(row, col, dirR, dirC) && (pieces[row][col].getFill()
                == pieces[row + dirR][col + dirC].getFill())) {
            cpt++;
            dirR = dirR + a;
            dirC = dirC + b;
        }
        return cpt;
    }

    /**
     * Allows to know how many pieces have the same size.
     *
     * @param row the row to assess
     * @param col the column to assess
     * @param dirR what to add to the row
     * @param dirC what to add to the column
     * @return the number of pieces that have the same size
     */
    public int cptSize(int row, int col, int dirR, int dirC) {
        int cpt = 0;
        //je sauvegarde a et b car ils vont changer de valeur dans la boucle
        int a = dirR;
        int b = dirC;
        while ((dirR < pieces.length) && (dirC < pieces.length)
                && free(row, col, dirR, dirC) && (pieces[row][col].getSize()
                == pieces[row + dirR][col + dirC].getSize())) {
            cpt++;
            dirR = dirR + a;
            dirC = dirC + b;
        }
        return cpt;
    }

    /**
     * allows to know if we win.
     *
     * @return a boolean for say if we win or no
     */
    public boolean hasAlignement() {
        return (RowColumn() || diagonal());
    }

    public Piece[][] getPieces() {
        return pieces;
    }

}
