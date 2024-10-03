package no.uib.inf101.pacman.model.entities;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.utilities.Constants;

/**
 * Class that represents a pacman in the game. Any object that is an instance of
 * this class is an {@link Entity}-object.
 */
public class PacMan extends Entity {

  private int healthPoints;

  /**
   * Constructs a pacman with the given position, direction and health points.
   * 
   * @param pos the position of the pacman, represented as a {@link CellPosition}
   * @param direction the direction of the pacman, represented by {@link Direction}
   * @param healthPoints {@code int} that represents the health points of the pacman
   */
  public PacMan(CellPosition pos, Direction direction, int healthPoints) {
    super(pos, Constants.PACMAN, direction);
    this.healthPoints = healthPoints;
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
  public PacMan moveInDirection(Direction direction) {
    CellPosition newPos = switch (direction) {
    case DOWN -> shiftedBy(1, 0);
    case UP -> shiftedBy(-1, 0);
    case LEFT -> shiftedBy(0, -1);
    case RIGHT -> shiftedBy(0, 1);
    default -> throw new IllegalArgumentException("No direction with the name: " + direction);
    };
    return new PacMan(newPos, direction, healthPoints);
  }

  /** Gets the current health points of the pacman */
  public int getHealthPoints() {
    return healthPoints;
  }

  /**
   * Reduces the number of health points. Called every time the pacman should take
   * damage.
   */
  public void damage() {
    healthPoints--;
  }

}
