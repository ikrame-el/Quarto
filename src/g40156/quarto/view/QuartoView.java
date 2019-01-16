package g40156.quarto.view;

import g40156.quarto.model.Player;
import g40156.quarto.model.Quarto;
import g40156.quarto.model.QuartoException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Contains the main method of game.
 *
 * @author El Arabi Ikrame
 */
public class QuartoView implements Serializable {

    Quarto quarto;

    /**
     * The constructor which initialize the game
     */
    public QuartoView() {
        this.quarto = new Quarto();
    }

    /**
     * Allows to inscribe the players.
     *
     * @param clav the keyboard
     * @param player the player to inscribe
     * @return the player current
     */
    public Player askPlayer(Scanner clav, Player player) {
        System.out.println("Inscrire le premier joueur: ");
        player.setPlayer1(clav.nextLine());
        System.out.println("Inscrire le deuxieme joueur: ");
        player.setPlayer2(clav.nextLine());
        System.out.println("A");
        //joueur = player.pickPlayer();
        return (player);
    }

    /**
     * The main method of game
     */
    public void play() {
        try {
            Scanner clav = new Scanner(System.in);
            quarto = Display.loadGame();
            String joueur = null;
            Player player = new Player();
            System.out.println("Si vous souhaiter reprendre les mêmes joueurs "
                    + "\nde la partie charger appuyer sur 2 sinon si vous "
                    + "\nsouhaitez reprendre avec des nouveaux joueurs appuyez"
                    + " sur 1");
            int choice = clav.nextInt();
            if (choice == 1) {
                player = askPlayer(clav, player);
                joueur = player.pickPlayer();
            } else {
                joueur = Display.loadGamePlayer();
            }
            int i = player.getNbrRandom();
            quarto.mainLoop(joueur, clav);
            do {
                joueur = player.alterner(i);
                Display.saveGame(quarto, player);
                quarto.mainLoop(joueur, clav);
                i++;
            } while (!quarto.isOver());
        } catch (QuartoException ex) {
            System.out.println("error : " + ex.getMessage());

        }
    }

    public static void main(String[] args) {
        QuartoView q = new QuartoView();
        q.play();
    }
}
