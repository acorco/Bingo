package game;

import util.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WinnerValidator {
    public static Player checkBingo(Card card, Drum drum) {
        for (int i = 0; i < card.getCard().length; i++) {
            for (int j = 0; j < card.getCard()[i].length; j++) {
                if (card.getCard()[i][j].getColor() == Color.WHITE_BOLD){
                    return null;
                }
            }
        }
        return card.getPlayer();
    }

    public static Player checkLine(Card card, Drum drum){
        int matchNumbers = 0;
        for (int i = 0; i < card.getCard().length; i++) {
            matchNumbers = 0;
            for (int j = 0; j < card.getCard()[i].length; j++) {
                if (card.getCard()[i][j].getColor() == Color.GREEN_BOLD){
                    matchNumbers++;
                }
                if (matchNumbers == 9){
                    return card.getPlayer();
                }
            }
        }
        return null;
    }
}
