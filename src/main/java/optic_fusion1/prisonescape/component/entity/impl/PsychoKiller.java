package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.Katana;

public class PsychoKiller extends Enemy {

  public PsychoKiller() {
    super("PsychoKiller", 220, new Katana(), 4);
  }

  @Override
  public String getDescription() {
    return "You encounter a psycho killer.\nPSYCHO KILLER:HAHAHAHAHAHAH.";
  }

}
