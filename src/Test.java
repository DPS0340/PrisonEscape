import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        //TESTS FOR THE ROOM CLASS
        /*
        Room room=new Room(new Position(1,1));
        System.out.println(room.emptyRoom());
        room.setPos(new Position(2,2));
        room.addAction("up");
        room.addAction("down");
        room.addAction("right");
        room.addAction("attack");
        room.addAction("left");
        Charachter d=new DrugDealer();
        room.addCharachter(d);
        System.out.println(room.getPos());
        System.out.println(room.getActionbar());
        System.out.println(room.validAction("left"));
        System.out.println(room.getCharachter());
        System.out.println(room.emptyRoom());
        System.out.println(room.getDes());
        room.setDes("Hi Waldo");
        System.out.println(room.getSetup());
        */
        //Tests for the World class
        /*Player player=new Player();
        World w=new World(player);
        System.out.println(w.is_valid(new Position(20,20)));
        w.setEscape(new Position(8,9));
        System.out.println(w.getEscape());
        w.changePointer(new Position(2,2));
        System.out.println(w.getPointer());
        System.out.println(w.getRooms());
        Room r=new Room(new Position(0,0));
        r.addCharachter(new Guard());
        w.setRoom(r);
        Room other=w.getRoom(new Position(0,0));
        System.out.println(w.getRoom(new Position(0,0)).getCharachter());
        Player player1=w.getPlayer();
        System.out.println(player1.getWeapon());*/
        //Tests for the handler class
        /*Player player=new Player();
        World world=new World(player);
        Handler handler=new Handler(world);
        Room roomOne=new Room(new Position(0,0));
        roomOne.addCharachter(new Guard());
        roomOne.addAction("Up");
        roomOne.addAction("Down");
        roomOne.addAction("Attack");
        roomOne.setDes("You encounter a guard.");
        world.setRoom(roomOne);
        Room roomTwo=new Room(new Position(1,0));
        roomTwo.addAction("up");
        roomTwo.addAction("right");
        roomTwo.setDes("You enter an empty room.");
        world.setRoom(roomTwo);
        System.out.println(player.getHealth());
        System.out.println(roomOne.getCharachter().getHealth());
        handler.handleInput("Attack");
        handler.handleInput("attack");
        System.out.println(player.getHealth());
        System.out.println(roomOne.getCharachter().getHealth());*/
        //Tests for scanner
        Scanner dunk=new Scanner(System.in);
        boolean sw=true;
        while(sw){
            if(dunk.next().equals("stop")){sw=false;}
            System.out.println(dunk.next());
        }
    }
}
