package no.uib.inf101.pacman.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;

public class GhostTest {

  @Test
  void testHashCodeAndEquals() {
    Ghost g1 = new Ghost(new CellPosition(0, 0), Direction.DOWN);
    Ghost g2 = new Ghost(new CellPosition(0, 0), Direction.DOWN);
    Ghost g3 = new Ghost(new CellPosition(0, 0), Direction.DOWN).moveInDirection(Direction.RIGHT);
    Ghost g4 = new Ghost(new CellPosition(5, 5), Direction.DOWN);

    assertEquals(g1, g2);
    assertEquals(g1.hashCode(), g2.hashCode());
    assertNotEquals(g1, g3);
    assertNotEquals(g1, g4);
  }

  @Test
  public void twoEqualMovesEqualsTwiceAsFar() {
    Ghost ghost = new Ghost(new CellPosition(0, 0), Direction.LEFT);

    // Moves ghost 1 time down
    ghost = ghost.moveInDirection(Direction.RIGHT);

    CellPosition posAfter1Move = ghost.getPos();

    // Calculate the expected pos after 2 equal moves
    CellPosition expectedPosAfter2EqualMoves = new CellPosition(posAfter1Move.row() * 2, posAfter1Move.col() * 2);

    // Moves ghost down again
    ghost = ghost.moveInDirection(Direction.RIGHT);

    CellPosition posAfter2Move = ghost.getPos();

    assertEquals(expectedPosAfter2EqualMoves, posAfter2Move);
  }

  @Test
  public void moveInNewDirectionChangesDirection() {
    Direction initialDirection = Direction.LEFT;
    Ghost ghost = new Ghost(new CellPosition(7, 3), initialDirection);

    ghost = ghost.moveInDirection(Direction.RIGHT);

    assertNotEquals(initialDirection, ghost.getDirection());
  }

  @Test
  public void moveChangesPos() {
    CellPosition initialPos = new CellPosition(15, 4);
    Ghost ghost = new Ghost(initialPos, Direction.LEFT);

    ghost = ghost.moveInDirection(Direction.UP);

    assertNotEquals(initialPos, ghost.getPos());
  }

  @Test
  public void moveInDirectionThrows() {
    Ghost ghost = new Ghost(new CellPosition(2, 2), Direction.UP);
    assertThrows(IllegalArgumentException.class, () -> ghost.moveInDirection(Direction.valueOf("\n")));
  }
}
