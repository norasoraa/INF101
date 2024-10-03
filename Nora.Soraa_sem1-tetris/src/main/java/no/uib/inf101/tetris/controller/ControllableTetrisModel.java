package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.GameState;

/**
 * The TetrisController depends on access to the model. To encapsulate our
 * model as much as possible, we use this interface that describes which methods
 * the controller needs access to. Then we let the model TetrisModel implement this
 * interface. The TetrisController will thus never know that it is (actually)
 * working with a TetrisModel, it only knows that it is a
 * ControllableTetrisModel.
 */
public interface ControllableTetrisModel {

  /**
   * A method used for moving the tetromino around on the board.
   * 
   * @param deltaRow the number of rows to move the tetromino
   * @param deltaCol the number of cols to move the tetromino
   * @return {@code true} if the tetromino was moved, {@code false} otherwise
   */
  boolean moveTetromino(int deltaRow, int deltaCol);

  /**
   * A method used for rotating the tetromino. The tetromino rotates in a
   * counter-clockwise direction, by pressing the arrow-up key.
   * 
   * @return {@code true} if the tetromino was rotated, {@code false} otherwise
   */
  boolean rotateTetromino();

  /**
   * A method used for dropping the tetromino, then glues it to the board before
   * it gets a new falling tetromino. You drop the tetromino by pressing space.
   */
  void dropTetromino();

  /**
   * The state that the game is in.
   * 
   * @return a {@link GameState}-object representing the state of the game, for
   *         example 'GAME_OVER'
   */
  GameState getGameState();

  /**
   * A method that retrieves how many milliseconds there should be between each
   * time the clock strikes. A return value of 1000 will mean 1 second between
   * each time the tetromino falls.
   * 
   * @return {@code int} reprenting the number of milliseconds
   */
  int getTimerDelay();

  /**
   * A method that is called each time the clock strikes. This method should move
   * the falling tetromino down the board.
   */
  void clockTick();
}
