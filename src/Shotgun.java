public class Shotgun extends Weapon {
    //Class that represents a Weapon Object in the game.
    public Shotgun(){
        super("Shotgun",80);
    }
    @Override
    public String getDescription(){
        return "You enter a room and find a shotgun.\nGod help anyone that stands between you and freedom.";
    }
}
