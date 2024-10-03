package no.uib.inf101.pacman.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.pacman.controller.ControllablePacManModel;
import no.uib.inf101.pacman.model.entities.Ghost;
import no.uib.inf101.pacman.model.entities.GhostFactory;
import no.uib.inf101.pacman.model.entities.PacMan;
import no.uib.inf101.pacman.model.entities.RandomGhostFactory;
import no.uib.inf101.pacman.utilities.Constants;

public class PacManModelTest {

  @Test
  void testGetDimension() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    assertEquals(board, model.getDimension());
  }

  @Test
  void testGetGhosts() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    assertTrue(model.getGhosts().contains(new Ghost(new CellPosition(6, 3), Direction.UP)));
  }

  @Test
  void testGetPacMan() throws IOException {
    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    PacMan expected = new PacMan(new CellPosition(11, 0), Direction.RIGHT, Constants.DEFAULT_PACMAN_HP);

    assertEquals(expected, model.getPacMan());;
    
  }

  @Test
  void testGetScore() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    assertEquals(0, model.getScore());
  }

  @Test
  void testGetTilesOnBoard() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    assertEquals(board, model.getTilesOnBoard());
  }

  @Test
  void testGetTimerDelay() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    assertEquals(300, model.getTimerDelay());
  }


  //Tests for movePacMan()

  @Test
  void successfulMoveReturnsTrue() throws IOException {
    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    ControllablePacManModel model = new PacManModel(board, ghostFactory);

    assertTrue(model.movePacMan(Direction.RIGHT));
    assertTrue(model.movePacMan(Direction.RIGHT));
  }

  @Test
  void successfulMoveChangesPos() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    CellPosition pacMasPosBeforeMove = model.getPacMan().getPos();

    model.movePacMan(Direction.DOWN);

    CellPosition pacManPosAfterMove = model.getPacMan().getPos();

    // Check that the posistion after moving is different
    assertFalse(pacMasPosBeforeMove.equals(pacManPosAfterMove));
  }

  @Test
  public void cannotMoveOutOfBoardReturnsFalse() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    ControllablePacManModel model = new PacManModel(board, ghostFactory);

    assertFalse(model.movePacMan(Direction.RIGHT));
  }

  @Test
  public void cannotMoveOutOfBoardDoesNotChangePos() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    CellPosition pacMasPosBeforeMove = model.getPacMan().getPos();

    model.movePacMan(Direction.RIGHT);

    CellPosition pacManPosAfterFailedMove = model.getPacMan().getPos();

    assertEquals(pacMasPosBeforeMove, pacManPosAfterFailedMove);
  }

  @Test
  public void cannotMoveOnOccupiedCellReturnsFalse() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    ControllablePacManModel model = new PacManModel(board, ghostFactory);

    assertFalse(model.movePacMan(Direction.LEFT));
  }

  @Test 
  public void cannotMoveOnOccupiedCellDoesNotChangePos() throws IOException {
    PacManBoard board = new PacManBoard(10, 10, "testBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    CellPosition posBeforeMove = model.getPacMan().getPos();

    model.movePacMan(Direction.LEFT);

    CellPosition posAfterFailedMove = model.getPacMan().getPos();

    assertEquals(posBeforeMove, posAfterFailedMove);;
  }

  @Test
  public void testClockTickMovesPacMan() throws IOException {
    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    CellPosition posBeforeClockTick = model.getPacMan().getPos();

    model.clockTick();

    CellPosition posAfterClockTick = model.getPacMan().getPos();

    assertNotEquals(posBeforeClockTick, posAfterClockTick);
  }

  @Test
  public void testClockTickMovesGhosts() throws IOException {
    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    PacManModel model = new PacManModel(board, ghostFactory);

    List<CellPosition> initialGhostsPos = new ArrayList<>();

    for (int i = 0; i < model.getGhosts().size(); i++) {
      initialGhostsPos.add(model.getGhosts().get(i).getPos());
    }

    model.clockTick();

    for (int i = 0; i < model.getGhosts().size(); i++) {
      CellPosition ghostPosAfterClockTick = model.getGhosts().get(i).getPos();
      assertNotEquals(initialGhostsPos.get(i), ghostPosAfterClockTick);
    }
  }

  @Test
  public void setGameStateTest() throws IOException {
    PacManBoard board = new PacManBoard(23, 23, "pacManBoard.txt");
    GhostFactory ghostFactory = new RandomGhostFactory();
    ControllablePacManModel model = new PacManModel(board, ghostFactory);

    GameState initialGameState = model.getGameState();

    model.setGameState(GameState.LEVEL_FINISHED);

    assertNotEquals(initialGameState, model.getGameState());
  }

}
