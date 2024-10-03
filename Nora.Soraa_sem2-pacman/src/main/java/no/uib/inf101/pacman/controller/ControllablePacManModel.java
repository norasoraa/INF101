package no.uib.inf101.pacman.controller;

import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.model.GameState;

/**
 * The PacManController depends on access to the model. To encapsulate our model
 * as much as possible, we use this interface that describes which methods the
 * controller needs access to. Then we let the model PacManModel implement this
 * interface. The PacManController will thus never know that it is (actually)
 * working with a PacManModel, it only knows that it is a
 * ControllablePacManModel.
 */
public interface ControllablePacManModel {

  /**
   * A method used for moving the pacman around on the board.
   * 
   * @param direction the direction to move in, represented as a {@link Direction}
   * @return {@code true} if the pacman was moved, {@code false} otherwise
   */
  boolean movePacMan(Direction direction);

  /**
   * A method that is called each time the clock strikes. This method should move
   * the pacman and ghosts around on the board.
   */
  void clockTick();

  /**
   * A method that retrieves how many milliseconds there should be between each
   * time the clock strikes. A return value of 1000 will mean 1 second between
   * each time the ghosts move.
   * 
   * @return {@code int} reprenting the number of milliseconds
   */
  int getTimerDelay();

  /**
   * The state that the game is in.
   * 
   * @return a {@link GameState}-object representing the state of the game, for
   *         example 'GAME_OVER'
   */
  GameState getGameState();

  /**
   * A method used to change the state of the game.
   * 
   * @param newGameState the new state of the game, represented by
   *                     {@link GameState}
   */
  void setGameState(GameState newGameState);
}
