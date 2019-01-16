package g40156.quarto.model;

/**
 * Allows to enumerate the colors can have a piece.
 *
 * @author El Arabi Ikrame
 */
public enum Color {

    WHITE, BLACK;

    /**
     * Allows to know the first character of an enumeration.
     *
     * @return the first character of an enumeration value
     */
    public char asChar() {
        return (this.toString().charAt(0));
    }
}
