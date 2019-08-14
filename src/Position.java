import java.util.Objects;

public class Position {
    //Class that is used to represent the position of various different objects in the game.
    //Class adheres to a traditional cartesian co-ordinate system.
    private final int x;
    private final int y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    //Getter Functions/Accessor Methods.
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
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
        Position position = (Position) other;
        return (this.x == position.getX()) && (this.y == position.getY());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }

}
