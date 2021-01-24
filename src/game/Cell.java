package game;

import util.Color;
import util.Logger;
import java.util.ArrayList;

public class Cell {
    private int _number;
    private Color _color;

    public Cell(){
        this._color = Color.WHITE_BOLD;
    }
    public void setNumber(int number){
        this._number = number;
    }

    public int getNumber(){
        return this._number;
    }

    public void setColor(Color color) { this._color = color;}

    public Color getColor(){  return this._color;}

    public void compareNumberCell(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == this._number){
                setColor(Color.GREEN_BOLD);
            }
        }
    }

}
