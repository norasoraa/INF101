package no.uib.inf101.pacman.view;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;

/**
 * Interface used to encapsulate the entities. The PacManView will use this
 * interface that describes which methods the view needs access to for being
 * able to draw the entities.
 */
public interface ViewableEntity {

  /**
   * Gets the position of an entity
   * 
   * @return the position represented as a {@link CellPosition}
   */
  CellPosition getPos();

  /** Gets the symbol of an entity */
  Character getSymbol();

  /**
   * Gets the direction of an entity
   * 
   * @return the direction represented as {@link Direction}
   */
  Direction getDirection();
}
