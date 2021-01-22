import game.Card;
import game.Player;

import java.util.Arrays;

/*
 *
 * @author: Alejandro Córcoles
 */
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alejandro");
        Card card = new Card(player1);
        card.getCard();

    }
}
