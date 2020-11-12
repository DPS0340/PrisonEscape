package optic_fusion1.prisonescape.component.action.impl;

import java.util.Random;
import optic_fusion1.prisonescape.component.Room;
import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.action.Action;
import optic_fusion1.prisonescape.component.action.Handler;
import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.entity.Entity;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;

public class AttackAction extends Action {
  //Class that provides an action that allows the user do damage to an enemy.

  public AttackAction(Handler handler) {
    super("AttackAction", handler);
  }

  @Override
  public void action() {
    World world = this.getHandler().getWorld();
    Player player = world.getPlayer();
    Room room = world.getRoom(player.getPosition());
    Enemy enemy = room.getEnemy();
    boolean playerHit = this.hit(player);
    boolean enemyHit = this.hit(enemy);
    String playerString;
    if (playerHit) {
      player.getWeapon().damage(enemy);
      playerString = "You hit " + enemy.getName() + " dealing " + Integer.valueOf(player.getWeapon().getDamage()) + " damage.";
    } else {
      playerString = "You try to hit " + enemy.getName() + " but fail.";
    }
    if (enemyHit) {
      enemy.getWeapon().damage(player);
      playerString = playerString + enemy.getName() + " hits back dealing " + Integer.valueOf(enemy.getWeapon().getDamage())
              + " damage.";
    } else {
      playerString = playerString + enemy.getName() + " tries to hit back but misses.";
    }
    if (enemy.getHealth() <= 0) {
      room.removeEnemy();
      room.removeAction("attack");
      if (!(enemy.getWeapon() instanceof Knuckles)) {
        room.setItem(enemy.getWeapon());
        room.addAction("pick", new PickActionString());
      }
      playerString = enemy.getName() + " is dead.";
      if (enemyHit) {
        playerString = playerString + "Dealing " + Integer.toString(enemy.getWeapon().getDamage()) + " damage.";
      }
      player.setScore(player.getScore() + enemy.scoreValue());
    }
    if (player.getHealth() <= 0) {
      System.out.println("YOU HAVE DIED.GOOD LUCK ESCAPING NEXT TIME.");
      System.exit(0);
    }
    room.setDescription(playerString);
    this.getHandler().genericOutput();
    room.setDescription();
  }

  private boolean hit(Entity charachter) {
    //Private helper method for the action method in this class.
    //Method returns true if the charachter is successful in hitting, based on the charachter's accuracy
    int accuracy = charachter.getAccuracy();
    Random random = new Random();
    int chance = random.nextInt(10);
    if (chance < accuracy) {
      return true;
    } else {
      return false;
    }
  }
}
