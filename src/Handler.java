public class Handler {
    //Class that handles the inputs provided by the user.
    private World world;
    private String startline="*************************************************************************************************";
    private String endline="-------------------------------------------------------------------------------------------------";
    public Handler(World world){
        this.world=world;
    }
    public void handleInput(String s){
        //Main method that handles all the inputs.
        switch (s){
           case "up":
               if(valid("up")){
                movement(s);}
                else{System.out.println("INVALID ACTION");}
                break;
            case "down":
                if(valid("down")){
                movement(s);}
                else{System.out.println("INVALID ACTION");}
                break;
            case "left":
                if(valid("left")){
                movement(s);}
                else{System.out.println("INVALID ACTION");}
                break;
            case "right":
                if(valid("right")){
                movement(s);}
                else{System.out.println("INVALID ACTION");}
                break;
            case "attack":
                if(valid("attack")){
                attack();}
                else{System.out.println("INVALID ACTION");}
                break;
            case "pick":
                if(valid("pick")){
                    pick(world.getRoom(world.getPointer()));}
                else{System.out.println("INVALID ACTION");}
                break;
            case "heal":
                if(valid("heal")){
                    heal();
                }
                else{System.out.println("INVALID ACTION");}
                break;
            default:
                System.out.println("Unrecognized Action");
        }
    }
    private String filterString(String s){
        //Helper function that makes all inputs lowercase.
        return s.toLowerCase();
    }
    private void movement(String s){
        //Helper method that handles player movement in game.
        Position old_position=world.getPlayer().getPosition();
        Position new_position;
        switch (s){
            case "up":
                 new_position=new Position(old_position.getX()+1,old_position.getY());
                 break;
            case "down":
                 new_position=new Position(old_position.getX()-1,old_position.getY());
                 break;
            case "left":
                 new_position=new Position(old_position.getX(),old_position.getY()-1);
                 break;
            case "right":
                 new_position=new Position(old_position.getX(),old_position.getY()+1);
                 break;
            default:
                 new_position=old_position;
        }
        if(world.is_valid(new_position)){
            world.getPlayer().setPosition(new_position);
            world.changePointer(new_position);
            System.out.println(movementDispaly(world.getRoom(new_position)));
        }
        else{
            System.out.println("OUT OF BOUNDS!!!");
        }

    }
    private void attack(){
        //Helper method that handles attacks in the game.
        Room room=world.getRoom(world.getPointer());
        Player p=world.getPlayer();
        Charachter e=room.getCharachter();
        Boolean hit=p.doDamage(e);
        Boolean hit_back=e.doDamage(p);
        String player_string="";
        if(hit){
            player_string="You hit "+e.toString()+" dealing "+Integer.valueOf(p.getWeapon().getDamage())+" damage.";
        }
        else{
            player_string="You try to hit "+e.toString()+" but fail.";
        }
        if(hit_back){
            player_string=player_string+e.toString()+" hits back dealing "+Integer.valueOf(e.getWeapon().getDamage())+" damage.";
            }
        else{
            player_string=player_string+e.toString()+" tries to hit back but misses.";
        }
        if(e.getHealth()<=0){
            room.removeCharachter();
            room.removeAction("attack");
            room.setItem(e.getWeapon());
            room.addAction("pick");
            player_string=e.toString()+" is dead.";
            if(hit_back){player_string=player_string+"Dealing "+e.getWeapon().getDamage().toString()+" damage.";}
            p.addScore(e.scoreValue());
        }
        if(p.getHealth()<=0){
            p.dead();
            System.out.println("YOU HAVE DIED.GOOD LUCK ESCAPING NEXT TIME.");
            System.exit(0);
        }
        room.setDes(player_string);
        System.out.println(movementDispaly(room));
        if(room.emptyRoom()){
            room.setDes("You enter a room and find a "+e.getWeapon().toString());
        }
    }
    private String healthBar(){
        //Healthbar of player.
        return "PLAYER HEALTH:"+Integer.valueOf(world.getPlayer().getHealth())+"    "+"PLAYER WEAPON:"+world.getPlayer().getWeapon().toString()+"    "+"SCORE:"+world.getPlayer().getScore().toString();
    }
    private String enemyBar(){
        //Healthvar of an enemy
        return "ENEMY HEALTH:"+Integer.valueOf(world.getRoom(world.getPointer()).getCharachter().getHealth())+"    "+"ENEMY WEAPON:"+world.getRoom(world.getPointer()).getCharachter().getWeapon().toString();
    }
    public String movementDispaly(Room room){
        //Method that presents the texts in a certain format.
        String result=startline+"\n";
        result=result+healthBar()+"\n";
        if(!room.emptyRoom()){result=result+enemyBar()+"\n"+"\n";}
        else{result=result+"\n";}
        result=result+room.getSetup()+"\n"+endline;
        return result;
    }
    private boolean valid(String s){
        //Checks whether the input is a valid action or not.
        Room current=world.getRoom(world.getPointer());
        //System.out.println(current);
        if(current.validAction(s)){return true;}
        return false;
    }
    private void pick(Room room){
        //Method that is used for picking objects.
        Weapon primary=room.getItem();
        Weapon secondary=world.getPlayer().getWeapon();
        world.getPlayer().setWeapon(primary);
        if(secondary instanceof Knuckels){
            room.setDes("You picked up "+primary.toString());
            room.removeAction("pick");
            System.out.println(movementDispaly(room));
            room.setDes("You enter an empty room");
        }
        else{
            room.setItem(secondary);
            room.setDes("You picked up "+primary.toString()+" dropping "+secondary.toString());
            System.out.println(movementDispaly(room));
            room.setDes("You enter a room and find a "+secondary.toString());
        }
    }
    private void heal(){
        //Method that is used to heal the player.
        Room room=world.getRoom(world.getPointer());
        world.getPlayer().setHealth(200);
        room.removeAction("heal");
        room.setDes("You have healed yourself using medkit");
        System.out.println(movementDispaly(room));
        room.setDes("You enter an empty room");
    }
}
