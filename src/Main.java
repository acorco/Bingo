import game.Card;
import game.Drum;
import game.Player;
import game.WinnerValidator;

import java.util.Arrays;

/*
 *
 * @author: Alejandro Córcoles
 */
public class Main {
    public static void main(String[] args) {
        boolean winner = false;

        while(!winner) {
            Player player1 = new Player("Alejandro");
            Card card = new Card(player1);
            card.getCardNumbers();

            Drum drum = new Drum();
            System.out.println(drum.getDrum());
            System.out.println("Ha sortit el " + drum.throwNumber());
            System.out.println(drum.getDrum());
            System.out.println(drum.getUsedNumbers());

            Player winnerPlayer = WinnerValidator.CheckBingo(card,drum);
            if (winnerPlayer == null){
                System.out.println(drum.getDrum());
            }else{
                winner = true;
            }
        }
    }
}
