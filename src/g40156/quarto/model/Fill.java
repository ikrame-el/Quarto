package g40156.quarto.model;

/**
 * Allows to know if a piece contains a hollow or not.
 *
 * @author El Arabi Ikrame
 */
//creux ou pas
public enum Fill {

    HOLLOW, SOLID;

    /**
     * Allows to know the first character of an enumeration.
     *
     * @return the first character of an enumeration value
     */
    public char asChar() {
        return (this.toString().charAt(0));
    }
}
