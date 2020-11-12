package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;

public class AttackActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public AttackActionString() {
    super("attack");
  }

  @Override
  public String actionBar() {
    return "TYPE ATTACK TO ATTACK";
  }
}
