package optic_fusion1.prisonescape.component;

import java.util.HashMap;
import java.util.Objects;
import optic_fusion1.engine.component.Component;
import optic_fusion1.engine.component.item.Item;
import optic_fusion1.prisonescape.component.action.ActionString;
import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.item.PEItem;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;
import optic_fusion1.prisonescape.util.Position;

public class Room extends Component {

  private Enemy enemy; //Enemy Object which may be present in the room.
  private static final HashMap<String, ActionString> ACTION_STRINGS = new HashMap<>(); //HashMap that contains String/ActionString pairs
  private Position position; //Position Object representing the cartesian co-ordinate of the room.
  private String description; //Description of the room needed for output in the game.
  private PEItem item; //Weapon Object that a room might possess.

  public Room(Position position) {
    super("Room");
    this.position = position;
    setDescription();
  }

  //Getter Functions/Accessor Methods.
  public Enemy getEnemy() {
    return enemy;
  }

  public HashMap<String, ActionString> getActionStrings() {
    return ACTION_STRINGS;
  }

  public Position getPosition() {
    return position;
  }

  public String getDescription() {
    return description;
  }

  public Item getItem() {
    return item;
  }

  //Setter Functions/Mutator Methods.
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
    setDescription();
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDescription() {
    if (containsEnemy()) {
      setDescription(enemy.getDescription());
      return;
    }
    if (containsItem()) {
      if (getItem() instanceof Knuckles) {
        setDescription("You have entered an empty room");
        return;
      }
      setDescription(item.getDescription());
    }
  }

  public void setItem(PEItem item) {
    this.item = item;
    setDescription();
  }

  public boolean containsEnemy() {
    return enemy != null;
  }

  public boolean containsItem() {
    return item != null;
  }

  public boolean containsAction(String string) {
    return ACTION_STRINGS.containsKey(string);
  }

  public boolean containsAction(ActionString actionString) {
    return ACTION_STRINGS.containsValue(actionString);
  }

  public void addAction(String string, ActionString actionString) {
    ACTION_STRINGS.putIfAbsent(string, actionString);
  }

  public void addAction(ActionString actionString) {
    ACTION_STRINGS.putIfAbsent(actionString.getName(), actionString);
  }

  public void removeEnemy() {
    if (containsEnemy()) {
      enemy = null;
    }
  }

  public void removeItem() {
    if (containsItem()) {
      item = null;
    }
  }

  public void removeAction(String string) {
    if (ACTION_STRINGS.containsKey(string)) {
      ACTION_STRINGS.remove(string);
    }
  }

  public String roomDisplay() {
    String display = description + "\n";
    display = display + "\nAVAILABLE ACTION:\n";
    for (String string : ACTION_STRINGS.keySet()) {
      display = display + ACTION_STRINGS.get(string).actionBar() + "\n";
    }
    return display;
  }

  @Override
  public String toString() {
    return "Room: " + this.position.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Room room = (Room) other;
    return enemy.equals(room.getEnemy()) && ACTION_STRINGS.equals(room.getActionStrings())
            && position.equals(room.getPosition()) && description.equals(room.getDescription())
            && item.equals(room.getItem());
  }

  @Override
  public int hashCode() {
    return Objects.hash(enemy, ACTION_STRINGS, position, description, item);
  }

}
