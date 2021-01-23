import game.Card;
import game.Drum;
import game.Player;
import game.WinnerValidator;
import util.Color;
import util.Logger;

import java.util.Arrays;
import java.util.Locale;

/*
 *
 * @author: Alejandro Córcoles
 */
public class Main {
    public static void main(String[] args) {
        boolean winner = false;
        Player player1 = new Player("Alejandro");
        Card card = new Card(player1);


        Drum drum = new Drum();
        while(!winner) {

            card.getCardNumbers(drum);
            System.out.println("Ha sortit el " + drum.throwNumber());
            System.out.println(drum.getUsedNumbers());

            Player winnerPlayer = WinnerValidator.CheckBingo(card,drum);
            if (winnerPlayer == null){
                anotherNumberChoice();
            }else{
                Logger.println(Color.GREEN_BOLD, "BINGO! " + card.getPlayer() + " ha cantat bingo!");
                winner = true;
            }
        }
    }

    public static void anotherNumberChoice(){
        char option = Logger.getString("Vols un altre número? s/n: ").toLowerCase().charAt(0);
        switch (option){
            case 's': break;
            case 'n':
                System.out.println("Joc finalitzat");
                break;
            default:
                System.out.println("Introdueix una opció vàlida.");
                anotherNumberChoice();
        }
    }
}
