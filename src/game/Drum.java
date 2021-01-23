package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import util.Logger;
import util.Color;

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
        int num = Logger.getRandomIntList(_numbers);

        _numbers.remove(Integer.valueOf(num));
        _usedNumbers.add(num);

        return num;
    }

    public ArrayList<Integer> getUsedNumbers(){
        return this._usedNumbers;
    }

    public void getNumbersYouHave(Card card){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < card.getCard().length; i++) {
            for (int j = 0; j < card.getCard()[i].length; j++) {
                if (this._usedNumbers.contains(card.getCard()[i][j].getNumber())){
                    numbers.add(card.getCard()[i][j].getNumber());
                    this._usedNumbers.remove(Integer.valueOf(card.getCard()[i][j].getNumber()));
                }
            }
        }
        Collections.sort(this._usedNumbers);
        Collections.sort(numbers);

        Logger.println(Color.BLUE_BOLD, "ELS NÚMEROS QUE HAN SORTIT QUE TENS:");
        System.out.println(Color.GREEN_BOLD);
        System.out.println(numbers);
        System.out.println(Color.RESET);
        System.out.println();
        Logger.println(Color.BLUE_BOLD, "ELS NÚMEROS QUE HAN SORTIT QUE NO TENS:");
        System.out.println(this._usedNumbers);
        System.out.println();
        Logger.println(Color.BLUE_BOLD, "ELS NÚMEROS QUE NO HAN SORTIT:");
        System.out.println(this._numbers);
        System.out.println();
    }

}


