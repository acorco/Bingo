package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WinnerValidator {
    public static Player CheckBingo(Card card, Drum drum){
        ArrayList<Integer> playerNumbers = new ArrayList<Integer>();
        ArrayList<Integer> drumNumbers = drum.getUsedNumbers();
        int k = 0;

        for (int i = 0; i < card.getCard().length; i++) {
            for (int j = 0; j < card.getCard()[i].length; j++, k++) {
                playerNumbers.add(k);
            }
        }

        Collections.sort(playerNumbers);
        Collections.sort(drumNumbers);

        int x = 0;
        for (int i = 0; i < playerNumbers.size(); i++, x++) {
            if (!playerNumbers.get(x).equals(drumNumbers.get(x))){
                return null;
            }


        }
        return card.getPlayer();
    }
}
