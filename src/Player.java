import java.util.Objects;

public class Player extends Charachter {
    //Class that represents the user/player of the game.

    private Position position; //Current position of the player in a World Object.
    private int score; //Score the player has attained by defeating/killing enemies in the game.

    public Player(){
        super("Player",200,new Knuckels(),8);
        this.position = new Position(0,0); //Default Position of a player.
        this.score = 0;
    }
    public Player(Position position){
        this();
        this.setPosition(position);
    }

    //Getter Functions/Accessor Methods.
    public Position getPosition(){
        return this.position;
    }
    public int getScore(){
        return this.score;
    }

    //Setter Functions/Mutator Methods.
    public void setPosition(Position position){
        this.position = position;
    }
    public void setScore(int score){
        this.score = score;
    }

    @Override
    public String toString(){
        return "Player";
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
        Player player = (Player) other;
        if(!super.equals(player)){
            return false;
        }
        return this.position.equals(player.getPosition()) && (this.score == player.getScore());
    }
    @Override
    public int hashCode(){
        return (super.hashCode()*31) + Objects.hash(this.position, this.score);
    }
}
