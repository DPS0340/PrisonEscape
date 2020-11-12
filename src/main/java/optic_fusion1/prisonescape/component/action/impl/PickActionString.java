package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;

public class PickActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public PickActionString() {
    super("pick");
  }

  @Override
  public String actionBar() {
    return "TYPE PICK TO PICK UP WEAPON";
  }
}
