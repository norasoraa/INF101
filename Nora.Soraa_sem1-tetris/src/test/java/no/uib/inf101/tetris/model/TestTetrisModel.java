package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.controller.ControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.PatternedTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

public class TestTetrisModel {

  @Test
  public void initialPositionOfO() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("O");
    ViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'O')));
  }

  @Test
  public void initialPositionOfI() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    ViewableTetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 6), 'I')));
  }

  @Test
  public void successfulMoveReturnsTrue() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    assertTrue(model.moveTetromino(5, 0));
  }

  @Test
  public void successfulMoveChangesPos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    TetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCellsBeforeMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeMove.add(gc);
    }

    model.moveTetromino(5, 0);

    List<GridCell<Character>> tetroCellsAfterMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeMove.add(gc);
    }

    for (GridCell<Character> tetroCell : tetroCellsBeforeMove) {
      assertFalse(tetroCellsAfterMove.contains(tetroCell));
    }

    for (GridCell<Character> tetroCellMoved : tetroCellsAfterMove) {
      assertFalse(tetroCellsBeforeMove.contains(tetroCellMoved));
    }
  }

  @Test
  public void cannotMoveOutOfBoardReturnsFalse() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    assertFalse(model.moveTetromino(5, 10));
  }

  @Test
  public void cannotMoveOutOfBoardDoesNotChangePos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("T");
    TetrisModel model = new TetrisModel(board, factory);

    List<GridCell<Character>> tetroCellsBeforeMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeMove.add(gc);
    }

    model.moveTetromino(5, 10);

    List<GridCell<Character>> tetroCellsAfterFailedMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfterFailedMove.add(gc);
    }

    assertEquals(tetroCellsBeforeMove, tetroCellsAfterFailedMove);
  }

  @Test
  public void cannotMoveOnOccupiedCellReturnsFalse() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("O");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    board.set(new CellPosition(5, 4), 'Z');

    assertFalse(model.moveTetromino(5, 0));
  }

  @Test
  public void cannotMoveOnOccupiedCellDoesNotChangePos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    TetrisModel model = new TetrisModel(board, factory);

    board.set(new CellPosition(13, 6), 'Z');

    List<GridCell<Character>> tetroCellsBeforeMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeMove.add(gc);
    }

    model.moveTetromino(13, 0);

    List<GridCell<Character>> tetroCellsAfterFailedMove = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfterFailedMove.add(gc);
    }

    assertEquals(tetroCellsBeforeMove, tetroCellsAfterFailedMove);
  }

  @Test
  public void successfulRotationReturnsTrue() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    model.moveTetromino(5, 0);
    assertTrue(model.rotateTetromino());
  }

  @Test
  public void cannotRotateOutOfBoardReturnsFalse() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    assertFalse(model.rotateTetromino());
  }

  @Test
  public void cannotRotateOutOfBoardDoesNotChangePos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    TetrisModel model = new TetrisModel(board, factory);

    model.moveTetromino(5, -3);
    model.rotateTetromino();
    model.moveTetromino(0, -1);

    List<GridCell<Character>> tetroCellsBeforeRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeRotation.add(gc);
    }

    model.rotateTetromino();

    List<GridCell<Character>> tetroCellsAfterFailedRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfterFailedRotation.add(gc);
    }

    assertEquals(tetroCellsBeforeRotation, tetroCellsAfterFailedRotation);
  }

  @Test
  public void cannotRotateOnOccupiedCellReturnsFalse() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("S");
    ControllableTetrisModel model = new TetrisModel(board, factory);

    board.set(new CellPosition(6, 5), 'T');
    model.moveTetromino(5, 0);
    
    assertFalse(model.rotateTetromino());
  }

  @Test
  public void cannotRotateOnOccupiedCellDoesNotChangePos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("S");
    TetrisModel model = new TetrisModel(board, factory);

    board.set(new CellPosition(6, 5), 'T');
    model.moveTetromino(5, 0);

    List<GridCell<Character>> tetroCellsBeforeRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeRotation.add(gc);
    }

    model.rotateTetromino();

    List<GridCell<Character>> tetroCellsAfterFailedRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfterFailedRotation.add(gc);
    }

    assertEquals(tetroCellsBeforeRotation, tetroCellsAfterFailedRotation);
  }

  @Test
  public void rotateTetrominoBackToOriginalPos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("J");
    TetrisModel model = new TetrisModel(board, factory);

    model.moveTetromino(5, 0);

    List<GridCell<Character>> tetroCellsBeforeRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeRotation.add(gc);
    }

    model.rotateTetromino();
    model.rotateTetromino();
    model.rotateTetromino();
    model.rotateTetromino();

    List<GridCell<Character>> tetroCellsAfter4Rotations = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfter4Rotations.add(gc);
    }

    assertEquals(tetroCellsBeforeRotation, tetroCellsAfter4Rotations);
  }

  @Test
  public void rotationOfODoesNotMovePos() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("O");
    TetrisModel model = new TetrisModel(board, factory);

    model.moveTetromino(5, 0);

    List<GridCell<Character>> tetroCellsBeforeRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsBeforeRotation.add(gc);
    }

    model.rotateTetromino();

    List<GridCell<Character>> tetroCellsAfterRotation = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCellsAfterRotation.add(gc);
    }

    assertEquals(tetroCellsBeforeRotation, tetroCellsAfterRotation);
  }

  @Test
  public void testDropTetromino() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    TetrisModel model = new TetrisModel(board, factory);

    model.dropTetromino();

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.getTilesOnBoard()) {
      if (gc.value() == 'I') {
        tetroCells.add(gc);
      }
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(19, 3), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(19, 4), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(19, 5), 'I')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(19, 6), 'I')));
  }

  @Test
  public void testClockTickMovesTetromino() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("Z");
    TetrisModel model = new TetrisModel(board, factory);

    model.clockTick();

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.fallingTetromino()) {
      tetroCells.add(gc);
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 3), 'Z')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'Z')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(2, 4), 'Z')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(2, 5), 'Z')));
  }

  @Test
  public void testClockTickGluesTetrominoToBoard() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("L");
    TetrisModel model = new TetrisModel(board, factory);

    model.moveTetromino(18, 0);
    model.clockTick();

    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> gc : model.getTilesOnBoard()) {
      if (gc.value() == 'L') {
        tetroCells.add(gc);
      }
    }

    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(18, 3), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(18, 4), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(18, 5), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(19, 3), 'L')));
  }

  @Test
  public void testGetGameState() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    TetrisModel model = new TetrisModel(board, factory);

    assertEquals(GameState.ACTIVE_GAME, model.getGameState());
  }

  @Test
  public void testGetTimerDelay() {
    TetrisBoard board = new TetrisBoard(20, 10);
    TetrominoFactory factory = new PatternedTetrominoFactory("I");
    TetrisModel model = new TetrisModel(board, factory);

    assertEquals(1000, model.getTimerDelay());
  }

}
