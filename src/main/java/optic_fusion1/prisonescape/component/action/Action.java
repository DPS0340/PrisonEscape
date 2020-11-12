package optic_fusion1.prisonescape.component.action;

import java.util.Objects;
import optic_fusion1.engine.component.Component;

/*
  Class that provides template/common functionality for all Action Classes in the game.
  Action classes are responsible for bringing about some change in the game and/or providing some sort of output for the user.
 */
public abstract class Action extends Component {

  private Handler handler;

  /*
  Handler through which necessary information and/or functionality for the action is provided.
  String: Name of the Action needed to identify the Action.
   */
  public Action(String name, Handler handler) {
    super(name);
    this.handler = handler;
  }

  //Getter Functions/Acessor Methods.
  public Handler getHandler() {
    return handler;
  }

  //Setter Functions/Mutator Methods.
  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  //Abstract method to be implemented by any Action Class which attempts to provided the functionality mentioned above.
  public abstract void action();

  @Override
  public String toString() {
    return "Action: " + getName();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Action action = (Action) other;
    return getName().equals(action.getName()) && handler.equals(action.getHandler());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), handler);
  }

}
