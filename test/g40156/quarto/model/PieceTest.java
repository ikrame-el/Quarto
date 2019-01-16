package g40156.quarto.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Allows to test the methods of the Class Piece.
 *
 * @author El Arabi Ikrame
 */
public class PieceTest {

    /**
     * Allows to test the method without exception.
     */
    @Test
    public void testToStringCas1() {
        System.out.println("toString");
        Piece instance = new Piece(Form.SQUARE, Color.BLACK,
                Size.SHORT, Fill.SOLID);
        String expResult = "BLACK SQUARE SOLID SHORT ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the method without exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToStringCas2() {
        System.out.println("toString");
        Fill d = null;
        Piece instance = new Piece(Form.SQUARE, Color.BLACK, Size.SHORT, d);
        String expResult = "SOLID SQUARE BLACK SHORT ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
