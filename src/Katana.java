public class Katana extends Weapon{
    //Class that represents a Weapon Object in the game.
    public Katana(){
        super("Katana",100);
    }
    @Override
    public String getDescription(){
        return "You enter a room and find a Katana.\nHow did this get here?";
    }
}
