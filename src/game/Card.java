package game;

import util.Color;
import util.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Card {
    private final int _h;
    private final int _w;
    private Cell[][] _card;
    private Player _player;

    public Card(Player player) {
        _h = 3;
        _w = 9;
        this._player = player;
        _card = this._createCard(_h, _w, player);

    }

    private Cell[][] _createCard(int h, int w, Player player) {
        ArrayList<Integer> numbers = _getRandomNonRepeatingIntegers(28, 1, 90);
        Cell[][] card = new Cell[h][w];
        int k = 0;
        int x = 0;
        /*for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++, k++, x++) {
                Cell cell = new Cell();
                if (x % 2 == 0) {
                    cell.setNumber(numbers.get(k));
                }else{
                    cell.setNumber(0);
                }

                card[i][j] = cell;
            }
        }*/

        for (int i = 0; i < card[0].length; i++) {
            for (int j = 0; j < card.length; j++, x++,k++) {
                Cell cell = new Cell();
                if (x % 2 == 0) {
                    cell.setNumber(numbers.get(k));
                }else{
                    cell.setNumber(0);
                }

                card[j][i] = cell;
            }
        }
        return card;
    }

    public void draw(){
        System.out.println();
        for (int i = 0; i < _card.length; i++) {
            for (int j = 0; j < _card[i].length; j++) {

            }
        }
    }

    private ArrayList<Integer> _getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < size) {
            int random = Logger.getRandomInt(1, 90);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public void getCardNumbers(Drum drum){
        int lineBreak = 1;
        for (int i = 0; i < _card.length; i++) {
            for (int j = 0; j < _card[i].length; j++, lineBreak++) {
                if (_card[i][j].getNumber() > 0) {
                    _card[i][j].compareNumberCell(drum.getUsedNumbers());
                    Logger.printIntSpace(_card[i][j].getColor(), _card[i][j].getNumber());
                }else{
                    _card[i][j].setColor(Color.GREEN_BOLD);
                    System.out.print(Color.BLACK_BOLD);
                    System.out.printf("%5c", '@');
                    System.out.print(Color.RESET);
                }
                if (lineBreak == 9){
                    System.out.println();
                    lineBreak = 0;
                }
            }

        }
    }

    public Cell[][] getCard(){
        return this._card;
    }

    public Player getPlayer(){
        return this._player;
    }
}
