package no.uib.inf101.pacman.model.entities;

import java.util.Objects;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.view.ViewableEntity;

/** Class that represents an entity */
public abstract class Entity implements ViewableEntity {

  private CellPosition pos;
  private Character symbol;
  private Direction direction;

  /**
   * Constructs an entity with the given position, symbol and direction.
   * 
   * @param pos       the position of the entity, represented as a
   *                  {@link CellPosition}
   * @param symbol    the symbol of the entity
   * @param direction the direction of the entity, represented as
   *                  {@link Direction}
   */
  protected Entity(CellPosition pos, Character symbol, Direction direction) {
    this.pos = pos;
    this.symbol = symbol;
    this.direction = direction;
  }

  @Override
  public CellPosition getPos() {
    return pos;
  }

  @Override
  public Character getSymbol() {
    return symbol;
  }

  @Override
  public Direction getDirection() {
    return direction;
  }

  /**
   * A method that has two int parameters that indicate how far the entity should
   * be moved in relation to the current location. To actually move the entity,
   * you should call this method and update the position with the return value.
   * 
   * @param deltaRow the number of rows you want to move the entity
   * @param deltaCol the number of columns you want to move the entity
   * @return the new updated position, represented as a {@link CellPosition}
   */
  protected CellPosition shiftedBy(int deltaRow, int deltaCol) {
    CellPosition newPos = new CellPosition(pos.row() + deltaRow, pos.col() + deltaCol);
    return newPos;
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, pos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Entity other = (Entity) obj;
    if (symbol != other.symbol)
      return false;
    if (pos == null) {
      if (other.pos != null)
        return false;
    } else if (!pos.equals(other.pos))
      return false;
    return true;
  }
}
