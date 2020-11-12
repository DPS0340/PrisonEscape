package optic_fusion1.prisonescape.component.item;

import optic_fusion1.engine.component.item.SimpleItem;

public abstract class PEItem extends SimpleItem {

  public PEItem(String displayName) {
    super(displayName);
  }

  public abstract String getDescription(); //Description that is displayed when a weapon is found.

}
