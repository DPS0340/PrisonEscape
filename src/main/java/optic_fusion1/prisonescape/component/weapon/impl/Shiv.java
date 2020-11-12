package optic_fusion1.prisonescape.component.weapon.impl;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public class Shiv extends Weapon {

  public Shiv() {
    super("Shiv", 25);
  }

  @Override
  public String getDescription() {
    return "You enter a room and find a shiv.\nBe careful not to cut yourself.";
  }

}
