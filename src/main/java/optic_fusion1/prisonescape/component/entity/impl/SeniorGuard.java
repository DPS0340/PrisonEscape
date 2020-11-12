package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.HandGun;

public class SeniorGuard extends Enemy {

  public SeniorGuard() {
    super("SeniorGuard", 100, new HandGun(), 8);
  }

  @Override
  public String getDescription() {
    return "You encounter one of the senior guards at the prison.\nSENIOR GUARD:I've got bigger fish to fry maggot.";
  }

}
