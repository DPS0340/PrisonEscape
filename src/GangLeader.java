public class GangLeader extends Enemy {
    //Class representing an enemy in the game.
    public GangLeader(){
        super("GangLeader",100,new HandGun(),6);
    }
    @Override
    public String getDescription(){
        return "You encounter a gang leader.\nGANGLEADER:What you looking at?";
    }
}
