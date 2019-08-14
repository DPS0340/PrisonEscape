import java.util.Objects;
import java.util.Random;

public class  Charachter{
    /* Class that is meant to function as a template for all the charachters in the game.
       Provides general properties that every charachter should have.*/

    private final String name; //Name of the charachter.
    private int health; //Health of the charachter.
    private Weapon weapon; //Weapon possessed by the charachter.
    private int accuracy; //Proficiency of the charachter in dealing damage.

    public Charachter(String name, Integer health, Weapon weapon, Integer accuracy){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.accuracy = accuracy;
    }

    //Getter Functions/Accessor Methods.
    public String getName(){
        return this.name;
    }
    public Integer getHealth(){
        return this.health;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public int getAccuracy(){
        return this.accuracy;
    }

    //Setter Functions/Mutator Methods.
    public void setHealth(Integer health){
        this.health = health;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setAccuracy(int accuracy){
        this.accuracy = accuracy;
    }

    @Override
    public String toString(){
        return "Charachter: " + this.getName();
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
        Charachter charachter = (Charachter) other;
        return this.name.equals(charachter.getName()) && (this.health == charachter.getHealth()) &&
               this.weapon.equals(charachter.getWeapon()) && (this.accuracy == charachter.getAccuracy());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.health, this.weapon, this.accuracy);
    }

}
