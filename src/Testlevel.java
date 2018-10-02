import java.util.Scanner;
//Testlevel used for trial and error.
public class Testlevel {
    public static void main(String args[]){

        //Rooms
        Room roomStart=new Room(new Position(0,0));
        roomStart.setDes("WELCOME TO PRISON ESCAPE GOOD LUCK");
        roomStart.addAction("right");
        //
        Room roomOne=new Room(new Position(0,1));
        roomOne.setDes("You enter a hallway");
        roomOne.addAction("up");
        //
        Room roomTwo=new Room(new Position(1,1));
        roomTwo.setDes("You find doors to your left and right");
        roomTwo.addAction("up");
        roomTwo.addAction("left");
        roomTwo.addAction("right");
        roomTwo.addAction("down");
        //
        Room roomThree=new Room(new Position(1,0));
        roomThree.setDes("You enter an empty room and find a shiv");
        roomThree.setItem(new Shiv());
        roomThree.addAction("right");
        roomThree.addAction("pick");
        //
        Room roomFour=new Room(new Position(1,2));
        roomFour.setDes("You encounter a prison inmate");
        roomFour.addAction("attack");
        roomFour.addAction("left");
        roomFour.addCharachter(new PrisonInmate());
        //
        Room roomFive=new Room(new Position(2,1));
        roomFive.setDes("You see the exit to the hallway and decide to take it");
        //
        Player player=new Player();
        World world=new World(player);
        Handler handler=new Handler(world);
        Scanner scanner=new Scanner(System.in);
        world.setRoom(roomStart);
        world.setRoom(roomOne);
        world.setRoom(roomTwo);
        world.setRoom(roomThree);
        world.setRoom(roomFour);
        world.setRoom(roomFive);
        world.setEscape(new Position(2,1));
        System.out.println(handler.movementDispaly(roomStart));
        while(player.isAlive() && world.caged()){
            handler.handleInput(scanner.next());
        }
    }
}
