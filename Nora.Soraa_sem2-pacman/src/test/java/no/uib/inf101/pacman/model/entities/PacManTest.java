package no.uib.inf101.pacman.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.Direction;

public class PacManTest {

  @Test
  public void testHashCodeAndEquals() {
    PacMan p1 = new PacMan(new CellPosition(0, 0), Direction.DOWN, 3);
    PacMan p2 = new PacMan(new CellPosition(0, 0), Direction.DOWN, 3);
    PacMan p3 = new PacMan(new CellPosition(0, 0), Direction.DOWN, 3).moveInDirection(Direction.RIGHT);
    PacMan p4 = new PacMan(new CellPosition(5, 5), Direction.DOWN, 3);

    assertEquals(p1, p2);
    assertEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1, p3);
    assertNotEquals(p1, p4);
  }

  @Test
  public void testDamage() {
    int hp = 5;
    PacMan pacMan = new PacMan(new CellPosition(0, 0), Direction.LEFT, hp);

    pacMan.damage();

    int actualHP = pacMan.getHealthPoints();

    // Check that pacman lost 1 health point
    assertEquals(hp - 1, actualHP);
  }

  @Test
  public void twoEqualMovesEqualsTwiceAsFar() {
    PacMan pacMan = new PacMan(new CellPosition(0, 0), Direction.DOWN, 3);

    // Moves pacman 1 time down
    pacMan = pacMan.moveInDirection(Direction.DOWN);

    CellPosition posAfter1Move = pacMan.getPos();

    // Calculate the expected pos after 2 equal moves
    CellPosition expectedPosAfter2EqualMoves = new CellPosition(posAfter1Move.row() * 2, posAfter1Move.col() * 2);

    // Moves pacman down again
    pacMan = pacMan.moveInDirection(Direction.DOWN);

    CellPosition posAfter2Move = pacMan.getPos();

    assertEquals(expectedPosAfter2EqualMoves, posAfter2Move);
  }

  @Test
  public void moveInNewDirectionChangesDirection() {
    Direction initialDirection = Direction.LEFT;
    PacMan pacMan = new PacMan(new CellPosition(10, 15), initialDirection, 1);

    pacMan = pacMan.moveInDirection(Direction.RIGHT);

    assertNotEquals(initialDirection, pacMan.getDirection());
  }

  @Test
  public void moveChangesPos() {
    CellPosition initialPos = new CellPosition(15, 4);
    PacMan pacMan = new PacMan(initialPos, Direction.LEFT, 1);

    pacMan = pacMan.moveInDirection(Direction.UP);

    assertNotEquals(initialPos, pacMan.getPos());
  }

  @Test
  public void moveInDirectionThrows() {
    PacMan pacMan = new PacMan(new CellPosition(5, 5), Direction.UP, 1);
    assertThrows(IllegalArgumentException.class, () -> pacMan.moveInDirection(Direction.valueOf("\n")));
  }
}
