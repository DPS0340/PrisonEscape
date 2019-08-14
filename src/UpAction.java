public class UpAction extends Action {
    //Class that moves the player/user up in the world/increments the Player's y value by 1.
    public UpAction(Handler handler){
        super("UpAction", handler);
    }
    @Override
    public void action(){
        World world = this.getHandler().getWorld();
        Player player = world.getPlayer();
        Position position = player.getPosition();
        Position newPosition = new Position(position.getX(), position.getY()+1);
        if(world.isValid(newPosition)) {
            player.setPosition(newPosition);
            this.getHandler().genericOutput();
        }
        else{
            System.out.println("Out of bounds");
        }
    }
}
