import java.util.Objects;

public abstract  class Action {
    //Class that provides template/common functionality for all Action Classes in the game.
    //Action classes are responsible for bringing about some change in the game and/or providing some sort of output for the user.

    private Handler handler; //Handler through which necessary information and/or functionality for the action is provided.
    private final String name;//Name of the Action needed to identify the Action.

    public Action(String name, Handler handler){
        this.name = name;
        this.handler = handler;
    }
    //Getter Functions/Accessor Methods.
    public Handler getHandler(){
        return this.handler;
    }
    public String getName(){
        return this.name;
    }

    //Setter Functions/Mutator Methods.
    public void setHandler(Handler handler){
        this.handler = handler;
    }

    //Abstract method to be implemented by any Action Class which attempts to provide the functionality mentioned above.
    public abstract void action();

    @Override
    public String toString(){
        return "Action: " + this.name;
    }
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(this.getClass() != other.getClass()){
            return false;
        }
        Action action = (Action) other;
        return this.name.equals(action.getName()) && this.handler.equals(action.getHandler());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.handler);
    }
}
