package g40156.quarto.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Can test the method asChar
 *
 * @author El Arabi Ikrame
 */
public class FormTest {

    @Test
    public void testAsChar1() {
        System.out.println("asChar");
        Form instance = Form.CIRCLE;
        char expResult = 'C';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }

    @Test
    public void testAsChar2() {
        System.out.println("asChar");
        Form instance = Form.SQUARE;
        char expResult = 'S';
        char result = instance.asChar();
        assertEquals(expResult, result);
    }
}
