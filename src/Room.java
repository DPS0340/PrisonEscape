import java.util.HashMap;
import java.util.Objects;

public class Room {
    /* Class that represents rooms in the game, Room objects are to be stored and used by world object.
       Room objects also might contain Position, ActionString, Enemy, and/or Item objects. */

    private Enemy enemy; //Enemy Object which may be present in the room.
    private final HashMap<String, ActionString> actionStrings = new HashMap<>(); //HashMap that contains String/ActionString pairs
    private final Position position; //Position Object representing the cartesian co-ordinate of the room.
    private String description; //Description of the room needed for output in the game.
    private Item item; //Weapon Object that a room might possess.

    public Room(Position position){
        this.position = position;
        this.setDescription();
    }
    //Getter Functions/ Accessor Methods.
    public Enemy getEnemy(){
        //Use with containsEnemy method to avoid NullPointerException.
        return this.enemy;
    }
    public HashMap<String, ActionString> getActionStrings(){
        return this.actionStrings;
    }
    public Position getPosition(){
        return this.position;
    }
    public String getDescription(){
        return this.description;
    }
    public Item getItem(){
        //Use with containsItem method to avoid NullPointerException.
        return this.item;
    }

    //Setter Functions/ Mutator Methods.
    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
        this.setDescription();
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDescription(){
        if(this.containsEnemy()){
            this.setDescription(this.enemy.getDescription());
        }
        else{
            if(this.containsItem()){
                if(!(this.getItem() instanceof Knuckels)) {
                    this.setDescription(this.item.getDescription());
                }
            }
            else{
                this.setDescription("You have entered an empty room");
            }
        }
    }
    public void setItem(Item item){
        this.item = item;
        this.setDescription();
    }

    public boolean containsEnemy(){
        //Method that returns true, if the room contains an Enemy Object, false otherwise.
        if(this.enemy == null){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean containsItem(){
        //Method that returns true, if the room contains an Item Object, false otherwise.
        if(this.item == null){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean containsAction(String string){
        //Method that returns true, if an entry in actionStrings map contains a key matching the argument provided.
        //Method returns false otherwise.
        if(actionStrings.containsKey(string)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean containsAction(ActionString actionString){
        //Method that returns true, if an entry in the actionStrings map contains a value matching the argument provided.
        //Method returns false otherwise.
        if(actionStrings.containsValue(actionString)){
            return true;
        }
        else{
            return false;
        }
    }

    public void addAction(String string, ActionString actionString){
        //Method which puts a String/ActionString pairing into the actionStrings HashMap.
        this.actionStrings.put(string,actionString);

    }
    public void addAction(ActionString actionString){
        //Method which puts a String/ActionString pairing into the actionStrings HashMap.
        this.actionStrings.put(actionString.getIdentity(), actionString);
    }

    public void removeEnemy(){
        //Method that removes the Enemy Object contained in the room, by setting the enemy variable to null.
        //Prints Error message if Room does not contain Enemy Object.
        if(this.containsEnemy()){
            this.enemy = null;
        }
        else{
            System.out.println("Room has no Enemy Object.");
        }
    }
    public void removeItem(){
        //Method that removes the Item Object contained in the room, by setting the item variable to null.
        //Prints Error message if the Room does not contain Item Object.
        if(this.containsItem()){
            this.item = null;
        }
        else{
            System.out.println("Room has no Item Object.");
        }
    }
    public void removeAction(String string){
        //Method which removes a String/ActionString pairing from the Room object, whose key matches the String argument provided.
        //Prints Error message if no such String/ActionString pairing is present in the actionStrings HashMap.
        if(this.actionStrings.containsKey(string)) {
            this.actionStrings.remove(string);
        }
        else{
            System.out.println("No String/ActionString Pairing found.");
        }
    }
    public String roomDisplay(){
        //Method that returns a String that is necessary for the output of the game.
        //String is composed of the description of the room and the available actions in the room.
        String display = this.description + "\n";
        display = display + "\n" + "AVAILABLE ACTION:"+"\n";
        for(String string:actionStrings.keySet()){
            display = display + this.actionStrings.get(string).actionBar() + "\n";
        }
        return display;
    }

    @Override
    public String toString(){
        return "Room: " + this.position.toString();
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
        Room room = (Room) other;
        return this.enemy.equals(room.getEnemy()) && this.actionStrings.equals(room.getActionStrings()) &&
               this.position.equals(room.getPosition()) && this.description.equals(room.getDescription()) &&
               this.item.equals(room.getItem());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.enemy, this.actionStrings, this.position, this.description, this.item);
    }
}
