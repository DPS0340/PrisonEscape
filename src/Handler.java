import java.util.HashMap;

public class Handler {
    //Class that handles the inputs provided by the user.
    private World world; //World object that the user/player changes through the Handler Object.
    private final HashMap<String,Action> actions = new HashMap<>(); //HashMap that contains String/Action pairings representing allowable inputs and appropriate Actions necessary to handle them.

    public Handler(World world){
        this.world = world;
        this.init();
    }
    //Getter Functions/Accessor Methods.
    public World getWorld(){
        return this.world;
    }
    public HashMap<String,Action> getActions(){
        return this.actions;
    }

    //Setter Functions/Mutator Methods.
    public void setWorld(World world){
        this.world = world;
    }

    private void init(){
        //Method that puts default String/ActionString pairings into the actions HashMap.
        this.actions.put("up", new UpAction(this));
        this.actions.put("down", new DownAction(this));
        this.actions.put("left", new LeftAction(this));
        this.actions.put("right", new RightAction(this));
        this.actions.put("attack", new AttackAction(this));
        this.actions.put("pick", new PickAction(this));
        this.actions.put("heal", new HealAction(this));
    }
    public boolean containsAction(String string){
        //Method that returns true in an entry in the actions HashMap contains the String key provided in the argument.
        //Method returns false if no such entry exists.
        if(this.actions.containsKey(string)){
            return true;
        }
        else{
            return false;
        }
    }
    public void addAction(String string, Action action){
        //Method that adds a String/Action pair to the actions HashMap.
        this.actions.put(string, action);
    }
    public void handleInput(String string){
        //Main method that handles all the inputs.
        String input = string.toLowerCase();
        Action action = this.actions.get(input);
        Room room = this.world.getRoom(this.world.getPlayer().getPosition());
        if (!room.containsAction(input) || !this.containsAction(input)){
            System.out.println("Invalid Action");
        }
        else {
            try {
                action.action();
            }
            catch (NullPointerException exception){
                //NullPointerException which may be caused by an action being placed in a room it should not be in.
                System.out.println("NullPointer Exception, An Action is in a room that it should not be in.");
                System.exit(1);
            }
        }
    }

    public void genericOutput(){
        //Method that provides a generic Output to the user based on, the rooms present in the World Object and the player in the World Object.
        String startLine = "*************************************************************************************************";
        String endLine = "-------------------------------------------------------------------------------------------------";
        String display = startLine + "\n" + this.healthBar() + "\n";
        if(this.world.getRoom(this.world.getPlayer().getPosition()).containsEnemy()){
            display = display + this.enemyBar() + "\n";
        }
        display = display + "\n" + this.world.getRoom(this.world.getPlayer().getPosition()).roomDisplay() + endLine;
        System.out.println(display);
    }
    private String healthBar(){
        //Helper method for the genericOutput method that provides information to the user about the player.
        Player player = this.world.getPlayer();
        return "PLAYER HEALTH:" + Integer.toString(player.getHealth()) + "    "+"PLAYER WEAPON:" + player.getWeapon().toString()
                + "    " + "SCORE:" + Integer.toString(player.getScore());
    }
    private String enemyBar(){
        //Helper method for the genericOutput method that provides information to the user about an Enemy Object.
        Player player = this.world.getPlayer();
        Position position = player.getPosition();
        Room room = this.world.getRoom(position);
        Enemy enemy = room.getEnemy();
        return "ENEMY HEALTH:" + Integer.toString(enemy.getHealth()) + "      " + "ENEMY WEAPON:" + enemy.getWeapon().toString();
    }

    @Override
    public String toString(){
        return "Handler";
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
        Handler handler = (Handler) other;
        return this.actions.equals(handler.getActions());
    }
    @Override
    public int hashCode(){
        return this.actions.hashCode() * 31;
    }

}
