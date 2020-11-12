package optic_fusion1.prisonescape.component;

import java.util.HashMap;
import java.util.Objects;
import optic_fusion1.engine.component.Component;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.util.Position;

//Represents the Worlds/Levels of the game. World Objects should contain Room objects and a Player Object.
public class World extends Component {

  private static final HashMap<Position, Room> ROOMS = new HashMap<>(); //HashMap that keeps track of the rooms in the world.
  private Position escape; //Position that represents the room where the player can escape the prison/win the game.
  private final Player player; //The Player Object of the world.
  private int xCapacity; //The largest x value that a Position in the world can have.
  private int yCapacity; //The largest y value that a Position in the world can have.

  public World(String name, Player player) {
    this(name, player, 20, 20);
  }

  public World(String name, Player player, int x, int y) {
    super(name);
    xCapacity = x;
    yCapacity = y;
    setEscape(new Position(x, y));
    this.player = player;
  }

  //Getter Functions/Accessor Methods.
  public HashMap<Position, Room> getRooms() {
    return ROOMS;
  }

  public Room getRoom(Position position) {
    return ROOMS.get(position);
  }

  public Position getEscape() {
    return escape;
  }

  public Player getPlayer() {
    return player;
  }

  public int getXCapacity() {
    return xCapacity;
  }

  public int getYCapacity() {
    return yCapacity;
  }

  //Setter Functions/Mutator Methods.
  public void setEscape(Position escape) {
    this.escape = escape;
  }

  public void setXCapacity(int xCapacity) {
    this.xCapacity = xCapacity;
  }

  public void setYCapacity(int yCapacity) {
    this.yCapacity = yCapacity;
  }

  //Method which takes a room object as an input.
  //Returns true if the position of the room is within the limits the constructor defined by the xCapacity and yCapacity,false otherwise.
  public boolean isValid(Position pos) {
    int x = pos.getX();
    int y = pos.getY();
    System.out.println("X: " + x + " CAP: " + xCapacity);
    System.out.println("Y: " + y + " CAP: " + yCapacity);
    if (0 > x || x > xCapacity) {
      return false;
    }
    if (0 > y || y > yCapacity) {
      return false;
    }
    if(!containsRoom(pos)){
      return false;
    }
    return true;
  }

  //Method that returns true if an entry in the rooms HashMap has the position key provided in the argument, false otherwise.
  public boolean containsRoom(Position position) {
    return ROOMS.containsKey(position);
  }

  //Method that returns true if an entry in the rooms HashMap has the room value provided in the argument, false otherwise.
  public boolean containsRoom(Room room) {
    return ROOMS.containsValue(room);
  }

  public void addRoom(Room room) {
    ROOMS.putIfAbsent(room.getPosition(), room);
  }

  //Method that removes an entry in the rooms HashMap with the key provided in the argument.
  //Use with the containsRoom method.
  public void deleteRoom(Position position) {
    ROOMS.remove(position);
  }

  //Returns true if the Position Object of the player is not equal to the Position object represented by the escape variable,false otherwise.
  public boolean caged() {
    return !player.getPosition().equals(escape);
  }

  @Override
  public String toString() {
    return "World:" + getName();
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
    World world = (World) other;
    return ROOMS.equals(world.getRooms()) && this.escape.equals(world.getEscape())
            && (this.xCapacity == world.getXCapacity()) && (this.yCapacity == world.getYCapacity())
            && getName().equals(world.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.escape, this.player, ROOMS, this.xCapacity, this.yCapacity, getName());
  }
}
