public class PickAction extends Action{
    //Class that provides an action, allowing the user to pick up a weapon in a room, if a weapon is present.
    public PickAction(Handler handler){
        super("PickAction", handler);
    }
    @Override
    public void action(){
        World world = this.getHandler().getWorld();
        Player player = world.getPlayer();
        Position position = player.getPosition();
        Room room = world.getRoom(position);
        if(room.getItem() instanceof Weapon) {
            Weapon primary = (Weapon) room.getItem();
            Weapon secondary = player.getWeapon();
            player.setWeapon(primary);
            if (!(secondary instanceof Knuckels)) {
                room.setItem(secondary);
            }
            else {
                room.removeItem();
                room.removeAction("pick");
            }
            room.setDescription("You picked up " + primary.getName());
            this.getHandler().genericOutput();
            room.setDescription();
        }
        else{
            System.out.println("No Weapon in the room.");
        }
    }

}
