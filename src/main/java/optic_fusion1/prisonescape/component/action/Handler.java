package optic_fusion1.prisonescape.component.action;

import optic_fusion1.prisonescape.component.action.impl.PickAction;
import optic_fusion1.prisonescape.component.action.impl.UpAction;
import optic_fusion1.prisonescape.component.action.impl.RightAction;
import optic_fusion1.prisonescape.component.action.impl.HealAction;
import optic_fusion1.prisonescape.component.action.impl.LeftAction;
import optic_fusion1.prisonescape.component.action.impl.AttackAction;
import optic_fusion1.prisonescape.component.action.impl.DownAction;
import java.util.HashMap;
import optic_fusion1.prisonescape.component.Room;
import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.util.Position;

//Class that handles the inputs provided by the user.
public class Handler {

  private static final HashMap<String, Action> ACTIONS = new HashMap<>(); //HashMap that contains String/Action pairings representing allowable inputs and appropriate Actions necessary to handle them.
  private World world; //World object that the user/player changes through the Handler Object.

  public Handler(World world) {
    this.world = world;
    init();
  }

  //Getter Functions/Accessor Methods.
  public World getWorld() {
    return world;
  }

  public HashMap<String, Action> getActions() {
    return ACTIONS;
  }

  //Setter Functions/Mutator Methods.
  public void setWorld(World world) {
    this.world = world;
  }

  //Puts default String/ActionString pairings into the ACTIONS HashMap.
  private void init() {
    ACTIONS.put("up", new UpAction(this));
    ACTIONS.put("down", new DownAction(this));
    ACTIONS.put("left", new LeftAction(this));
    ACTIONS.put("right", new RightAction(this));
    ACTIONS.put("attack", new AttackAction(this));
    ACTIONS.put("pick", new PickAction(this));
    ACTIONS.put("heal", new HealAction(this));
  }

  //Returns true if ACTIONS contains the provided action otherwise false
  public boolean containsAction(String string) {
    return ACTIONS.containsKey(string);
  }

  public void addAction(String string, Action action) {
    ACTIONS.putIfAbsent(string, action);
  }

  public void handleInput(String string) {
    String input = string.toLowerCase();
    Action action = ACTIONS.get(input);
    if (action == null) {
      System.out.println("INVALID ACTION");
      return;
    }
    Room room = world.getRoom(world.getPlayer().getPosition());
    if(room == null){
      return;
    }
    if (!room.containsAction(input)) {
      System.out.println("INVALID ACTION");
      return;
    }
    action.action();
  }

  public void genericOutput() {
    String startLine = "*************************************************************************************************";
    String endLine = "-------------------------------------------------------------------------------------------------";
    String display = startLine + "\n" + healthBar() + "\n";
    Room room = world.getRoom(world.getPlayer().getPosition());
    if(room == null){
      return;
    }
    if (room.containsEnemy()) {
      display = display + enemyBar() + "\n";
    }
    display = display + "\n" + world.getRoom(world.getPlayer().getPosition()).roomDisplay() + endLine;
    System.out.println(display);
  }

  private String healthBar() {
    Player player = world.getPlayer();
    return "PLAYER HEALTH:" + Integer.toString(player.getHealth()) + "    " + "PLAYER WEAPON:" + player.getWeapon().toString()
            + "    " + "SCORE:" + Integer.toString(player.getScore());
  }

  private String enemyBar() {
    //Helper method for the genericOutput method that provides information to the user about an Enemy Object.
    Player player = world.getPlayer();
    Position position = player.getPosition();
    Room room = world.getRoom(position);
    Enemy enemy = room.getEnemy();
    return "ENEMY HEALTH:" + Integer.toString(enemy.getHealth()) + "      " + "ENEMY WEAPON:" + enemy.getWeapon().toString();
  }

  @Override
  public String toString() {
    return "Handler";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Handler handler = (Handler) other;
    return ACTIONS.equals(handler.getActions());
  }

  @Override
  public int hashCode() {
    return ACTIONS.hashCode() * 31;
  }

}
