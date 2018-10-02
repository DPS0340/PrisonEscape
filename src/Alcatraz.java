import java.util.Scanner;

public class Alcatraz {
    //First level of the game(More to come hopefully).
    public static void main(String args[]){
        //Rooms
        Room start=new Room(new Position(0,0));
        start.setDes("WELCOME TO PRISON ESCAPE GOOD LUCK ESCAPING!!!\nTHE YEAR IS 1945,YOU ARE STUCK IN ALCATRAZ FEDERAL PENETENTIORY.\nA RIOT SUDDENLY BREAKS OUT,YOUR DOOR OPENS UP GIVING YOU A CHANCE TO ESCAPE.");
        start.addAction("right");
        //
        Room room01=new Room(new Position(0,1));
        room01.setDes("You enter a hallway.");
        room01.addAction("up");
        //
        Room room11=new Room(new Position(1,1));
        room11.setDes("You find rooms to your left and right.");
        room11.addAction("up");
        room11.addAction("down");
        room11.addAction("left");
        room11.addAction("right");
        //
        Room room10=new Room(new Position(1,0));
        room10.setItem(new Shiv());
        room10.setDes("You enter a room and find a shiv.");
        room10.addAction("pick");
        room10.addAction("right");
        //
        Room room12=new Room(new Position(1,2));
        room12.setDes("You encounter a Prison Inmate.\nPRISON INMATE:Got any cigs?");
        room12.addCharachter(new PrisonInmate());
        room12.addAction("attack");
        room12.addAction("left");
        //
        Room room21=new Room(new Position(2,1));
        room21.setDes("The exit to the hallway is not far away");
        room21.addAction("up");
        room21.addAction("down");
        //
        Room room31=new Room(new Position(3,1));
        room31.setDes("You find the exit to the hallway,attached to it a warning sign,perhaps an omen of whats to come.");
        room31.addAction("up");
        room31.addAction("down");
        //
        Room room41=new Room(new Position(4,1));
        room41.addCharachter(new Guard());
        room41.setDes("You encounter a guard.\nGUARD:Don't make me smack you boy!");
        room41.addAction("attack");
        room41.addAction("up");
        room41.addAction("down");
        room41.addAction("left");
        room41.addAction("right");
        //
        Room room51=new Room(new Position(5,1));
        room51.setDes("You find entrances to two rooms.");
        room51.addAction("up");
        room51.addAction("down");
        room51.addAction("left");
        //
        Room room50=new Room(new Position(5,0));
        room50.setDes("You enter an empty room and find the words HELP smeared with blood on the wall.");
        room50.addAction("right");
        //
        Room room61=new Room(new Position(6,1));
        room61.setDes("You encounter one of the senior guards at the prison.\nSENIOR GUARD:I've got bigger fish to fry maggot.");
        room61.addAction("attack");
        room61.addAction("down");
        room61.addAction("up");
        room61.addCharachter(new SeniorGuard());
        //
        Room room71=new Room(new Position(7,1));
        room71.setDes("You enter a room with a grotesque and pungent smell,and hear a disturbing noise.");
        room71.addAction("up");
        room71.addAction("down");
        room71.addAction("left");
        room71.addAction("right");
        //
        Room room70=new Room(new Position(7,0));
        room70.setDes("You enter a room and find a medkit.");
        room70.addAction("right");
        room70.addAction("heal");
        //
        Room room72=new Room(new Position(7,2));
        room72.setDes("You find a pile of corpses.Who could have done this?");
        room72.addAction("left");
        //
        Room room81=new Room(new Position(8,1));
        room81.setDes("You encounter a psycho killer.\nPSYCHO KILLER:HAHAHAHAHAHAH.");
        room81.addAction("down");
        room81.addAction("attack");
        room81.addCharachter(new PsychoKiller());
        //
        Room room42=new Room(new Position(4,2));
        room42.setDes("You enter narrow passage.You have to move right to continue down the passageway.");
        room42.addAction("right");
        room42.addAction("left");
        //
        Room room43=new Room(new Position(4,3));
        room43.setDes("You find two doors.One in front of you and one to your back.");
        room43.addAction("up");
        room43.addAction("down");
        room43.addAction("left");
        room43.addAction("right");
        //
        Room room33=new Room(new Position(3,3));
        room33.setDes("You enter an empty room.");
        room33.addAction("up");
        //
        Room room53=new Room(new Position(5,3));
        room53.setDes("You encounter a gang leader.\nGANGLEADER:What you looking at?");
        room53.addAction("down");
        room53.addAction("attack");
        room53.addCharachter(new GangLeader());
        //
        Room room44=new Room(new Position(4,4));
        room44.setDes("You proceed through the passage-way");
        room44.addAction("right");
        room44.addAction("left");
        //
        Room room45=new Room(new Position(4,5));
        room45.setDes("You find a door in front of you,perhaps it might be more effective to continue through the passageway.");
        room45.addAction("left");
        room45.addAction("right");
        room45.addAction("up");
        //
        Room room55=new Room(new Position(5,5));
        room55.setDes("You find a handgun.");
        room55.addAction("pick");
        room55.addAction("down");
        room55.setItem(new HandGun());
        //
        Room room46=new Room(new Position(4,6));
        room46.setDes("The end of the passageway is almost near,but you find alternative paths up front and behind you.Be careful in deciding your next move.");
        room46.addAction("left");
        room46.addAction("right");
        room46.addAction("up");
        room46.addAction("down");
        //
        Room room47=new Room(new Position(4,7));
        room47.setDes("You have come to the end of the passageway,finding two alternative paths to take.");
        room47.addAction("left");
        room47.addAction("up");
        room47.addAction("down");
        //
        Room room37=new Room(new Position(3,7));
        room37.setDes("You enter a dark room");
        room37.addAction("up");
        room37.addAction("down");
        //
        Room room27=new Room(new Position(2,7));
        room27.setDes("You enter another dark room and find a shotgun.");
        room27.addAction("up");
        room27.addAction("down");
        room27.addAction("pick");
        room27.setItem(new Shotgun());
        //
        Room room17=new Room(new Position(1,7));
        room17.setDes("You encounter a drugdealer.\nDRUGDEALER:Don't mess with me.");
        room17.addAction("attack");
        room17.addAction("up");
        room17.addCharachter(new DrugDealer());
        //
        Room room57=new Room(new Position(5,7));
        room57.setDes("You enter a bright room");
        room57.addAction("up");
        room57.addAction("down");
        //
        Room room67=new Room(new Position(6,7));
        room67.setDes("You enter another bright room with exit signs.");
        room67.addAction("up");
        room67.addAction("down");
        //
        Room room77=new Room(new Position(7,7));
        room77.setDes("You see the exit to the prison.");
        room77.addAction("up");
        room77.addAction("down");
        //
        Room room87=new Room(new Position(8,7));
        room87.setDes("Congratulations,you have escaped.");
        //
        Room room36=new Room(new Position(3,6));
        room36.setDes("You enter an empty room.");
        room36.addAction("down");
        room36.addAction("up");
        //
        Room room26=new Room(new Position(2,6));
        room26.setDes("You enter an empty room.");
        room26.addAction("up");
        room26.addAction("down");
        //
        Room room56=new Room(new Position(5,6));
        room56.setDes("You enter an empty room.");
        room56.addAction("up");
        room56.addAction("down");
        //
        Room room66=new Room(new Position(6,6));
        room66.setDes("You enter an empty room.");
        room66.addAction("up");
        room66.addAction("down");
        //
        Room room76=new Room(new Position(7,6));
        room76.setDes("You enter a room and find a medkit");
        room76.addAction("heal");
        room76.addAction("down");
        //
        Room room40=new Room(new Position(4,0));
        room40.setDes("You enter a room and find a medkit");
        room40.addAction("heal");
        room40.addAction("right");
        //
        Room room16=new Room(new Position(1,6));
        room16.setDes("You encounter a drug dealer.\nDRUGDEALER:Don't mess with me");
        room16.addAction("up");
        room16.addAction("attack");
        room16.addCharachter(new DrugDealer());
        //Setup
        Player player=new Player();
        World world=new World(player,10,10);
        Handler handler=new Handler(world);
        Scanner scanner=new Scanner(System.in);
        world.setRoom(start);
        world.setRoom(room01);
        world.setRoom(room10);
        world.setRoom(room11);
        world.setRoom(room12);
        world.setRoom(room17);
        world.setRoom(room16);
        world.setRoom(room21);
        world.setRoom(room27);
        world.setRoom(room31);
        world.setRoom(room33);
        world.setRoom(room37);
        world.setRoom(room41);
        world.setRoom(room42);
        world.setRoom(room43);
        world.setRoom(room44);
        world.setRoom(room45);
        world.setRoom(room46);
        world.setRoom(room47);
        world.setRoom(room50);
        world.setRoom(room51);
        world.setRoom(room53);
        world.setRoom(room55);
        world.setRoom(room57);
        world.setRoom(room61);
        world.setRoom(room70);
        world.setRoom(room71);
        world.setRoom(room72);
        world.setRoom(room77);
        world.setRoom(room81);
        world.setRoom(room87);
        world.setRoom(room36);
        world.setRoom(room26);
        world.setRoom(room56);
        world.setRoom(room66);
        world.setRoom(room76);
        world.setRoom(room40);
        world.setRoom(room77);
        world.setRoom(room67);
        world.setEscape(new Position(8,7));
        System.out.println(handler.movementDispaly(start));
        while(player.isAlive() && world.caged()){
            handler.handleInput(scanner.next());
        }

    }
}
