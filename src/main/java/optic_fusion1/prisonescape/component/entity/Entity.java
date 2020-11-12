package optic_fusion1.prisonescape.component.entity;

import java.util.Objects;
import optic_fusion1.engine.component.Component;
import optic_fusion1.prisonescape.component.weapon.Weapon;

/*
    Class that is meant to function as a template for all the characters in the game.
    Provides general properties that every character should have.
 */
public abstract class Entity extends Component {

  private int health; //Health of the character
  private Weapon weapon; //Weapon possessed by the character.
  private int accuracy; //Proficiency of the character in dealing damage.

  public Entity(String name, int health, Weapon weapon, int accuracy) {
    super(name);
    this.health = health;
    this.weapon = weapon;
    this.accuracy = accuracy;
  }

  //Getter Functions/Accessor Methods.
  public int getHealth() {
    return health;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public int getAccuracy() {
    return accuracy;
  }

  //Setter Functions/Mutator Methods.
  public void setHealth(int health) {
    this.health = health;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void setAccuracy(int accuracy) {
    this.accuracy = accuracy;
  }

  @Override
  public String toString() {
    return "Charachter: " + getName();
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
    Entity charachter = (Entity) other;
    return getName().equals(charachter.getName()) && (health == charachter.getHealth())
            && weapon.equals(charachter.getWeapon()) && (accuracy == charachter.getAccuracy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), health, weapon, accuracy);
  }

}
