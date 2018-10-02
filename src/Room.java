//Class needed to make room objects which will occupy the world objects
import java.util.ArrayList;
public class Room {
    private ArrayList<Charachter> charachter_list;
    private ArrayList<String> action_list;
    private Position pos;
    private String des;
    private String actionbar;
    private Weapon item;
    public Room(Position pos){
        //Constructor
        this.charachter_list=new ArrayList<Charachter>();
        this.action_list=new ArrayList<String>();
        this.pos=pos;
        this.des="";
        this.actionbar="AVAILABLE ACTION:"+"\n";
    }
    public void addAction(String s){
        //Method which adds "Actions" to room objects.
        String string=s.toLowerCase();
        switch (string){
            case "up":
                action_list.add(string);
                actionbar=actionbar+"TYPE UP TO MOVE UP"+"\n";
                break;
            case "down":
                action_list.add(string);
                actionbar=actionbar+"TYPE DOWN TO MOVE DOWN"+"\n";
                break;
            case "left":
                action_list.add(string);
                actionbar=actionbar+"TYPE LEFT TO MOVE LEFT"+"\n";
                break;
            case "right":
                action_list.add(string);
                actionbar=actionbar+"TYPE RIGHT TO MOVE RIGHT"+"\n";
                break;
            case "attack":
                action_list.add(string);
                actionbar=actionbar+"TYPE ATTACK TO ATTACK"+"\n";
                break;
            case "pick":
                action_list.add(string);
                actionbar=actionbar+"TYPE PICK TO PICK UP WEAPON"+"\n";
                break;
            case "heal":
                action_list.add(string);
                actionbar=actionbar+"TYPE HEAL TO USE MEDKIT"+"\n";
                break;
            default:
                System.out.println("Unrecognized action");
        }
    }
    public void removeAction(String s){
        //Method which removes "Actions" from room objects.
        String string=s.toLowerCase();
        switch (string){
            case "up":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE UP TO MOVE UP"+"\n","");
                break;
            case "down":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE DOWN TO MOVE DOWN"+"\n","");
                break;
            case "left":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE LEFT TO MOVE LEFT"+"\n","");
                break;
            case "right":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE RIGHT TO MOVE RIGHT"+"\n","");
                break;
            case "attack":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE ATTACK TO ATTACK"+"\n","");
                break;
            case "pick":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE PICK TO PICK UP WEAPON"+"\n","");
                break;
            case "heal":
                action_list.remove(string);
                actionbar=actionbar.replace("TYPE HEAL TO USE MEDKIT"+"\n","");
            default:
                System.out.println("Unrecognized action");
        }

    }
    public boolean validAction(String s){
        //Method which returns true if an "Action" is in the action_list arraylist,method returns false otherwise.
        for(String a:action_list){
            if(s.equals(a)){return true;}
        }
        return false;
    }
    public boolean emptyRoom(){
        //Method which returns true if there is no character in the room object,false otherwise.
        if(charachter_list.isEmpty()){return true;}
        return false;
    }
    public void removeCharachter(){
        //Method which removes a character from the room object.Does nothing if no character is present in the room object.
     if(!charachter_list.isEmpty()){
         charachter_list.remove(0);
         removeAction("attack");
     }
     else{
         System.out.println("No one is in the room");
     }
    }
    public void addCharachter(Charachter c){
        //Method which adds a Character object to the room object.
        if(charachter_list.isEmpty()){
            charachter_list.add(c);
        }
        else{
            System.out.println("Room Occupied");
        }
    }
    public Charachter getCharachter(){
        //Method which returns the character present in the room object,use with caution as Error will be raised if no character is present in the room object.
        return charachter_list.get(0);
    }
    public Position getPos(){
        //Returns the position object associated with the room object i.e the position which the room object occupies.
        return this.pos;
    }
    public void setPos(Position pos){
        //Method which sets the position of the room object.
        this.pos=pos;
    }
    public String getDes(){
        //Returns the description of the room.Descriptions are key part of the game as it makes each room unique and helps us create the narrative which fuels the game.
        return this.des;}
    public String getActionbar(){
        //Returns the action-bar of the room.The Action Bar is a key part of the UI as it shows the actions available to the user and the actions in the action_list of the room object.
        return this.actionbar;}
    public void setDes(String s){
        //Sets the description of the room object.
        this.des=s;
    }
    public String getSetup(){
        //Returns the "setup" of the room which is a string object containing the description and action-bar of the room,separated by two newlines.
        String result=this.des+"\n"+"\n"+this.actionbar;
        return result;
    }
    public void setItem(Weapon w){
        //Sets the item(weapon) in the room object.
        this.item=w;
    }
    public Weapon getItem(){
        //Returns the item(weapon) object in the room.Use with caution as it raises error if item object of the room has not been set.
        return this.item;
    }
}
