public class RightAction extends Action {
    //Class that moves the player/user to the right in the world/increments the x value of the Player's position by 1.
    public RightAction(Handler handler){
        super("RightAction", handler);
    }
    @Override
    public void action(){
        World world = this.getHandler().getWorld();
        Player player = world.getPlayer();
        Position position = player.getPosition();
        Position newPosition = new Position(position.getX()+1, position.getY());
        if(world.isValid(newPosition)) {
            player.setPosition(newPosition);
            this.getHandler().genericOutput();
        }
        else{
            System.out.println("Out of bounds");
        }
    }
}
