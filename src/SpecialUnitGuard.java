public class SpecialUnitGuard extends Enemy {
    //Class that represents an enemy in the game.
    public SpecialUnitGuard(){
        super("SpecialUnitGuard",150,new Shotgun(),8);
    }
    @Override
    public String getDescription(){
        return "You encounter a special unit guard\nSPECIAL UNIT GUARD:Back Off!";
    }
}
