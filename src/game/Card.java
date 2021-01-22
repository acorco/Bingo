package game;

import util.Logger;

import java.util.ArrayList;

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
        ArrayList<Integer> numbers = _getRandomNonRepeatingIntegers(27, 1, 90);
        Cell[][] card = new Cell[h][w];
        int k = 0;
        for (int i = 0; i < card.length; i++, k++) {
            for (int j = 0; j < card[i].length; j++, k++) {
                Cell cell = new Cell();
                cell.setNumber(numbers.get(k));
                card[i][j] = cell;
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
        ArrayList<Integer> _numbers = new ArrayList<Integer>();

        while (_numbers.size() < size) {
            int random = Logger.getRandomInt(1, 90);

            if (!_numbers.contains(random)) {
                _numbers.add(random);
            }
        }
        return _numbers;
    }

}
