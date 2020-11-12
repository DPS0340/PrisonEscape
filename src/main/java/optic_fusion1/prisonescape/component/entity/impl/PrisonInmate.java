package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;

public class PrisonInmate extends Enemy {

  public PrisonInmate() {
    super("PrisonInmate", 50, new Knuckles(), 5);
  }

  @Override
  public String getDescription() {
    return "You encounter a Prison Inmate.\nPRISON INMATE:Got any cigs?";
  }

}
