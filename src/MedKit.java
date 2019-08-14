import java.util.Objects;

public class MedKit implements Item{
    //A class that is meant to represent an Item object in the game that restores the players health in the game.
    private final String name;
    private String description;
    public MedKit(){
        this.name = "MedKit";
        this.description = "You enter a room and find a med-kit.\nYou would be foolish not to use it!";
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString(){
        return "Item: MedKit";
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
        MedKit medKit = (MedKit) other;
        return this.name.equals(medKit.getName()) && this.description.equals(medKit.getDescription());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.description);
    }

}
