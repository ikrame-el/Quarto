package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Allows to test the methods of the Class Stock.
 *
 * @author El Arabi Ikrame
 */
public class StockTest {

    /**
     * Allows to test if 2 pieces are identical.
     */
    @Test
    public void testTakePiece() {
        System.out.println("takePiece");
        try {
            Stock instance = new Stock();
            assertEquals(new Piece(Form.SQUARE, Color.BLACK,
                    Size.SHORT, Fill.SOLID), instance.takePiece(16));
        } catch (QuartoException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Allows to test when the method size return false
     */
    @Test
    public void testSizeCas1() {
        System.out.println("size1");
        Stock instance = new Stock();
        int expResult = 16;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case when the method size return true
     */
    @Test
    public void testSizeCas2() {
        System.out.println("size2");
        try {
            Stock instance = new Stock();

            for (int j = 0; j < 8; j++) {
                instance.takePiece(0);
            }
            int result = instance.size();
            assertEquals(8, result);
        } catch (QuartoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Allows to test when if the stock is empty
     */
    @Test
    public void testSizeCas3() {
        System.out.println("size3");
        try {
            Stock instance = new Stock();

            for (int j = 0; j < 16; j++) {
                instance.takePiece(0);
            }
            int result = instance.size();
            assertEquals(0, result);
        } catch (QuartoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Allows to test the case when the method return false
     */
    @Test
    public void testIsEmptyCas1() {
        System.out.println("isEmpty1");
        Stock instance = new Stock();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case when the method return true
     */
    @Test
    public void testIsEmptyCas2() {
        try {
            Stock instance = new Stock();
            for (int j = 0; j < 16; j++) {
                instance.takePiece(0);
            }
            assertEquals(true, instance.isEmpty());
        } catch (QuartoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
