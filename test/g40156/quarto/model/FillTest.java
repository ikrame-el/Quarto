package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Can test the method asChar
 *
 * @author El Arabi Ikrame
 */
public class FillTest {

    @Test
    public void testAsChar1() {
        System.out.println("asChar");
        Fill instance = Fill.HOLLOW;
        char expResult = 'H';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsChar2() {
        System.out.println("asChar");
        Fill instance = Fill.SOLID;
        char expResult = 'S';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }
}
