package optic_fusion1.prisonescape.component.entity.impl;

import java.util.Objects;
import optic_fusion1.prisonescape.component.entity.Entity;
import optic_fusion1.prisonescape.component.weapon.impl.Knuckles;
import optic_fusion1.prisonescape.util.Position;

public class Player extends Entity {

  private Position position = new Position(0, 0); //Current position of the player in a World object.
  private int score = 0; //Score the player has attained by defeating/killing enemies in the game.

  public Player() {
    super("Player", 200, new Knuckles(), 8);
  }

  public Player(Position position) {
    this();
    this.position = position;
  }

  //Getter Function/Acessor Methods.
  public Position getPosition() {
    return position;
  }

  public int getScore() {
    return score;
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
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Player player = (Player) other;
    if (!super.equals(player)) {
      return false;
    }
    return this.position.equals(player.getPosition()) && (this.score == player.getScore());
  }

  @Override
  public int hashCode() {
    return (super.hashCode() * 31) + Objects.hash(this.position, this.score);
  }
}
