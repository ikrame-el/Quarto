package g40156.quarto.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class is responsible for characteristics of a piece.
 *
 * @author El Arabi Ikrame
 */
public class Piece implements Serializable {

    private final Form form;
    private final Color color;
    private final Size size;
    private final Fill fill;

    /**
     * Enables initialization the attributes.
     *
     * @param form defines the shape of piece
     * @param color defines the color of piece
     * @param size defines the size of piece
     * @param fill defines if the piece contains a hollow
     * @throws IllegalArgumentException if one the parameters received is null
     */
    public Piece(Form form, Color color, Size size, Fill fill) {
        //si une des caracéristiques est null on lance une quartoException
        if ((size != null) && (form != null) && (fill != null)
                && (color != null)) {
            this.form = form;
            this.color = color;
            this.size = size;
            this.fill = fill;
        } else {
            throw new IllegalArgumentException("Piece incorrect");
        }
    }

    public Form getForm() {
        return form;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public Fill getFill() {
        return fill;
    }

    /**
     * Displays the characteristics of a piece
     *
     * @return the characteristics of a piece
     */
    @Override
    public String toString() {

        return (color + " " + form + " " + fill
                + " " + size + " ");
    }

    /**
     * Allows for the first 4 letter of characters a piece
     *
     * @return the first 4 letter of characters a piece
     */
    public String toSstring() {
        /*permet d'avoir les 4 premieres lettres des caracteristiques 
         d'une piece dans une chaine de caractere*/
        String s;
        s = ((color.asChar() + " " + form.asChar())
                + (fill.asChar() + " " + size.asChar()));
        return s;
    }

    /**
     * Allows comparison 2 objects
     *
     * @param obj the object to compare
     * @return return one boolean for say if the 2 pieces are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Piece) {
            Piece p = (Piece) obj;
            if ((this.color.equals(p.color)) && (this.fill.equals(p.fill))
                    && (this.form.equals(p.form))
                    && (this.size.equals(p.size))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Allows have to an integer which matches the number of the object .
     *
     * @return an integer which matches the number of the object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.form);
        hash = 89 * hash + Objects.hashCode(this.color);
        hash = 89 * hash + Objects.hashCode(this.size);
        hash = 89 * hash + Objects.hashCode(this.fill);
        return hash;
    }

    public static void main(String[] args) {
        Piece aPiece;
        Piece aPiece1;
        aPiece1 = new Piece(Form.CIRCLE, Color.WHITE, Size.TALL, Fill.HOLLOW);
        aPiece = new Piece(Form.CIRCLE, Color.BLACK, Size.SHORT, Fill.SOLID);
        System.out.println(aPiece);
        System.out.println(aPiece.toSstring());
        System.out.println("----------------");
        //verifie si 2 pieces sont les memes
        System.out.println(aPiece.equals(aPiece1));
    }
}
