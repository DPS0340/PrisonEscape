package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.HandGun;

public class GangLeader extends Enemy {

  public GangLeader() {
    super("GangLeader", 100, new HandGun(), 6);
  }

  @Override
  public String getDescription() {
    return "You encounter a gang leader.\nGANGLEADER:What you looking at?";
  }

}
