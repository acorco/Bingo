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
        System.out.println("---------");
        System.out.println("1. Juga 1 jugador");
        System.out.println("2. Juga 2 jugadors");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println(Color.RESET);
        int opc = Logger.getInt("Opció: ");

        switch(opc){
            case 1:
                boolean winner = false;
                boolean line = false;

                Player player1 = new Player(Logger.getStringColor(Color.BLUE_BOLD, "Introdueix el teu nom: "));
                Card card = new Card(player1);
                Drum drum = new Drum();
                Logger.println(Color.BLUE_BOLD, "EL TEU CARTRÓ: ");
                card.getCardNumbers(drum);

                while(!winner) {

                    System.out.println();
                    if (drum.getDrum().size() > 0) {
                        System.out.print(Color.BLUE_BOLD);
                        System.out.println("Ha sortit el " + drum.throwNumber());
                        System.out.print(Color.RESET);
                    }
                    card.getCardNumbers(drum);
                    Collections.sort(drum.getUsedNumbers());
                    Logger.println(Color.BLUE_BOLD, "De moment han sortit els següents números:");
                    System.out.println(drum.getUsedNumbers());

                    Player winnerPlayer = WinnerValidator.CheckBingo(card,drum);

                    if (!line){
                        Player linePlayer = WinnerValidator.CheckLine(card,drum);
                        if (linePlayer != null) {
                            Logger.println(Color.GREEN_BOLD, "LINEA! " + linePlayer.getName() + " HA CANTAT LÍNEA.");
                            line = true;
                        }
                    }

                    if (winnerPlayer == null){
                        anotherNumberChoice();
                    }else{
                        System.out.println();
                        Logger.println(Color.GREEN_BOLD, "BINGO! " + winnerPlayer.getName() + " ha cantat bingo!");
                        winner = true;
                    }
                }
            case 2:
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
        char option = Logger.getStringColor(Color.BLUE_BOLD,"Vols un altre número? s/n: ").toLowerCase().charAt(0);
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
