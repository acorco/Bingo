package game;

import java.util.ArrayList;
import util.Logger;

public class Drum {
    private ArrayList<Integer> _numbers;
    private ArrayList<Integer> _usedNumbers = new ArrayList<Integer>();

    public Drum(){
        this._numbers = createDrumNumbers();
    }

    private ArrayList<Integer> createDrumNumbers(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 90; i++) {
            numbers.add(i+1);
        }
        return numbers;
    }

    public ArrayList<Integer> getDrum(){
        return this._numbers;
    }

    public int throwNumber(){
        int num = Logger.getRandomInt(_numbers.indexOf(1),_numbers.size());

        _numbers.remove(num);
        _usedNumbers.add(num);

        return num;

    }

    public ArrayList<Integer> getUsedNumbers(){
        return this._usedNumbers;
    }

}


