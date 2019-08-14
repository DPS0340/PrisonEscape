import java.util.Objects;

public abstract class ActionString {
    //Class that serves as a template for ActionString classes.
    //ActionString classes provide Strings that are unique to different classes, this helps inform the user of his/her available options.
    private final String identity; //String used to identify the ActionString.

    public ActionString(String identity){
        this.identity = identity;
    }
    //Getter Functions/Accessor Methods.
    public String getIdentity(){
        return this.identity;
    }

    public abstract String actionBar(); //Action that returns a String unique to the ActionString.

    @Override
    public String toString(){
        return "ActionString: " + this.identity;
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
        ActionString actionString = (ActionString) other;
        return this.identity.equals(actionString.getIdentity());
    }
    @Override
    public int hashCode(){
        return this.identity.hashCode() * 31;
    }
}
