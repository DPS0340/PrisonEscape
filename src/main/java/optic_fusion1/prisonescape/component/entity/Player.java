package optic_fusion1.prisonescape.component.entity;

import java.util.Objects;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;
import optic_fusion1.prisonescape.util.Position;

public class Player extends Entity {

  private Position position; //Current position of the player in a World Object.
  private int score; //Score the player has attained by defeating/killing enemies in the game.

  public Player() {
    super("Player", 200, new Knuckles(), 8);
    this.position = new Position(0, 0); //Default Position of a player.
    this.score = 0;
  }

  public Player(Position position) {
    this();
    this.setPosition(position);
  }

  //Getter Functions/Accessor Methods.
  public Position getPosition() {
    return this.position;
  }

  public int getScore() {
    return this.score;
  }

  //Setter Functions/Mutator Methods.
  public void setPosition(Position position) {
    this.position = position;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Player";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Player player = (Player) other;
    if (!super.equals(player)) {
      return false;
    }
    return position.equals(player.getPosition()) && (score == player.getScore());
  }

  @Override
  public int hashCode() {
    return (super.hashCode() * 31) + Objects.hash(position, score);
  }

}
