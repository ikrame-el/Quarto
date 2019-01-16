package g40156.quarto.model;

/**
 * Allows to check classes we wrote in the package model .
 *
 * @author El Arabi Ikrame
 */
public class MainTest {

    /**
     * to interact with the game.
     *
     * @param args the array of String
     * @throws QuartoException if one method throw something incoherent
     */
    public static void main(String[] args) throws QuartoException {
        Board board = new Board();
        System.out.println(board);
        Stock stock = new Stock();
        System.out.println(stock);
        board.addPiece(stock.takePiece(15), new Position(0, 0));
        board.addPiece(stock.takePiece(14), new Position(1, 1));
        board.addPiece(stock.takePiece(13), new Position(2, 2));
        System.out.println(board);
        System.out.println("size of stock = " + stock.size());
        System.out.println(stock);
    }
}
