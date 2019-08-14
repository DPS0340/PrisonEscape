import java.util.Scanner;

public class Alcatraz {
    //First level of the game (More to come hopefully).
    public static void main(String[] args){
        //Setup
        Player player=new Player();
        World world=new World("Alcatraz", player, 10, 10);
        Handler handler=new Handler(world);
        Scanner scanner=new Scanner(System.in);

        //ActionStrings
        AttackActionString attackActionString = new AttackActionString();
        HealActionString healActionString = new HealActionString();
        PickActionString pickActionString = new PickActionString();
        UpActionString upActionString = new UpActionString();
        DownActionString downActionString = new DownActionString();
        LeftActionString leftActionString = new LeftActionString();
        RightActionString rightActionString = new RightActionString();

        //Rooms
        Room start=new Room(new Position(0,0));
        start.setDescription("WELCOME TO PRISON ESCAPE GOOD LUCK ESCAPING!!!\nTHE YEAR IS 1945,YOU ARE STUCK IN ALCATRAZ FEDERAL PENETENTIORY.\nA RIOT SUDDENLY BREAKS OUT,YOUR DOOR OPENS UP GIVING YOU A CHANCE TO ESCAPE.");
        start.addAction(upActionString);
        //
        Room room01=new Room(new Position(0,1));
        room01.setDescription("You enter a hallway.");
        room01.addAction(rightActionString);
        //
        Room room11=new Room(new Position(1,1));
        room11.setDescription("You find two rooms.");
        room11.addAction(upActionString);
        room11.addAction(downActionString);
        room11.addAction(leftActionString);
        room11.addAction(rightActionString);
        //
        Room room10=new Room(new Position(1,0));
        room10.setItem(new Shiv());
        room10.addAction(pickActionString);
        room10.addAction(upActionString);
        //
        Room room12=new Room(new Position(1,2));
        room12.setEnemy(new PrisonInmate());
        room12.addAction(attackActionString);
        room12.addAction(downActionString);
        //
        Room room21=new Room(new Position(2,1));
        room21.setDescription("The exit to the hallway is not far away");
        room21.addAction(rightActionString);
        room21.addAction(leftActionString);
        //
        Room room31=new Room(new Position(3,1));
        room31.setDescription("You find the exit to the hallway,attached to it a warning sign,perhaps an omen of whats to come.");
        room31.addAction(rightActionString);
        room31.addAction(leftActionString);
        //
        Room room41=new Room(new Position(4,1));
        room41.setEnemy(new Guard());
        room41.addAction(attackActionString);
        room41.addAction(upActionString);
        room41.addAction(downActionString);
        room41.addAction(leftActionString);
        room41.addAction(rightActionString);
        //
        Room room51=new Room(new Position(5,1));
        room51.setDescription("You find entrances to two rooms.");
        room51.addAction(rightActionString);
        room51.addAction(downActionString);
        room51.addAction(leftActionString);
        //
        Room room50=new Room(new Position(5,0));
        room50.setDescription("You enter an empty room and find the words HELP smeared with blood on the wall.");
        room50.addAction(upActionString);
        //
        Room room61=new Room(new Position(6,1));
        room61.addAction(attackActionString);
        room61.addAction(leftActionString);
        room61.addAction(rightActionString);
        room61.setEnemy(new SeniorGuard());
        //
        Room room71=new Room(new Position(7,1));
        room71.setDescription("You enter a room with a grotesque and pungent smell,and hear a disturbing noise.");
        room71.addAction(upActionString);
        room71.addAction(downActionString);
        room71.addAction(leftActionString);
        room71.addAction(rightActionString);
        //
        Room room70=new Room(new Position(7,0));
        room70.setItem(new MedKit());
        room70.addAction(upActionString);
        room70.addAction(healActionString);
        //
        Room room72=new Room(new Position(7,2));
        room72.setDescription("You find a pile of corpses.Who could have done this?");
        room72.addAction(downActionString);
        //
        Room room81=new Room(new Position(8,1));
        room81.addAction(leftActionString);
        room81.addAction(attackActionString);
        room81.setEnemy(new PsychoKiller());
        //
        Room room42=new Room(new Position(4,2));
        room42.setDescription("You enter narrow passage.You have to move up to continue down the passageway.");
        room42.addAction(upActionString);
        room42.addAction(downActionString);
        //
        Room room43=new Room(new Position(4,3));
        room43.setDescription("You find two doors.");
        room43.addAction(upActionString);
        room43.addAction(downActionString);
        room43.addAction(leftActionString);
        room43.addAction(rightActionString);
        //
        Room room33=new Room(new Position(3,3));
        room33.addAction(rightActionString);
        //
        Room room53=new Room(new Position(5,3));
        room53.addAction(leftActionString);
        room53.addAction(attackActionString);
        room53.setEnemy(new GangLeader());
        //
        Room room44=new Room(new Position(4,4));
        room44.setDescription("You proceed through the passage-way");
        room44.addAction(upActionString);
        room44.addAction(downActionString);
        //
        Room room45=new Room(new Position(4,5));
        room45.setDescription("You find a door in front of you,perhaps it might be more effective to continue through the passageway.");
        room45.addAction(downActionString);
        room45.addAction(upActionString);
        room45.addAction(rightActionString);
        //
        Room room55=new Room(new Position(5,5));
        room55.addAction(pickActionString);
        room55.addAction(leftActionString);
        room55.setItem(new HandGun());
        //
        Room room46=new Room(new Position(4,6));
        room46.setDescription("The end of the passageway is almost near,but you find alternative paths.Be careful in deciding your next move.");
        room46.addAction(leftActionString);
        room46.addAction(rightActionString);
        room46.addAction(upActionString);
        room46.addAction(downActionString);
        //
        Room room47=new Room(new Position(4,7));
        room47.setDescription("You have come to the end of the passageway,finding two alternative paths to take.");
        room47.addAction(leftActionString);
        room47.addAction(rightActionString);
        room47.addAction(downActionString);
        //
        Room room37=new Room(new Position(3,7));
        room37.setDescription("You enter a dark room");
        room37.addAction(rightActionString);
        room37.addAction(leftActionString);
        //
        Room room27=new Room(new Position(2,7));
        room27.addAction(rightActionString);
        room27.addAction(leftActionString);
        room27.addAction(pickActionString);
        room27.setItem(new Shotgun());
        //
        Room room17=new Room(new Position(1,7));
        room17.addAction(attackActionString);
        room17.addAction(rightActionString);
        room17.setEnemy(new DrugDealer());
        //
        Room room57=new Room(new Position(5,7));
        room57.setDescription("You enter a bright room");
        room57.addAction(rightActionString);
        room57.addAction(leftActionString);
        //
        Room room67=new Room(new Position(6,7));
        room67.setDescription("You enter another bright room with exit signs.");
        room67.addAction(rightActionString);
        room67.addAction(leftActionString);
        //
        Room room77=new Room(new Position(7,7));
        room77.setDescription("You see the exit to the prison.");
        room77.addAction(rightActionString);
        room77.addAction(leftActionString);
        //
        Room room87=new Room(new Position(8,7));
        room87.setDescription("Congratulations,you have escaped.");
        //
        Room room36=new Room(new Position(3,6));
        room36.addAction(leftActionString);
        room36.addAction(rightActionString);
        //
        Room room26=new Room(new Position(2,6));
        room26.addAction(rightActionString);
        room26.addAction(leftActionString);
        //
        Room room56=new Room(new Position(5,6));
        room56.addAction(rightActionString);
        room56.addAction(leftActionString);
        //
        Room room66=new Room(new Position(6,6));
        room66.addAction(rightActionString);
        room66.addAction(leftActionString);
        //
        Room room76=new Room(new Position(7,6));
        room76.addAction(healActionString);
        room76.addAction(leftActionString);
        room76.setItem(new MedKit());
        //
        Room room40=new Room(new Position(4,0));
        room40.addAction(healActionString);
        room40.addAction(upActionString);
        room40.setItem(new MedKit());
        //
        Room room16=new Room(new Position(1,6));
        room16.addAction(rightActionString);
        room16.addAction(attackActionString);
        room16.setEnemy(new DrugDealer());

        //Finishing
        world.addRoom(start);
        world.addRoom(room01);
        world.addRoom(room10);
        world.addRoom(room11);
        world.addRoom(room12);
        world.addRoom(room17);
        world.addRoom(room16);
        world.addRoom(room21);
        world.addRoom(room27);
        world.addRoom(room31);
        world.addRoom(room33);
        world.addRoom(room37);
        world.addRoom(room41);
        world.addRoom(room42);
        world.addRoom(room43);
        world.addRoom(room44);
        world.addRoom(room45);
        world.addRoom(room46);
        world.addRoom(room47);
        world.addRoom(room50);
        world.addRoom(room51);
        world.addRoom(room53);
        world.addRoom(room55);
        world.addRoom(room57);
        world.addRoom(room61);
        world.addRoom(room70);
        world.addRoom(room71);
        world.addRoom(room72);
        world.addRoom(room77);
        world.addRoom(room81);
        world.addRoom(room87);
        world.addRoom(room36);
        world.addRoom(room26);
        world.addRoom(room56);
        world.addRoom(room66);
        world.addRoom(room76);
        world.addRoom(room40);
        world.addRoom(room77);
        world.addRoom(room67);
        world.setEscape(new Position(8,7));
        handler.genericOutput();
        while(world.caged()){
            handler.handleInput(scanner.next());
        }
    }
}
