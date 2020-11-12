package optic_fusion1.prisonescape.component.entity.impl;

import optic_fusion1.prisonescape.component.entity.Enemy;
import optic_fusion1.prisonescape.component.weapon.impl.Shiv;

public class DrugDealer extends Enemy {

  public DrugDealer() {
    super("DrugDealer", 75, new Shiv(), 6);
  }

  @Override
  public String getDescription() {
    return "You encounter a drug dealer.\nDRUGDEALER:Don't mess with me.";
  }

}
