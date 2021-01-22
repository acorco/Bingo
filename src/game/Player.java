package game;

public class Player {
    private String _name;

    public Player(String name){
        this._name = name;
    }
    public void setName(String name){
        this._name = name;
    }

    public String getName(){
        return this._name;
    }
}
