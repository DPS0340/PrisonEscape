package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.Baton;

public class Guard extends Enemy {

  public Guard() {
    super("Guard", 100, new Baton(), 8);
  }

  @Override
  public String getDescription() {
    return "You encounter a guard.\nGUARD:Don't make me smack you boy!";
  }

}
