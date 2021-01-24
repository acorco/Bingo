package game;

import util.Color;
import util.Logger;
import java.lang.reflect.Array;
import java.util.*;

public class Card {
    private final int _h;
    private final int _w;
    private Cell[][] _card;
    private Player _player;

    public Card(Player player) {
        _h = 3;
        _w = 9;
        _player = player;
        _card = this._createCard(player);

    }

    private Cell[][] _createCard(Player player) {

        ArrayList<Integer> numbers = _getRandomNonRepeatingIntegers(28, 1, 90);
        Cell[][] card = new Cell[_h][_w];
        int x = 0;

        boolean[][] holes = this._getHoles();

        for (int i = 0; i < card[0].length; i++) {
            for (int j = 0; j < card.length; j++, x++) {
                Cell cell = new Cell();
                if (!holes[j][i]) {
                    cell.setNumber(numbers.get(x));
                } else {
                    cell.setNumber(0);
                }

                card[j][i] = cell;
            }
        }
        return card;
    }

    private boolean[][] _getHoles() {
        boolean[][] holes = new boolean[_h][_w];

        for (int i = 0; i < _h; i++) {
            ArrayList<Integer> indexes = new ArrayList<>();
            boolean[] rowHoles = new boolean[_w];

            for (int j = 0; j < 4; j++) {
                Random random = new Random();
                int index = random.nextInt(_w);

                while (indexes.contains(index)) {
                    index = random.nextInt(_w);

                    if (!indexes.contains(index)) {
                        break;
                    }
                }

                indexes.add(index);

                rowHoles[index] = true;
            }

            holes[i] = rowHoles;
        }

        return holes;
    }

    private ArrayList<Integer> _getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int random = Logger.getRandomInt(1, 90);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public void getCardNumbers(Drum drum) {
        int lineBreak = 1;
        for (int i = 0; i < _card.length; i++) {
            for (int j = 0; j < _card[i].length; j++, lineBreak++) {
                if (_card[i][j].getNumber() > 0) {
                    _card[i][j].compareNumberCell(drum.getUsedNumbers());
                    Logger.printIntSpace(_card[i][j].getColor(), _card[i][j].getNumber());
                } else {
                    _card[i][j].setColor(Color.GREEN_BOLD);
                    System.out.print(Color.WHITE_BOLD);
                    System.out.printf("%5c", '@');
                    System.out.print(Color.RESET);
                }
                if (lineBreak == 9) {
                    System.out.println();
                    lineBreak = 0;
                }
            }

        }
    }

    public Cell[][] getCard() {
        return this._card;
    }

    public Player getPlayer() {
        return this._player;
    }
}
