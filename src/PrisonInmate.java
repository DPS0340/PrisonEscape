public class PrisonInmate extends Enemy {
    //Class representing an enemy in the game.
    public PrisonInmate(){
        super("PrisonInmate",50,new Knuckels(),5);
    }
    @Override
    public String getDescription(){
        return "You encounter a Prison Inmate.\nPRISON INMATE:Got any cigs?";
    }
}
