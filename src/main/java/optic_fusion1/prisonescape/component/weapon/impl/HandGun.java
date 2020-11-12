package optic_fusion1.prisonescape.component.weapon.impl;

import optic_fusion1.prisonescape.component.weapon.Weapon;

public class HandGun extends Weapon {

  public HandGun() {
    super("HandGun", 50);
  }

  @Override
  public String getDescription() {
    return "You enter a room and find a hand-gun.\nPerhaps a useful tool in your journey to freedom?";
  }
}
