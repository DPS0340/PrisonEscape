import java.util.Objects;

public abstract class Weapon implements Item{
    /* Class that is a template for Weapons in the game. Weapon objects should be contained in Charachter Objects and be
       able to do damage to other charachter objects.*/
    private final String name; //Name of the Weapon Object.
    private int damage; //Damage that the weapon can do to charachters in the game.

    public Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }
    //Getter Functions/Accessor Methods.
    public String getName(){
        return this.name;
    }
    public int getDamage(){
        return this.damage;
    }

    //Setter functions/Mutator Methods.
    public void setDamage(int damage){
        this.damage = damage;
    }

    public void doDamage(Charachter victim){
        //Method that does damage to a charachter Object.
        int health = victim.getHealth();
        health = health - this.damage;
        victim.setHealth(health);
    }
    @Override
    public String toString(){
        return "Weapon: " + this.name;
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
        Weapon weapon = (Weapon) other;
        return this.name.equals(weapon.getName()) && (this.damage == weapon.getDamage());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.damage);
    }

}
