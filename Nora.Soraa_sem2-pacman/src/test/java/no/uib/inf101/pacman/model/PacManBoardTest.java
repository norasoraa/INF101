package no.uib.inf101.pacman.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.model.entities.Ghost;
import no.uib.inf101.pacman.model.entities.PacMan;

public class PacManBoardTest {

  @Test
  public void testPrettyString() throws IOException {
    PacManBoard board = new PacManBoard(3, 4, "emptyBoard.txt");
    board.set(new CellPosition(0, 0), 'L');
    board.set(new CellPosition(0, 3), 'S');
    board.set(new CellPosition(2, 0), 'Z');
    board.set(new CellPosition(2, 3), 'O');
    String expected = String.join("\n", new String[] { "L**S", "****", "Z**O" });
    assertEquals(expected, board.prettyString());
  }

  @Test
  void testGetGhosts() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    List<Ghost> expectedGhosts = new ArrayList<>();
    expectedGhosts.add(new Ghost(new CellPosition(2, 7), Direction.UP));
    expectedGhosts.add(new Ghost(new CellPosition(6, 3), Direction.UP));

    List<Ghost> actualGhosts = board.getGhosts();
    
    assertEquals(expectedGhosts, actualGhosts);
  }

  @Test
  void testGetPacMan() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");

    PacMan pacman = board.getPacMan();
    
    assertEquals(new CellPosition(2, 8), pacman.getPos());
  }

}
