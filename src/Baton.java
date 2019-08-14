public class Baton extends Weapon {
    //Class that represents a Weapon Object in the game.
    public Baton(){
        super("Baton",15);
    }
    @Override
    public String getDescription(){
        return "You enter a room and find a Baton.\nTime to give these guards a taste of their own medicine?";
    }
}
