package optic_fusion1.prisonescape.component.weapon.impl;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public class Shotgun extends Weapon {

  public Shotgun() {
    super("Shotgun", 80);
  }

  @Override
  public String getDescription() {
    return "You enter a room and find a shotgun.\nGod help anyone that stands between you and freedom.";
  }

}
