package no.uib.inf101.tetris.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.GameState;

/**
 * The TetrisView needs to have access to the model in order to draw it, but we
 * want to not be able to unexpectedly change the model when we do things in
 * TetrisView. To encapsulate our model, we use this interface that describes
 * which methods TetrisView needs to draw a Tetris board. Then we let the model
 * TetrisModel implement this interface. TetrisView will thus never know that it
 * is (actually) working with a TetrisModel, it only knows that it is a
 * ViewableTetrisModel.
 */
public interface ViewableTetrisModel {

  /** A method that returns a {@link GridDimension}-object. */
  GridDimension getDimension();

  /**
   * A method that returns an object that, when iterated over, returns all the
   * positions on the board with their associated symbols.
   * 
   * @return an {@code Iterable<GridCell<Character>>} that iterates over all the
   *         tiles on the board
   */
  Iterable<GridCell<Character>> getTilesOnBoard();

  /**
   * A method that returns an object that, when iterated over, returns all the
   * positions on the tetromino with their associated symbols.
   * 
   * @return an {@code Iterable<GridCell<Character>>} that iterates over all the
   *         tiles on the tetromino
   */
  Iterable<GridCell<Character>> fallingTetromino();

  /**
   * The state that the game is in.
   * 
   * @return a {@link GameState}-object representing the state of the game, for
   *         example 'GAME_OVER'
   */
  GameState getGameState();
}
