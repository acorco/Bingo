import com.sun.security.jgss.GSSUtil;
import game.Card;
import game.Drum;
import game.Player;
import game.WinnerValidator;
import util.Color;
import util.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

/*
 *
 * @author: Alejandro Córcoles
 */
public class Main {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu(){
        System.out.println(Color.BLUE_BOLD);
        System.out.println("BINGO");
        System.out.println("-------------------");
        System.out.println("1. Juga 1 jugador");
        System.out.println("2. Juga 2 jugadors");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println(Color.RESET);
        int opc = Logger.getInt("Opció: ");
        boolean winner;
        boolean line;

        switch(opc){
            case 1:
                winner = false;
                line = false;

                Player player1 = new Player(Logger.getStringColor(Color.BLUE_BOLD, "Introdueix el teu nom: "));
                Card card = new Card(player1);
                Drum drum = new Drum();
                Logger.println(Color.BLUE_BOLD, "EL TEU CARTRÓ: ");
                card.getCardNumbers(drum);

                while(!winner) {

                    System.out.println();
                    if (drum.getDrum().size() > 0) {
                        System.out.print(Color.BLUE_BOLD);
                        System.out.println("HA SORTIT EL " + drum.throwNumber());
                        System.out.print(Color.RESET);
                    }
                    card.getCardNumbers(drum);
                    System.out.println();
                    Collections.sort(drum.getUsedNumbers());



                    Player winnerPlayer = WinnerValidator.CheckBingo(card,drum);

                    if (!line){
                        Player linePlayer = WinnerValidator.CheckLine(card,drum);
                        if (linePlayer != null) {
                            Logger.println(Color.GREEN_BOLD, "LINEA! " + linePlayer.getName().toUpperCase() + " HA CANTAT LÍNEA.");
                            line = true;
                        }
                    }

                    if (winnerPlayer == null){
                        anotherNumberChoice();
                    }else{
                        System.out.println();
                        Logger.println(Color.GREEN_BOLD, "BINGO! " + winnerPlayer.getName().toUpperCase() + " HA CANTAT BINGO!");
                        System.out.println();
                        System.out.println();

                        Logger.println(Color.BLUE_BOLD, "HAN SORTIT ELS SEGÜENTS NÚMEROS: ");
                        drum.getNumbersYouHave(card);
                        displayMenu();
                        winner = true;
                    }
                }
            case 2:
                winner = false;
                line = false;
                Drum drum2 = new Drum();
                Player player_1 = new Player(Logger.getStringColor(Color.BLUE_BOLD, "Introdueix el nom jugador 1: "));
                Player player_2 = new Player(Logger.getStringColor(Color.BLUE_BOLD, "Introdueix el neu nom jugador 2: "));
                Card[] cardArray = new Card[]{new Card(player_1), new Card(player_2)};

                for (Card eachCard : cardArray) {
                    Logger.println(Color.BLUE_BOLD, "AQUEST ES EL CARTRÓ DE " + eachCard.getPlayer().getName().toUpperCase());
                    eachCard.getCardNumbers(drum2);
                }

                while(!winner) {
                    System.out.println();
                    if (drum2.getDrum().size() > 0) {
                        System.out.print(Color.BLUE_BOLD);
                        System.out.println("HA SORTIT EL " + drum2.throwNumber());
                        System.out.print(Color.RESET);
                    }


                    for (Card eachCard : cardArray) {
                        Logger.println(Color.BLUE_BOLD, "CATRÓ DE " + eachCard.getPlayer().getName().toUpperCase());
                        eachCard.getCardNumbers(drum2);
                        System.out.println();
                        Collections.sort(drum2.getUsedNumbers());

                        Player winnerPlayer = WinnerValidator.CheckBingo(eachCard, drum2);

                        if (!line) {
                            Player linePlayer = WinnerValidator.CheckLine(eachCard, drum2);
                            if (linePlayer != null) {
                                Logger.println(Color.GREEN_BOLD, "LINEA! " + linePlayer.getName().toUpperCase() + " HA CANTAT LÍNEA.");
                                line = true;
                            }
                        }

                        if (winnerPlayer != null) {
                            System.out.println();
                            Logger.println(Color.GREEN_BOLD, "BINGO! " + winnerPlayer.getName().toUpperCase() + " HA CANTAT BINGO!");
                            Logger.println(Color.BLUE_BOLD, "HAN SORTIT ELS SEGÜENTS NÚMEROS: ");
                            drum2.getNumbersYouHave(eachCard);
                            displayMenu();
                            winner = true;
                        }
                    }

                    anotherNumberChoice();
                    System.out.println();
                }
            case 3:
                Logger.println(Color.BLUE_BOLD, "Joc finalitzat.");
                Runtime.getRuntime().exit(0);
                break;
            default:
                Logger.println(Color.RED_BOLD, "Aquesta opció no existeix.");
                displayMenu();


        }
    }
    public static void anotherNumberChoice(){
        char option = Logger.getChar("VOLS UN ALTRE NÚMERO? (S/N): ");
        switch (option){
            case 's': break;
            case 'n':
                System.out.println();
                Logger.println(Color.BLUE_BOLD, "Joc finalitzat");
                displayMenu();
                break;
            default:
                Logger.println(Color.RED_BOLD, "Introdueix una opció vàlida.");
                anotherNumberChoice();
        }
    }
}
