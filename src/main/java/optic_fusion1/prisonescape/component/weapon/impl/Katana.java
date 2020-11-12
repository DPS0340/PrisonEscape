package optic_fusion1.prisonescape.component.weapon.impl;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public class Katana extends Weapon {

  public Katana() {
    super("Katana", 100);
  }

  @Override
  public String getDescription() {
    return "You enter a room and find a Katana.\nHow did this get here?";
  }
}
