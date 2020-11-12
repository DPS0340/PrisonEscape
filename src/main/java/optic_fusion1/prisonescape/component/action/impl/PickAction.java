package optic_fusion1.prisonescape.component.action.impl;

import optic_fusion1.prisonescape.component.Room;
import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.action.Action;
import optic_fusion1.prisonescape.component.action.Handler;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.component.weapon.Weapon;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;
import optic_fusion1.prisonescape.util.Position;

public class PickAction extends Action {
  //Class that provides an action, allowing the user to pick up a weapon in a room, if a weapon is present.

  public PickAction(Handler handler) {
    super("PickAction", handler);
  }

  @Override
  public void action() {
    World world = this.getHandler().getWorld();
    Player player = world.getPlayer();
    Position position = player.getPosition();
    Room room = world.getRoom(position);
    if (room.getItem() instanceof Weapon) {
      Weapon primary = (Weapon) room.getItem();
      Weapon secondary = player.getWeapon();
      player.setWeapon(primary);
      if (!(secondary instanceof Knuckles)) {
        room.setItem(secondary);
      } else {
        room.removeItem();
        room.removeAction("pick");
      }
      room.setDescription("You picked up " + primary.getName());
      this.getHandler().genericOutput();
      room.setDescription();
    } else {
      System.out.println("No Weapon in the room.");
    }
  }

}
