package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;


public class DownActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public DownActionString() {
    super("down");
  }

  @Override
  public String actionBar() {
    return "TYPE DOWN TO MOVE DOWN";
  }
}
