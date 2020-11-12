package optic_fusion1.prisonescape.component.item;

import java.util.Objects;

public class MedKit extends PEItem {

  private String description = "You enter a room and find a med-kit.\nYou would be foolish not to use it!";

  public MedKit() {
    super("MedKit");
  }

  @Override
  public String toString() {
    return "Item: MedKit";
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
    MedKit medKit = (MedKit) other;
    return getName().equals(medKit.getName()) && description.equals(medKit.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), description);
  }

  @Override
  public String getDescription() {
    return description;
  }

}
