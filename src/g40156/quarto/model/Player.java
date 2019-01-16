package g40156.quarto.model;

import java.io.Serializable;

/**
 * allows to manage everything about the players.
 *
 * @author El Arabi Ikrame
 */
public class Player implements Serializable {

    private String player1;
    private String player2;
    private String playerCourant;
    private final int nbrRandom = (int) (2 * Math.random() + 0);

    public Player() {
    }

    /**
     * Allows initializes players
     *
     * @param name1 the name of the player 1
     * @param name2 the name of the player 2
     */
    public Player(String name1, String name2) {
        this.player1 = name1;
        this.player2 = name2;
        this.playerCourant = null;
    }

    /**
     * Allows to select a random player.
     *
     * @return the player picked
     */
    public String pickPlayer() {
        if (nbrRandom == 0) {
            playerCourant = player1;
        } else {
            playerCourant = player2;
        }
        return playerCourant;
    }

    /**
     * Allows the players alternate.
     *
     * @param i the number that will allow to know which player will play
     * @return the next player
     */
    public String alterner(int i) {
        if (i % 2 == 0) {
            playerCourant = player2;
        } else {
            playerCourant = player1;
        }
        return playerCourant;
    }


    public int getNbrRandom() {
        return nbrRandom;
    }

    public String getPlayerCourant() {
        return playerCourant;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer2() {
        return player2;
    }

}
