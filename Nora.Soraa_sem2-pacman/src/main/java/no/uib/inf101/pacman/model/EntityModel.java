package no.uib.inf101.pacman.model;

import no.uib.inf101.grid.GridCell;

/**
 * Interface used to encapsulate the PacManModel. The entities will use this
 * interface that describes which methods the entities need access to from the
 * model.
 */
public interface EntityModel {

  /** Returns a new random direction for each call */
  Direction newRandomDirection();

  /**
   * A method that returns an object that, when iterated over, returns all the
   * positions on the board with their associated symbols.
   * 
   * @return an {@code Iterable<GridCell<Character>>} that iterates over all the
   *         tiles on the board
   */
  Iterable<GridCell<Character>> getTilesOnBoard();

}
