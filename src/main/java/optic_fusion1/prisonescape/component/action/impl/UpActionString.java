package optic_fusion1.prisonescape.component.action.impl;


import optic_fusion1.prisonescape.component.action.ActionString;


public class UpActionString extends ActionString {
  //Class that represents an example of an ActionString object.

  public UpActionString() {
    super("up");
  }

  @Override
  public String actionBar() {
    return "TYPE UP TO MOVE UP";
  }
}
