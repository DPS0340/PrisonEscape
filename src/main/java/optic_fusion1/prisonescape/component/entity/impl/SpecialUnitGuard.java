package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.Shotgun;

public class SpecialUnitGuard extends Enemy {

  public SpecialUnitGuard() {
    super("SpecialUnitGuard", 150, new Shotgun(), 8);
  }

  @Override
  public String getDescription() {
    return "You encounter a special unit guard\nSPECIAL UNIT GUARD:Back Off!";
  }
  
}
