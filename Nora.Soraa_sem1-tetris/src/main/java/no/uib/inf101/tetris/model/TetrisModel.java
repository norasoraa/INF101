package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.ControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

/** Class that represents the state of a complete game of Tetris. */
public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel {

  private TetrisBoard board;
  private TetrominoFactory tetrominoFactory;
  private Tetromino fallingTetromino;
  private GameState gameState;

  /**
   * Constructor that initializes the board, creates the falling tetromino and
   * sets the state of the game.
   * 
   * @param board            the {@link TetrisBoard} used in the game
   * @param tetrominoFactory the factory that produces the new tetrominos
   */
  public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
    this.board = board;
    this.tetrominoFactory = tetrominoFactory;
    this.fallingTetromino = this.tetrominoFactory.getNext().shiftedToTopCenterOf(this.board);
    this.gameState = GameState.ACTIVE_GAME;
  }

  @Override
  public GridDimension getDimension() {
    return board;
  }

  @Override
  public Iterable<GridCell<Character>> getTilesOnBoard() {
    return board;
  }

  @Override
  public Iterable<GridCell<Character>> fallingTetromino() {
    return fallingTetromino;
  }

  @Override
  public boolean moveTetromino(int deltaRow, int deltaCol) {
    Tetromino candidateTetromino = fallingTetromino.shiftedBy(deltaRow, deltaCol);
    if (legalPositionOfTetromino(candidateTetromino)) {
      fallingTetromino = candidateTetromino;
      return true;
    }
    return false;
  }

  private boolean legalPositionOfTetromino(Tetromino possibleTetromino) {
    for (GridCell<Character> cell : possibleTetromino) {
      if (!board.positionIsOnGrid(cell.pos())) {
        return false;
      } 
      else if (board.get(cell.pos()) != '-') {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean rotateTetromino() {
    Tetromino candidateTetromino = fallingTetromino.rotate();
    if (legalPositionOfTetromino(candidateTetromino)) {
      fallingTetromino = candidateTetromino;
      return true;
    }
    return false;
  }

  @Override
  public void dropTetromino() {
    while (legalPositionOfTetromino(fallingTetromino.shiftedBy(1, 0))) {
      moveTetromino(1, 0);
    }
    glueTetrominoToBoard();
  }

  private void newFallingTetromino() {
    fallingTetromino = tetrominoFactory.getNext().shiftedToTopCenterOf(board);
    if (!legalPositionOfTetromino(fallingTetromino)) {
      gameState = GameState.GAME_OVER;
    }
  }

  private void glueTetrominoToBoard() {
    for (GridCell<Character> tetrominoCell : fallingTetromino) {
      board.set(tetrominoCell.pos(), tetrominoCell.value());
    }
    board.removeFullRows();
    newFallingTetromino();
  }

  @Override
  public GameState getGameState() {
    return gameState;
  }

  @Override
  public int getTimerDelay() {
    return 1000;
  }

  @Override
  public void clockTick() {
    if (!moveTetromino(1, 0)) {
      glueTetrominoToBoard();
    }
  }
}
