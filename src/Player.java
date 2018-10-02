public class Player extends Charachter {
    private boolean alive;
    private Position position;
    private boolean free;
    private Integer score;
    public Player(){
        super("Player",200,new Knuckels(),8);
        this.alive=true;
        this.free=false;
        this.position=new Position(0,0);
        this.score=0;
    }
    public void setPosition(Position position){
        this.position=position;
    }
    public Position getPosition(){
        return this.position;
    }
    public void dead(){
        this.alive=false;
    }
    public void escape(){
        this.free=true;
    }
    public boolean isAlive(){
        return this.alive;
    }
    public boolean hasEscaped(){
        return this.free;
    }
    public Integer getScore(){
        return this.score;
    }
    public void addScore(Integer add){
        this.score=this.score+add;
    }
}
