package optic_fusion1.prisonescape.component.entity;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public abstract class Enemy extends Entity {

  public Enemy(String name, int health, Weapon weapon, int accuracy) {
    super(name, health, weapon, accuracy);
  }

  public abstract String getDescription(); //Description that is displayed when an enemy is encountered.

  public int scoreValue() {
    //Algorithm that returns the score the player will get after killing an enemy.
    //Algorithm is based on the weapon, accuracy, and health of the enemy.
    return (getWeapon().getDamage() * 2) + (getAccuracy() * 10) + (getHealth());
  }

}
