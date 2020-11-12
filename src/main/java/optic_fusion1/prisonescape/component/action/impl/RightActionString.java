package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;

public class RightActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public RightActionString() {
    super("right");
  }

  @Override
  public String actionBar() {
    return "TYPE RIGHT TO MOVE RIGHT";
  }
}
