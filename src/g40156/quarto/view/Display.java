package g40156.quarto.view;

import g40156.quarto.model.Board;
import g40156.quarto.model.Color;
import g40156.quarto.model.Fill;
import g40156.quarto.model.Form;
import g40156.quarto.model.Piece;
import g40156.quarto.model.Player;
import g40156.quarto.model.Position;
import g40156.quarto.model.Quarto;
import g40156.quarto.model.QuartoException;
import g40156.quarto.model.Size;
import g40156.quarto.model.Stock;
import java.util.Scanner;

/**
 * Allows to manage everything related to the display.
 *
 * @author El Arabi Ikrame
 */
public class Display {

    /**
     * Allows to save game.
     *
     * @param quarto the game
     */
    public static void saveGame(Quarto quarto, Player player) {
        Scanner clav = new Scanner(System.in);
        System.out.println("voulez-vous sauver la partie?\n"
                + "si oui appuyer sur 1 sinon appuyer sur un autre entier");
        int entier = manageExceptionNotInteger(clav);
        if (entier == 1) {
            QuartoSerDes.save(quarto);
            QuartoSerDes.savePlayer(player);
            //pour arreter le jeu(le 0 veut dire que ca s'est bien passe).
            System.exit(0);
        }
    }

    
    /**
     * Allows to ask the user to enter a new value if he does not enter an
     * integer
     *
     * @param clav the keyboard
     * @return an integer
     */
    public static int manageExceptionNotInteger(Scanner clav) {
        while (!clav.hasNextInt()) {
            System.out.println("veuillez entrez un entier");
            clav.next();
        }
        return clav.nextInt();
    }

    /**
     * Allows to load game.
     *
     * @return the game which had saved
     */
    public static Quarto loadGame() {
        Scanner clav = new Scanner(System.in);
        System.out.println("voulez-vous charger une partie?\n"
                + "si oui appuyer sur 2 sinon appuyer sur un autre entier");
        Quarto q = new Quarto();
        int entier = manageExceptionNotInteger(clav);
        if (entier == 2) {
            q = QuartoSerDes.load();
        }
        return q;
    }
       public static String loadGamePlayer() {
        Scanner clav = new Scanner(System.in);
        Player p = new Player();
        int entier = manageExceptionNotInteger(clav);
        if (entier == 2) {
            p = QuartoSerDes.loadPlayer();
        }
        return p.alterner(p.getNbrRandom());
    }

    /**
     * Allows display all pieces of game.
     *
     * @param stock the stock which contains the pieces of game
     */
    public static void displayStock(Stock stock) {
        int i = 0;
        for (Piece piece : stock.getStock()) {
            if (i <= 9) {
                System.out.print("\033[30m" + (i++)
                        + "  \033[34m" + piece + "\n");
            } else {
                System.out.print("\033[30m" + (i++)
                        + " \033[34m" + piece + "\n");
            }
        }
        System.out.println();

    }

    /**
     * Allows have to dashes that separated the rows.
     *
     * @param b the board of game
     * @return the string that displays dashes in the board
     */
    public static String tiret(Board b) {
        String st = "";
        for (Piece[] piece : b.getPieces()) {
            st = st + "----";
        }
        return st;
    }

    /**
     * Allows have to the number od column.
     *
     * @param b the board of game
     * @return
     */
    public static String numColumn(Board b) {
        String ch = "\033[30m";
        for (int i = 0; i < b.getPieces()[0].length; ++i) {
            ch = ch + ("   " + i);
        }
        return (ch + ("  \n"));
    }

    /**
     * The line wich allows to display the filling and size.
     *
     * @param row the number of row
     * @param b the board of game
     * @return the string with space or with the fillin and size
     */
    public static String secondLineBoard(int row, Board b) {
        String ch = " |";
        for (int i = 0; i < Board.SIZE; i++) {
            if (b.getPieces()[row][i] == null) {
                ch = ch + "   |";
            } else {
                ch = ch + "\033[30m"
                        + b.getPieces()[row][i].getFill().toString().charAt(0)
                        + " \033[31m"
                        + b.getPieces()[row][i].getSize().toString().charAt(0)
                        + "\033[34m|";
            }
        }

        return ("\033[34m" + ch);
    }

    /**
     * The line wich allows to display the color and form.
     *
     * @param ch the string to assess
     * @param piece1 the piece to place
     * @return the string
     */
    public static String firstLineBoard(String ch, Piece piece1) {
        if (piece1 == null) {
            ch = ch + "   |";
        } else {
            ch = ch + "\033[35m" + piece1.getColor().toString().charAt(0)
                    + " \033[32m" + piece1.getForm().toString().charAt(0)
                    + "\033[34m|";
        }
        return ch;
    }

    /**
     * Allows to display the board of game.
     *
     * @param b board of game
     */
    public static void displayBoard(Board b) {
        String ch = numColumn(b) + "\033[34m -" + tiret(b) + "\n";
        int i = 0;
        for (Piece[] piece : b.getPieces()) {
            ch = "\033[34m" + ch + "\033[30m" + i + "\033[34m|";
            for (Piece piece1 : piece) {
                ch = firstLineBoard(ch, piece1);
            }
            ch = (ch + "\n" + secondLineBoard(i, b) + "\n -\033[34m" + tiret(b)
                    + "\n");
            i++;
        }
        System.out.println(ch);
    }

    /**
     * Allows to know if there is a winner, or if the board is filled.
     *
     * @param q the game
     * @param player the player current
     * @param stock the stock which contains the pieces remaining
     */
    public static void winner(Quarto q, String player, Stock stock) {
        if (q.getBoard().hasAlignement()) {
            System.out.println("\033[31mFELICITATION " + player + " VOUS AVEZ GAGNE.");
            Display.displayBoard(q.getBoard());
            System.exit(0);
        }
        if ((q.getBoard().isFull()) && (!q.getBoard().hasAlignement())
                || (stock.isEmpty())) {
            System.out.println("PARTIE TERMINER, IL N Y A PAS DE GAGNANT.");
            Display.displayBoard(q.getBoard());
            System.exit(0);
        }
    }

    public static void main(String[] args) throws QuartoException {
        Board b = new Board();
        b.addPiece(new Piece(Form.CIRCLE, Color.WHITE, Size.TALL, Fill.SOLID),
                new Position(0, 3));
        b.addPiece(new Piece(Form.CIRCLE, Color.BLACK, Size.TALL, Fill.SOLID),
                new Position(0, 0));
        Display.displayBoard(b);
        Stock s = new Stock();
        Display.displayStock(s);
    }
}
