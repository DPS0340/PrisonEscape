package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;


public class HealActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public HealActionString() {
    super("heal");
  }

  @Override
  public String actionBar() {
    return "TYPE HEAL TO USE MEDKIT";
  }
}
