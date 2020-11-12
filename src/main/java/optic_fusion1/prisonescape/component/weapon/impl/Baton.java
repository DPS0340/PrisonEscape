package optic_fusion1.prisonescape.component.weapon.impl;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public class Baton extends Weapon {

  public Baton() {
    super("Baton", 15);
  }

  @Override
  public String getDescription() {
    return "You enter a room and find a Baton.\nTime to give these guards a taste of their own medicine?";
  }
}
