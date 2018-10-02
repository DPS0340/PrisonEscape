//Class used to create World objects.
import java.util.ArrayList;
public class World {
    private ArrayList<Room> rooms_list=new ArrayList<Room>();
    private Position escape;
    private Position pointer;
    private Player player;
    public World(Player player){
        //Default Constructor creates a world with default values.
        create_world(20,20);
        setEscape(new Position(20,20));
        pointer=new Position(0,0);
        this.player=player;
    }
    public World(Player player,Integer x,Integer y){
        //Constructor which takes in a player object and two integers.Rooms are created based upon the x and y integer values.X and Y are used in the traditional cartesian sense where x is representative of the horizontal direction and y is representative of the vertical direction.
        create_world(x,y);
        setEscape(new Position(x,y));
        pointer=new Position(0,0);
        this.player=player;
    }
    public boolean is_valid(Position pos){
        //Method which takes a room object as an input.Returns true if the position of the room is within the limits of the constructor,false otherwise.
        Room last_room=rooms_list.get(rooms_list.size()-1);
        Integer greatest_x=last_room.getPos().getX();
        Integer greatest_y=last_room.getPos().getY();
        if(pos.getX()>=greatest_x){return false;}
        if(pos.getY()>=greatest_y){return false;}
        if(pos.getX()<0){return false;}
        if(pos.getY()<0){return false;}
        return true;
    }
    private void create_world(Integer x,Integer y){
        //Helper method used by the constructor to add room objects to the world object.
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                Position position=new Position(i,j);
                Room room=new Room(position);
                rooms_list.add(room);
            }
        }
    }
    public Position getEscape(){
        //Method which returns the position of the room object which symbolizes the escape point of the world object.
        // It is a Position object which has an x value of 0 and a y value of 0 by default.
        // This can be changed using the setEscape method.
        return this.escape;
    }
    public Position getPointer(){
        //Returns the Position object associated with the "pointer" of the world.
        return this.pointer;
    }
    public void changePointer(Position pos){
        //Method which changes the "pointer" of the world object.
        this.pointer=pos;
    }
    private void setEscapeRoom(Position pos){
        //Helper method for the setEscape method.
        for(Room rooms:rooms_list){
            Position p=rooms.getPos();
            if(p.equals(pos)){

            }
        }

    }
    public void setEscape(Position pos){
        //Method used to set the "escape" of the world object.
        this.escape=pos;
        setEscapeRoom(pos);
    }
    public ArrayList<Room> getRooms(){
        //Method which returns an array-list containing the room objects contained by the world object.
        return rooms_list;
    }
    public Room getRoom(Position position){
        //Returns a specific room object contained within the world object based upon the input which is a Position object.
        //Returns the last room in the world object if the room in question is not found.
        for(Room r:rooms_list){
            if(r.getPos().equals(position)){return r;}
        }
        return rooms_list.get(-1);
    }
    public void setRoom(Room room){
        //Replaces a room object in the world object with the input.
        Position position=room.getPos();
        Integer index=rooms_list.size()-1;
        for(Room r:rooms_list){
            if(r.getPos().equals(position)){index=rooms_list.indexOf(r);}
        }
        rooms_list.add(index,room);
    }
    public Player getPlayer(){
        //Returns the player object contained within the world object.
        return this.player;}
    public boolean caged(){
        //Returns true if the pointer and escape variables both refer to the same Position object,false otherwise.
        if(this.escape.equals(this.pointer)){return false;}
        return true;
    }
}
