package g40156.evaluation;

import g40156.quarto.model.Color;
import g40156.quarto.model.Fill;
import g40156.quarto.model.Form;
import g40156.quarto.model.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author El ARabi Ikrame
 */
public class Tierco {

    private FlipPiece[][] board;//= new FlipPiece[3][4];
    private final List<FlipPiece> lPieces = new ArrayList<>();

    public Tierco() {
        FlipPiece f1 = new FlipPiece(Form.CIRCLE,
                Color.BLACK, Size.SHORT, Fill.SOLID);
        FlipPiece f2 = new FlipPiece(Form.SQUARE,
                Color.WHITE, Size.SHORT, Fill.SOLID);
        FlipPiece f3 = new FlipPiece(Form.SQUARE,
                Color.WHITE, Size.TALL, Fill.HOLLOW);
        FlipPiece f4 = new FlipPiece(Form.CIRCLE,
                Color.WHITE, Size.SHORT, Fill.HOLLOW);
        FlipPiece f5 = new FlipPiece(Form.CIRCLE,
                Color.WHITE, Size.TALL, Fill.HOLLOW);
        FlipPiece f6 = new FlipPiece(Form.SQUARE,
                Color.WHITE, Size.TALL, Fill.SOLID);
        FlipPiece f7 = new FlipPiece(Form.CIRCLE,
                Color.WHITE, Size.SHORT, Fill.SOLID);
        FlipPiece f8 = new FlipPiece(Form.CIRCLE,
                Color.BLACK, Size.SHORT, Fill.HOLLOW);
        FlipPiece f9 = new FlipPiece(Form.SQUARE,
                Color.BLACK, Size.TALL, Fill.HOLLOW);
        lPieces.add(f1);
        lPieces.add(f2);
        lPieces.add(f3);
        lPieces.add(f4);
        lPieces.add(f5);
        lPieces.add(f6);
        lPieces.add(f7);
        lPieces.add(f8);
        lPieces.add(f9);
        Collections.shuffle(lPieces);
    }

    public void display() {
        String s = "   ";
        s = for1(s);
        System.out.println(s);
    }

    public String tiret() {
        String st = "";
        for (FlipPiece[] piece : board) {
            st = st + "----";
        }
        return st;
    }

    /**
     * Allows to have the header of board and the line with index.
     *
     * @param s string to assess
     * @return a string which contains header of board
     */
    public String for1(String s) {
        for (int i = 0; i < board.length; i++) {
            s = s + i + "   ";
        }
        s = (s + "\n -" + tiret() + "\n");
        for (int i = 0; i < board.length; i++) {
            s = s + (i);
            s = for2(s, i);
            s = s + "|" + "\n |";
            s = for3(s, i);
            s = s + ("\n -" + tiret() + "\n");
        }
        return s;
    }

    /**
     * Allows to have the line without the index
     *
     * @param s the string to assess
     * @param i index of line where to begin
     * @return a string which contains the middle of the method toString
     */
    public String for2(String s, int i) {
        for (int j = 0; j < board[0].length - 1; j++) {
            s = s + "|";
            if (board[i][j] != null) {
                s = s + (board[i][j].toSstring().substring(0, 3));
            } else {
                s = s + ("   ");
            }
        }
        return s;
    }

    /**
     * Allows to have the line without the index
     *
     * @param s the string to assess
     * @param i index of line where to begin
     * @return a string which contains the middle of the method toString
     */
    public String for3(String s, int i) {
        for (int j = 0; j < board[i].length - 1; j++) {
            if (board[i][j] != null) {
                s = s + (board[i][j].toSstring().substring(3, 6));
            } else {
                s = s + ("   ");
            }
            s = s + ("|");
        }
        return s;
    }

    //---------------------------------------------
    public void cas1() {
        int row = 0;
        for (int column = 0; column < 2; column++) {
            System.out.println("|");
            if ((board[row][column] == null)) {
                System.out.println("  |");
            } else {
                System.out.println((board[row][column].getColor()
                        .toString().charAt(row)) + (board[row][column].
                        getFill().toString().charAt(row)) + "|");
            }
        }
    }

    public void dissplay() {

    }

    public void hide(int n) throws IllegalArgumentException {
        if ((n >= lPieces.size()) || (n < lPieces.size())) {
            throw new IllegalArgumentException("n invalide");
        } else {

        }
    }

    public static void main(String[] args) {
        Tierco t = new Tierco();
        t.cas1();
    }
}
