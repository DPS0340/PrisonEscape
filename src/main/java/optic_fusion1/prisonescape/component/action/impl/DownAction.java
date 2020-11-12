package optic_fusion1.prisonescape.component.action.impl;

import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.action.Action;
import optic_fusion1.prisonescape.component.action.Handler;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.util.Position;

public class DownAction extends Action {
  //Class that provides an action that moves the player/user down in the world/reduces the y value of the Player's position by 1.

  public DownAction(Handler handler) {
    super("DownAction", handler);
  }

  @Override
  public void action() {
    World world = this.getHandler().getWorld();
    Player player = world.getPlayer();
    Position position = player.getPosition();
    Position newPosition = new Position(position.getX(), position.getY() - 1);
    if (world.isValid(newPosition)) {
      player.setPosition(newPosition);
      this.getHandler().genericOutput();
    } else {
      System.out.println("Out of bounds");
    }
  }
}
