package g40156.quarto.view;

import g40156.quarto.model.Player;
import g40156.quarto.model.Quarto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Allows to save and load the game.
 *
 * @author El Arabi Ikrame
 */
public class QuartoSerDes {

    /**
     * Allows to save the game.
     *
     * @param player
     */
    public static void savePlayer(Player player) {
        try {
            FileOutputStream fos2 = new FileOutputStream("player.dat");
            ObjectOutputStream os2 = new ObjectOutputStream(fos2);
            try {
                os2.writeObject(player);
                os2.flush();
            } finally {
                try {
                    os2.close();
                } finally {
                    fos2.close();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Allows to load the game.
     *
     * @return the game
     */
    public static Player loadPlayer() {
        Player player = new Player();
        try {
            FileInputStream fis2 = new FileInputStream("player.dat");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            try {
                player = (Player) ois2.readObject();
            } finally {
                try {
                    ois2.close();
                } finally {
                    fis2.close();
                }
            }
        } catch (IOException e) {
            System.out.println("error1 " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("error2 " + ex.getMessage());
        }
        return player;
    }

    /**
     * Allows to save the game.
     *
     * @param quarto the game to save
     */
    public static void save(Quarto quarto) {
        try {
            //erreura ne pas faire Quarto quarto = new Quarto();
            FileOutputStream fos1 = new FileOutputStream("quarto.dat");
            ObjectOutputStream os1 = new ObjectOutputStream(fos1);
            try {
                os1.writeObject(quarto);
                os1.flush();
            } finally {
                try {
                    os1.close();
                } finally {
                    fos1.close();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Allows to load the game.
     *
     * @return the game
     */
    public static Quarto load() {
        Quarto quarto = new Quarto();
        try {
            FileInputStream fis1 = new FileInputStream("quarto.dat");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            try {
                quarto = (Quarto) ois1.readObject();
            } finally {
                try {
                    ois1.close();
                } finally {
                    fis1.close();
                }
            }
        } catch (IOException e) {
            System.out.println("error1 " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("error2 " + ex.getMessage());
        }
        return quarto;
    }

}
