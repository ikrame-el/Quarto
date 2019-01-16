package g40156.quarto.model;

/**
 * allows to enumerate the shapes can have a piece.
 *
 * @author El Arabi Ikrame
 */
//la forme
public enum Form {

    CIRCLE, SQUARE;

    /**
     * Allows to know the first character of an enumeration.
     *
     * @return the first character of an enumeration value
     */
    public char asChar() {
        return (this.toString().charAt(0));
    }
}
