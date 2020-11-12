package optic_fusion1.prisonescape.component.action;

import optic_fusion1.engine.component.Component;

/*
  Class that serves as a template for ActionString classes.
  ActionString classes provide Strings that are unique to different classes, this helps inform the user of his/her available options.
 */
public abstract class ActionString extends Component {

  public ActionString(String identity) {
    super(identity);
  }

  public abstract String actionBar(); //Action that returns a String unique to the ActionString.

  @Override
  public String toString() {
    return "ActionString: " + getName();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    ActionString actionString = (ActionString) other;
    return getName().equals(actionString.getName());
  }

  @Override
  public int hashCode() {
    return getName().hashCode() * 31;
  }
}
