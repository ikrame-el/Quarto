package g40156.quarto.model;

import g40156.quarto.view.Display;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Allows to manage everything related to the game.
 *
 * @author El Arabi Ikrame
 */
public class Quarto implements Serializable {

    private final Stock stock;
    private final Board board;
    private Piece chosenPiece;

    /**
     * The constructor of Quarto
     */
    public Quarto() {
        this.stock = new Stock();
        this.board = new Board();
        this.chosenPiece = null;
    }

    /**
     * Allows to pick one piece of stock
     *
     * @param index the number the piece to pick
     */
    public void pickPiece(int index) {
        try {
            if (chosenPiece != null) {
                //si une pièce a déjà été sélectionnée mais pas encore placée
                throw new IllegalStateException("chosenPiece is not null");
            } else {
                this.chosenPiece = stock.takePiece(index);
            }
        } catch (QuartoException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }

    public Stock getStock() {
        return stock;
    }

    public Board getBoard() {
        return board;
    }

    public Piece getChosenPiece() {
        if (chosenPiece == null) {
            //si chosenPiece est null, c-a-d si la pièce n’a pas été choisie
            throw new IllegalStateException("no such piece has not selected");
        } else {
            return chosenPiece;
        }
    }

    /**
     * Allows to place a piece at the position given.
     *
     * @param position the position where we have to place the piece
     * @throws QuartoException if the position received is not free
     * @throws IllegalStateException if we have not selected a piece
     */
    public void placePiece(Position position) throws QuartoException {
        if (this.chosenPiece == null) {
            throw new IllegalStateException("no such piece has not selected");
        } else {
            board.addPiece(chosenPiece, position);
            this.chosenPiece = null;
        }
    }

    /**
     * Allows to know if the game is over.
     *
     * @return a boolean for say if the game is over or not
     */
    public boolean isOver() {
        return (board.isFull() || (board.hasAlignement()));
    }

    /**
     * Allows to ask the user to enter a new value if he does not enter an
     * integer
     *
     * @param clav the keyboard
     * @return an integer
     */
    public int manageExceptionNotInt(Scanner clav) {
        while (!clav.hasNextInt()) {
            System.out.println("veuillez entrez un entier");
            clav.next();
        }
        return clav.nextInt();
    }

    /**
     * Allows to manage the exception related to stock.
     *
     * @param clav the keyboard
     * @return an integer correct
     */
    public int manageExceptionStock(Scanner clav) {
        int i = manageExceptionNotInt(clav);
        while (i >= stock.size()) {
            System.out.println("veuillez entrer un numero correct");
            i = manageExceptionNotInt(clav);
        }

        return i;
    }

    /**
     * Allows to manage the exception related to column
     *
     * @param clav the keyboard
     * @return an integer correct
     */
    public int manageExceptionPositionColumn(Scanner clav) {
        int i = manageExceptionNotInt(clav);
        while ((i >= Board.SIZE) || (i < 0)) {
            System.out.println("veuillez entrer un numero de colonne correct");
            i = manageExceptionNotInt(clav);
        }
        return i;
    }

    /**
     * Allows to manage the exception related to row.
     *
     * @param clav the keyboard
     * @return an integer correct
     */
    public int manageExceptionPositionRow(Scanner clav) {
        int i = manageExceptionNotInt(clav);
        while ((i >= Board.SIZE) || (i < 0)) {
            System.out.println("veuillez entrer un numero de ligne correct");
            i = manageExceptionNotInt(clav);
        }
        return i;
    }

    /**
     * Allows to manage the game if the position entered by the player is not
     * free
     *
     * @param clav the keyboard
     * @param row the row to assess
     * @param column the column to assess
     * @return the position correct
     */
    public Position manageExceptionPosition(Scanner clav, int row, int column) {
        Position posi = new Position(row, column);
        while (!board.isFree(new Position(row, column))) {
            System.out.println("Veuillez entrer une position libre"+
                    "\nveuillez choisir une ligne: ");
            row = manageExceptionPositionRow(clav);
            System.out.println("veuillez choisir une colonne: ");
            column = manageExceptionPositionColumn(clav);
            posi = new Position(row, column);
        }
        return posi;
    }

    /**
     * The loop which allows to play the game.
     *
     * @param player the current player
     * @param clav the keyboard
     * @throws QuartoException if the position selected is not free
     */
    public void mainLoop(String player, Scanner clav) throws QuartoException {
        Display.displayStock(stock);
        System.out.print(player + " \nveuillez choisir une pièce: ");
        pickPiece(manageExceptionStock(clav));
        Display.displayBoard(board);
        System.out.println(player + "\nveuillez choisir une ligne: ");
        int i = manageExceptionPositionRow(clav);
        System.out.println("veuillez choisir une colonne: ");
        int j = manageExceptionPositionColumn(clav);
        placePiece(manageExceptionPosition(clav, i, j));
        Display.winner(this, player, stock);
    }

    public static void main(String[] args) throws QuartoException {
        Scanner clav = new Scanner(System.in);
        Quarto quarto = new Quarto();
    }
}
