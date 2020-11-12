package optic_fusion1.prisonescape.component.action.impl;

import optic_fusion1.prisonescape.component.Room;
import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.action.Action;
import optic_fusion1.prisonescape.component.action.Handler;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.util.Position;

public class HealAction extends Action {
  //Method that provides an Action that restores the player's health.

  public HealAction(Handler handler) {
    super("HealAction", handler);
  }

  @Override
  public void action() {
    World world = this.getHandler().getWorld();
    Player player = world.getPlayer();
    Position position = player.getPosition();
    Room room = world.getRoom(position);
    player.setHealth(200);
    room.removeAction("heal");
    room.removeItem();
    room.setDescription("You have healed yourself using medkit");
    this.getHandler().genericOutput();
    room.setDescription();
  }
}
