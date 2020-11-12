package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;


public class LeftActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public LeftActionString() {
    super("left");
  }

  @Override
  public String actionBar() {
    return "TYPE LEFT TO MOVE LEFT";
  }
}
