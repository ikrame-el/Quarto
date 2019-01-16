package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Allows to test the methods of the Class Position.
 *
 * @author El Arabi Ikrame
 */
public class PositionTest {

    /**
     * Allows to test the method if the line is correct.
     */
    @Test
    public void testGetRowCas1() {
        System.out.println("getRow1");
        Position instance = new Position(3, 0);
        int expResult = 3;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case where the line is greater that SIZE.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetRowCas2() {
        System.out.println("getRow2");
        Position instance = new Position(4, 2);
        int expResult = 4;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case where the line is smaller that SIZE.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetRowCas3() {
        System.out.println("getRow3");
        Position instance = new Position(-6, 5);
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the method if the column is correct.
     */
    @Test
    public void testGetColumnCas1() {
        System.out.println("getColumn1");
        Position instance = new Position(0, 3);
        int expResult = 3;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case where the column is greater that SIZE.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetColumnCas2() {
        System.out.println("getColumn2");
        Position instance = new Position(2, 4);
        int expResult = 4;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Allows to test the case where the column is smaller that SIZE.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetColumnCas3() {
        System.out.println("getColumn3");
        Position instance = new Position(2, -8);
        int expResult = -8;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }
}
