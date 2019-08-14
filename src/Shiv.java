public class Shiv extends Weapon {
    //Class that represents a Weapon Object in the game.
    public Shiv(){
        super("Shiv",25);
    }
    @Override
    public String getDescription(){
        return "You enter a room and find a shiv.\nBe careful not to cut yourself.";
    }
}
