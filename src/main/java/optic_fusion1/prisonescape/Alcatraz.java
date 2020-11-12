package optic_fusion1.prisonescape;

import optic_fusion1.engine.game.SimpleGame;
import optic_fusion1.prisonescape.component.Room;
import optic_fusion1.prisonescape.component.World;
import optic_fusion1.prisonescape.component.action.Handler;
import optic_fusion1.prisonescape.component.action.impl.AttackActionString;
import optic_fusion1.prisonescape.component.action.impl.DownActionString;
import optic_fusion1.prisonescape.component.action.impl.HealActionString;
import optic_fusion1.prisonescape.component.action.impl.LeftActionString;
import optic_fusion1.prisonescape.component.action.impl.PickActionString;
import optic_fusion1.prisonescape.component.action.impl.RightActionString;
import optic_fusion1.prisonescape.component.action.impl.UpActionString;
import optic_fusion1.prisonescape.component.entity.Player;
import optic_fusion1.prisonescape.component.entity.impl.DrugDealer;
import optic_fusion1.prisonescape.component.entity.impl.GangLeader;
import optic_fusion1.prisonescape.component.entity.impl.Guard;
import optic_fusion1.prisonescape.component.entity.impl.PrisonInmate;
import optic_fusion1.prisonescape.component.entity.impl.PsychoKiller;
import optic_fusion1.prisonescape.component.entity.impl.SeniorGuard;
import optic_fusion1.prisonescape.component.item.MedKit;
import optic_fusion1.prisonescape.component.weapon.impl.HandGun;
import optic_fusion1.prisonescape.component.weapon.impl.Shiv;
import optic_fusion1.prisonescape.component.weapon.impl.Shotgun;
import optic_fusion1.prisonescape.util.Position;

public class Alcatraz extends SimpleGame {

  private static final Player PLAYER = new Player();
  private static final World WORLD = new World("Alcatraz", PLAYER, 10, 10);
  private static final Handler HANDLER = new Handler(WORLD);

  @Override
  public void startGame() {
    init();
    setRunning(true);
    setup();
    run();
  }

  private void setup() {
    //ActionStrings
    AttackActionString attackActionString = new AttackActionString();
    HealActionString healActionString = new HealActionString();
    PickActionString pickActionString = new PickActionString();
    UpActionString upActionString = new UpActionString();
    DownActionString downActionString = new DownActionString();
    LeftActionString leftActionString = new LeftActionString();
    RightActionString rightActionString = new RightActionString();

    //Rooms
    Room start = new Room(new Position(0, 0));
    start.setDescription("WELCOME TO PRISON ESCAPE GOOD LUCK ESCAPING!!!\nTHE YEAR IS 1945,YOU ARE STUCK IN ALCATRAZ FEDERAL PENETENTIORY.\nA RIOT SUDDENLY BREAKS OUT,YOUR DOOR OPENS UP GIVING YOU A CHANCE TO ESCAPE.");
    start.addAction(upActionString);
    //
    Room room01 = new Room(new Position(0, 1));
    room01.setDescription("You enter a hallway.");
    room01.addAction(rightActionString);
    //
    Room room11 = new Room(new Position(1, 1));
    room11.setDescription("You find two rooms.");
    room11.addAction(upActionString);
    room11.addAction(downActionString);
    room11.addAction(leftActionString);
    room11.addAction(rightActionString);
    //
    Room room10 = new Room(new Position(1, 0));
    room10.setItem(new Shiv());
    room10.addAction(pickActionString);
    room10.addAction(upActionString);
    //
    Room room12 = new Room(new Position(1, 2));
    room12.setEnemy(new PrisonInmate());
    room12.addAction(attackActionString);
    room12.addAction(downActionString);
    //
    Room room21 = new Room(new Position(2, 1));
    room21.setDescription("The exit to the hallway is not far away");
    room21.addAction(rightActionString);
    room21.addAction(leftActionString);
    //
    Room room31 = new Room(new Position(3, 1));
    room31.setDescription("You find the exit to the hallway,attached to it a warning sign,perhaps an omen of whats to come.");
    room31.addAction(rightActionString);
    room31.addAction(leftActionString);
    //
    Room room41 = new Room(new Position(4, 1));
    room41.setEnemy(new Guard());
    room41.addAction(attackActionString);
    room41.addAction(upActionString);
    room41.addAction(downActionString);
    room41.addAction(leftActionString);
    room41.addAction(rightActionString);
    //
    Room room51 = new Room(new Position(5, 1));
    room51.setDescription("You find entrances to two rooms.");
    room51.addAction(rightActionString);
    room51.addAction(downActionString);
    room51.addAction(leftActionString);
    //
    Room room50 = new Room(new Position(5, 0));
    room50.setDescription("You enter an empty room and find the words HELP smeared with blood on the wall.");
    room50.addAction(upActionString);
    //
    Room room61 = new Room(new Position(6, 1));
    room61.addAction(attackActionString);
    room61.addAction(leftActionString);
    room61.addAction(rightActionString);
    room61.setEnemy(new SeniorGuard());
    //
    Room room71 = new Room(new Position(7, 1));
    room71.setDescription("You enter a room with a grotesque and pungent smell,and hear a disturbing noise.");
    room71.addAction(upActionString);
    room71.addAction(downActionString);
    room71.addAction(leftActionString);
    room71.addAction(rightActionString);
    //
    Room room70 = new Room(new Position(7, 0));
    room70.setItem(new MedKit());
    room70.addAction(upActionString);
    room70.addAction(healActionString);
    //
    Room room72 = new Room(new Position(7, 2));
    room72.setDescription("You find a pile of corpses.Who could have done this?");
    room72.addAction(downActionString);
    //
    Room room81 = new Room(new Position(8, 1));
    room81.addAction(leftActionString);
    room81.addAction(attackActionString);
    room81.setEnemy(new PsychoKiller());
    //
    Room room42 = new Room(new Position(4, 2));
    room42.setDescription("You enter narrow passage.You have to move up to continue down the passageway.");
    room42.addAction(upActionString);
    room42.addAction(downActionString);
    //
    Room room43 = new Room(new Position(4, 3));
    room43.setDescription("You find two doors.");
    room43.addAction(upActionString);
    room43.addAction(downActionString);
    room43.addAction(leftActionString);
    room43.addAction(rightActionString);
    //
    Room room33 = new Room(new Position(3, 3));
    room33.addAction(rightActionString);
    //
    Room room53 = new Room(new Position(5, 3));
    room53.addAction(leftActionString);
    room53.addAction(attackActionString);
    room53.setEnemy(new GangLeader());
    //
    Room room44 = new Room(new Position(4, 4));
    room44.setDescription("You proceed through the passage-way");
    room44.addAction(upActionString);
    room44.addAction(downActionString);
    //
    Room room45 = new Room(new Position(4, 5));
    room45.setDescription("You find a door in front of you,perhaps it might be more effective to continue through the passageway.");
    room45.addAction(downActionString);
    room45.addAction(upActionString);
    room45.addAction(rightActionString);
    //
    Room room55 = new Room(new Position(5, 5));
    room55.addAction(pickActionString);
    room55.addAction(leftActionString);
    room55.setItem(new HandGun());
    //
    Room room46 = new Room(new Position(4, 6));
    room46.setDescription("The end of the passageway is almost near,but you find alternative paths.Be careful in deciding your next move.");
    room46.addAction(leftActionString);
    room46.addAction(rightActionString);
    room46.addAction(upActionString);
    room46.addAction(downActionString);
    //
    Room room47 = new Room(new Position(4, 7));
    room47.setDescription("You have come to the end of the passageway,finding two alternative paths to take.");
    room47.addAction(leftActionString);
    room47.addAction(rightActionString);
    room47.addAction(downActionString);
    //
    Room room37 = new Room(new Position(3, 7));
    room37.setDescription("You enter a dark room");
    room37.addAction(rightActionString);
    room37.addAction(leftActionString);
    //
    Room room27 = new Room(new Position(2, 7));
    room27.addAction(rightActionString);
    room27.addAction(leftActionString);
    room27.addAction(pickActionString);
    room27.setItem(new Shotgun());
    //
    Room room17 = new Room(new Position(1, 7));
    room17.addAction(attackActionString);
    room17.addAction(rightActionString);
    room17.setEnemy(new DrugDealer());
    //
    Room room57 = new Room(new Position(5, 7));
    room57.setDescription("You enter a bright room");
    room57.addAction(rightActionString);
    room57.addAction(leftActionString);
    //
    Room room67 = new Room(new Position(6, 7));
    room67.setDescription("You enter another bright room with exit signs.");
    room67.addAction(rightActionString);
    room67.addAction(leftActionString);
    //
    Room room77 = new Room(new Position(7, 7));
    room77.setDescription("You see the exit to the prison.");
    room77.addAction(rightActionString);
    room77.addAction(leftActionString);
    //
    Room room87 = new Room(new Position(8, 7));
    room87.setDescription("Congratulations,you have escaped.");
    //
    Room room36 = new Room(new Position(3, 6));
    room36.addAction(leftActionString);
    room36.addAction(rightActionString);
    //
    Room room26 = new Room(new Position(2, 6));
    room26.addAction(rightActionString);
    room26.addAction(leftActionString);
    //
    Room room56 = new Room(new Position(5, 6));
    room56.addAction(rightActionString);
    room56.addAction(leftActionString);
    //
    Room room66 = new Room(new Position(6, 6));
    room66.addAction(rightActionString);
    room66.addAction(leftActionString);
    //
    Room room76 = new Room(new Position(7, 6));
    room76.addAction(healActionString);
    room76.addAction(leftActionString);
    room76.setItem(new MedKit());
    //
    Room room40 = new Room(new Position(4, 0));
    room40.addAction(healActionString);
    room40.addAction(upActionString);
    room40.setItem(new MedKit());
    //
    Room room16 = new Room(new Position(1, 6));
    room16.addAction(rightActionString);
    room16.addAction(attackActionString);
    room16.setEnemy(new DrugDealer());

    //Finishing
    WORLD.addRoom(start);
    WORLD.addRoom(room01);
    WORLD.addRoom(room10);
    WORLD.addRoom(room11);
    WORLD.addRoom(room12);
    WORLD.addRoom(room17);
    WORLD.addRoom(room16);
    WORLD.addRoom(room21);
    WORLD.addRoom(room27);
    WORLD.addRoom(room31);
    WORLD.addRoom(room33);
    WORLD.addRoom(room37);
    WORLD.addRoom(room41);
    WORLD.addRoom(room42);
    WORLD.addRoom(room43);
    WORLD.addRoom(room44);
    WORLD.addRoom(room45);
    WORLD.addRoom(room46);
    WORLD.addRoom(room47);
    WORLD.addRoom(room50);
    WORLD.addRoom(room51);
    WORLD.addRoom(room53);
    WORLD.addRoom(room55);
    WORLD.addRoom(room57);
    WORLD.addRoom(room61);
    WORLD.addRoom(room70);
    WORLD.addRoom(room71);
    WORLD.addRoom(room72);
    WORLD.addRoom(room77);
    WORLD.addRoom(room81);
    WORLD.addRoom(room87);
    WORLD.addRoom(room36);
    WORLD.addRoom(room26);
    WORLD.addRoom(room56);
    WORLD.addRoom(room66);
    WORLD.addRoom(room76);
    WORLD.addRoom(room40);
    WORLD.addRoom(room77);
    WORLD.addRoom(room67);
    WORLD.setEscape(new Position(8, 7));
    HANDLER.genericOutput();
  }

  @Override
  public void tick() {
    if (WORLD.caged()) {
      HANDLER.handleInput(getScanner().next());
    } else {
      LOGGER.info("Thanks for playing...");
      endGame();
    }
  }

}
