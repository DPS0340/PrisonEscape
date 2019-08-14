public class HandGun extends Weapon {
    //Class that represents a Weapon Object in the game.
    public HandGun(){
        super("HandGun",50);
    }
    @Override
    public String getDescription(){
        return "You enter a room and find a hand-gun.\nPerhaps a useful tool in your journey to freedom?";
    }
}
