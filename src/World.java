import java.util.HashMap;
import java.util.Objects;

public class World {
    //Class that represents the Worlds/Levels of the game. World Objects should contain Room objects and a Player Object.
    private final String name; //Name of the World object to help identify it.
    private final HashMap<Position,Room> rooms=new HashMap<>(); //HashMap that keeps track of the rooms in the world
    private Position escape; //Position that represents the room where the player can escape the prison/win the game.
    private final Player player; //The Player Object of the world.
    private int xCapacity; //The largest x value that a Position in the world can have.
    private int yCapacity; //The largest y value that a Position in the world can have.

    public World(String name, Player player){
        //Default Constructor creates a world with default values.
        this.name = name;
        this.xCapacity = 20;
        this.yCapacity = 20;
        setEscape(new Position(20,20));
        this.player = player;
    }
    public World(String name, Player player,Integer x,Integer y){
        //Constructor which takes in a player object and two integers.
        //The two integers represent the xCapacity and yCapacity of the world respectively.
        this.xCapacity = x;
        this.yCapacity = y;
        setEscape(new Position(x,y));
        this.name = name;
        this.player = player;
    }
    //Getter Functions/Accessor Methods.
    public HashMap<Position,Room> getRooms(){
        return this.rooms;
    }
    public Room getRoom(Position position){
        return this.rooms.get(position);
    }
    public Position getEscape(){
        return this.escape;
    }
    public Player getPlayer(){
        return this.player;
    }
    public String getName(){
        return this.name;
    }
    public int getXCapacity(){
        return this.xCapacity;
    }
    public int getYCapacity(){
        return this.yCapacity;
    }

    //Setter Functions/Mutator Methods.
    public void setEscape(Position escape){
        this.escape = escape;
    }
    public void setXCapacity(int xCapacity){
        this.xCapacity = xCapacity;
    }
    public void setYCapacity(int yCapacity){
        this.yCapacity = yCapacity;
    }

    public boolean isValid(Position pos){
        //Method which takes a room object as an input.
        //Returns true if the position of the room is within the limits the constructor defined by the xCapacity and yCapacity,false otherwise.
        int x = pos.getX();
        int y = pos.getY();
        if (0 > x || x > this.xCapacity){
            return false;
        }
        if(0 > y || y > this.yCapacity){
            return false;
        }
        return true;
    }

    public boolean containsRoom(Position position){
        //Method that returns true if an entry in the rooms HashMap has the position key provided in the argument, false otherwise.
        if(this.rooms.containsKey(position)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean containsRoom(Room room){
        //Method that returns true if an entry in the rooms HashMap has the room value provided in the argument, false otherwise.
        if(this.rooms.containsValue(room)){
            return true;
        }
        else{
            return false;
        }
    }
    public void addRoom(Room room){
        //Method that adds a Position/Room pairing to the rooms HashMap.
        this.rooms.put(room.getPosition(), room);
    }
    public void deleteRoom(Position position){
        //Method that removes an entry in the rooms HashMap with the key provided in the argument.
        //Use with the containsRoom method.
        this.rooms.remove(position);
    }

    public boolean caged(){
        //Returns true if the Position Object of the player is not equal to the Position object represented by the escape variable,false otherwise.
        if(this.player.getPosition().equals(this.escape)){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString(){
        return "World:" + this.name;
    }
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(this.getClass() != other.getClass()){
            return false;
        }
        World world = (World) other;
        return this.rooms.equals(world.getRooms()) && this.escape.equals(world.getEscape()) &&
                (this.xCapacity == world.getXCapacity()) && (this.yCapacity == world.getYCapacity()) &&
                this.name.equals(world.getName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.escape, this.player, this.rooms, this.xCapacity, this.yCapacity, this.name);
    }
}
