package game;

import java.util.ArrayList;
import util.Logger;

public class Drum {
    private ArrayList<Integer> _numbers;

    public ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min, int max) {
        this._numbers = new ArrayList<Integer>();

        while (_numbers.size() < size) {
            int random = Logger.getRandomInt(1, 90);

            if (!_numbers.contains(random)) {
                _numbers.add(random);
            }
        }
        return _numbers;
    }

}


