package no.uib.inf101.pacman.model.entities;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.utilities.Constants;

/**
 * Class that represents a ghost in the game. Any object that is an instance of
 * this class is an {@link Entity}-object.
 */
public class Ghost extends Entity {

  /**
   * Constructs a ghost with the given position and direction.
   * 
   * @param pos       the position of the ghost, represented as a
   *                  {@link CellPosition}
   * @param direction the direction of the ghost, represented as {@link Direction}
   */
  public Ghost(CellPosition pos, Direction direction) {
    super(pos, Constants.GHOST, direction);
  }

  /**
   * A method that has a direction parameter that indicates the direction in which
   * the copy should be moved. The method makes a copy of itself, except the
   * position has been moved. For each call, the copy is moved one cell in the
   * given direction.
   * 
   * @param direction the direction to move in, represented by {@link Direction}
   * @return a copy of itself with the given direction and where the position has
   *         been moved
   */
  public Ghost moveInDirection(Direction direction) {
    CellPosition newPos = switch (direction) {
    case DOWN -> shiftedBy(1, 0);
    case UP -> shiftedBy(-1, 0);
    case LEFT -> shiftedBy(0, -1);
    case RIGHT -> shiftedBy(0, 1);
    default -> throw new IllegalArgumentException("No direction with the name: " + direction);
    };
    return new Ghost(newPos, direction);
  }

}
