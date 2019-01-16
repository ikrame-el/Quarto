package g40156.evaluation;

import g40156.quarto.model.Color;
import g40156.quarto.model.Fill;
import g40156.quarto.model.Form;
import g40156.quarto.model.Piece;
import g40156.quarto.model.Size;

/**
 *
 * @author El Arabi Ikrame
 */
public class FlipPiece extends Piece {

    private Piece piece;
    private boolean faceDown;

    public FlipPiece(Form form, Color color, Size size, Fill fill) {
        super(form, color, size, fill);
    }


    public Piece getPiece() {
        return piece;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }

}
