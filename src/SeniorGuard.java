public class SeniorGuard extends Enemy {
    //Class that represents an enemy in the game.
    public SeniorGuard(){
        super("SeniorGuard",100,new HandGun(),8);
    }
    @Override
    public String getDescription(){
        return "You encounter one of the senior guards at the prison.\nSENIOR GUARD:I've got bigger fish to fry maggot.";
    }
}
