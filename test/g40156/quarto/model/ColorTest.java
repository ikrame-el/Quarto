package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Can test the method asChar
 *
 * @author El Arabi Ikrame
 */
public class ColorTest {

    @Test
    public void testAsChar1() {
        System.out.println("asChar");
        Color instance;
        instance = Color.WHITE;
        char expResult = 'W';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsChar2() {
        System.out.println("asChar");
        Color instance;
        instance = Color.BLACK;
        char expResult = 'B';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }
}
