package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Allows to test the methods of the Class Board.
 *
 * @author El Arabi Ikrame
 */
public class BoardTest {

    private Piece[][] piecesTest = new Piece[Board.SIZE][Board.SIZE];

    /**
     * Allows to test when the position is not free.
     */
    @Test
    public void testIsFreeCas1() {
        try {
            Board instance = new Board();
            instance.addPiece(new Piece(Form.CIRCLE, Color.WHITE,
                    Size.TALL, Fill.HOLLOW), new Position(0, 1));
            assertEquals(false, instance.isFree(new Position(0, 1)));
        } catch (QuartoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Allows to test when the position is free.
     */
    @Test
    public void testIsFreeCas2() {
        System.out.println("isFree");
        Position position = new Position(0, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isFree(position);
        assertEquals(expResult, result);
    }

    /**
     * Allows to test if the position where we add the piece is free.
     *
     * @throws QuartoException if the position is not free
     */
    @Test(expected = QuartoException.class)
    public void testAddPiece1() throws Exception {
        System.out.println("addPiece");
        Position position = new Position(0, 1);
        Board instance = new Board();
        instance.addPiece(new Piece(Form.CIRCLE, Color.WHITE,
                Size.TALL, Fill.HOLLOW), position);
        instance.addPiece(new Piece(Form.SQUARE, Color.WHITE,
                Size.TALL, Fill.HOLLOW), position);
    }

    /**
     * Allows to test if the
     *
     * @throws QuartoException
     */
    @Test
    public void testAddPiece2() throws QuartoException {
        System.out.println("addPiece");
        Piece piece1 = new Piece(Form.CIRCLE, Color.WHITE,
                Size.TALL, Fill.HOLLOW);
        Position position = new Position(0, 1);
        Board instance = new Board();
        instance.addPiece(piece1, position);
    }

    /**
     * Allows to test the board when it is empty.
     */
    @Test
    public void testToString1() {
        Board instance = new Board(piecesTest);
        String s = "   0   1   2   3   \n" + " -----------------\n"
                + "0|   |   |   |   |\n" + " |   |   |   |   |\n"
                + " -----------------\n" + "1|   |   |   |   |\n"
                + " |   |   |   |   |\n" + " -----------------\n"
                + "2|   |   |   |   |\n" + " |   |   |   |   |\n"
                + " -----------------\n" + "3|   |   |   |   |\n"
                + " |   |   |   |   |\n" + " -----------------\n";
        assertEquals((s), instance.toString());
    }

    /**
     * Allows to test the board when we add a piece.
     *
     * @throws QuartoException if the position where we add piece is not free
     */
    @Test
    public void testToString2() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        String s = "   0   1   2   3   \n" + " -----------------\n"
                + "0|   |   |B S|   |\n" + " |   |   |S S|   |\n"
                + " -----------------\n" + "1|   |   |   |   |\n"
                + " |   |   |   |   |\n" + " -----------------\n"
                + "2|   |   |   |   |\n" + " |   |   |   |   |\n"
                + " -----------------\n" + "3|   |   |   |   |\n"
                + " |   |   |   |   |\n" + " -----------------\n";
        b.addPiece(st.takePiece(15), new Position(0, 2));
        assertEquals(s, b.toString());
    }

    @Test
    public void testHasAlignementDiagonalLeft() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        for (int i = 0; i < piecesTest.length; i++) {
            b.addPiece(st.takePiece(0), new Position(i, i));
        }
        assertEquals(true, b.hasAlignement());
    }

    @Test
    public void testHasAlignementDiagonalRight() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        for (int i = 0; i < piecesTest.length; i++) {
            b.addPiece(st.takePiece(0), new Position(i, piecesTest.length - (i + 1)));
        }
        assertEquals(true, b.hasAlignement());
    }

    @Test
    public void testHasAlignementRow() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        for (int i = 0; i < piecesTest.length; i++) {
            b.addPiece(st.takePiece(0), new Position(0, i));
        }
        assertEquals(true, b.hasAlignement());
    }

    @Test
    public void testHasAlignementColumn() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        for (int i = 0; i < piecesTest.length; i++) {
            b.addPiece(st.takePiece(0), new Position(i, 1));
        }
        assertEquals(true, b.hasAlignement());
    }

    @Test
    public void testHasAlignementCasFalse() throws QuartoException {
        Board b = new Board(piecesTest);
        Stock st = new Stock();
        for (int i = 0; i < piecesTest.length - 1; i++) {
            b.addPiece(st.takePiece(0), new Position(i, i));
        }
        assertEquals(false, b.hasAlignement());
    }

    /**
     * Allows to test the board when it is empty.
     */
    @Test
    public void testIsFullCas1() {
        Board b = new Board();
        assertEquals(false, b.isFull());
    }

    /**
     * Allows to test the board when it contains one piece.
     */
    @Test
    public void testIsFullCas2() {
        Board b = new Board();
        Stock stock = new Stock();
        try {
            b.addPiece(stock.takePiece(5), new Position(0, 3));
        } catch (QuartoException e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(false, b.isFull());
    }

    @Test
    public void testIsFullCas3() {
        Board b = new Board();
        Stock stock = new Stock();
        try {
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    b.addPiece(stock.takePiece(0), new Position(i, j));
                }
            }
        } catch (QuartoException e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(true, b.isFull());
    }
}
