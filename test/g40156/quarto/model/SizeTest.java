package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author El Arabi Ikrame
 */
public class SizeTest {

    @Test
    public void testAsCharCas1() {
        System.out.println("asChar");
        Size instance = Size.SHORT;
        char expResult = 'S';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsCharCas2() {
        System.out.println("asChar");
        Size instance = Size.TALL;
        char expResult = 'T';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }

}
