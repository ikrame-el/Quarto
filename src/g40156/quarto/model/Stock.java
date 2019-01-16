package g40156.quarto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The stock that contains the pieces of the game.
 *
 * @author El Arabi Ikrame
 */
public class Stock implements Serializable {

    private final List<Piece> pieces = new ArrayList<>();

    /**
     * Allows to initialize the stock with pieces.
     */
    public Stock() {
        //remplie le stock avec les 16 pieces
        for (Color color : Color.values()) {
            for (Size size : Size.values()) {
                for (Fill fill : Fill.values()) {
                    for (Form form : Form.values()) {
                        Piece piece = new Piece(form, color, size, fill);
                        pieces.add(piece);
                    }
                }
            }
        }
    }

    /**
     * Allows display all pieces of game.
     *
     * @return a string that contains all pieces of game
     */
    @Override
    public String toString() {
        String result = "";
        int i = 0;
        for (Piece piece : pieces) {
            result = result + "\n " + (i++) + " " + piece;
        }
        return result;
    }

    public List<Piece> getStock() {
        return pieces;
    }

    /**
     * Allows to remove a piece of the list and return.
     *
     * @param i the number of the piece in the list you must remove
     * @return the piece that has been deleted
     * @throws QuartoException if the parameter i is out of allowed values
     */
    public Piece takePiece(int i) throws QuartoException {
        if ((i >= pieces.size()) || (i < 0)) {
            throw new QuartoException("the index is incorrect");
        } else {
            // remove permet de supprimer un element de la liste et le retourne
            return pieces.remove(i);
        }
    }

    /**
     * Allows to know the number of pieces still in stock.
     *
     * @return the number of pieces still in stock
     */
    public int size() {
        return (this.pieces.size());
    }

    /**
     * Allows to know if the stock is empty.
     *
     * @return a boolean to say if the stock is empty
     */
    public boolean isEmpty() {
        return (pieces.isEmpty());
    }

    public static void main(String[] args) {
        Stock s = new Stock();
        System.out.println(s);
        System.out.println("display: ");
        System.out.println("avant: " + s.size());
        System.out.println("-------------------");
        int i = -1;
        System.out.println("=======");
        /* try {
         System.out.println("takepice: " + s.takePiece(-1));
         } catch (QuartoException ex) {
         System.out.println(ex.getMessage());
         }*/
        System.out.println("apres" + s.size());
        System.out.println(s.isEmpty());
    }
}
