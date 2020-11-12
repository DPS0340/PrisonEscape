package optic_fusion1.prisonescape.component.weapon;

import java.util.Objects;
import optic_fusion1.prisonescape.component.entity.Entity;
import optic_fusion1.prisonescape.component.item.PEItem;

public abstract class Weapon extends PEItem {

  private int damage;

  /*
    Class that is a template for Weapons in the game. Weapon objects should be contained in Charachter Objects and be
    able to do damage to other charachter objects.
   */
  public Weapon(String displayName, int damage) {
    super(displayName);
    this.damage = damage;
  }

  //Getter Functions/Accessor Methods.
  public int getDamage() {
    return damage;
  }

  //Setter functions/Mutator Methods.
  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void damage(Entity victim) {
    //Method that does damage to a Character Object.
    victim.setHealth(victim.getHealth() - damage);
  }

  @Override
  public String toString() {
    return "Weapon: " + getName();
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Weapon weapon = (Weapon) other;
    return getName().equals(weapon.getName()) && (damage == weapon.getDamage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), damage);
  }

}
