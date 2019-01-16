package g40156.quarto.model;

/**
 * allows to enumerate the sizes can have a piece.
 *
 * @author El Arabi Ikrame
 */
//taille
public enum Size {

    TALL, SHORT;

    /**
     * Allows to know the first character of an enumeration.
     *
     * @return the first character of an enumeration value
     */
    public char asChar() {
        return (this.toString().charAt(0));
    }
}
