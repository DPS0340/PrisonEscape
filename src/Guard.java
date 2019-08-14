public class Guard extends Enemy {
    //Class representing an enemy in the game.
    public Guard(){
        super("Guard",100,new Baton(),8);
    }
    @Override
    public String getDescription(){
        return "You encounter a guard.\nGUARD:Don't make me smack you boy!";
    }
}
