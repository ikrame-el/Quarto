package g40156.quarto.model;

/**
 * The exception will be launched as soon as one asks the model part something
 * incoherent
 *
 * @author El Arabi Ikrame
 */
public class QuartoException extends Exception {

    /**
     * Allows to know the error that occurred
     *
     * @param msg describes the error that occurred
     */
    public QuartoException(String msg) {
        super(msg);
    }
}
