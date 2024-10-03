package no.uib.inf101.pacman.view;

import java.util.List;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.pacman.model.GameState;

/**
 * The PacManView needs to have access to the model in order to draw it, but we
 * don't want to be able to unexpectedly change the model when we do things in
 * PacManView. To encapsulate our model, we use this interface that describes
 * which methods PacManView needs to draw a PacMan board. Then we let the model
 * PacManModel implement this interface. PacManView will thus never know that it
 * is (actually) working with a PacManModel, it only knows that it is a
 * ViewablePacManModel.
 */
public interface ViewablePacManModel {

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
   * Gets the pacman-entity that currently exists on the board.
   * 
   * @return the pacman represented as a {@link ViewableEntity}
   */
  ViewableEntity getPacMan();

  /**
   * A method that returns a list of all the ghost-entities that currently exists
   * on the board.
   * 
   * @return a list containing all the ghosts as a {@link ViewableEntity}
   */
  List<? extends ViewableEntity> getGhosts();

  /** Gets the current health points of the pacman */
  int getHealthPoints();

  /** Gets the current score of the pacman */
  int getScore();

  /**
   * The state that the game is in.
   * 
   * @return a {@link GameState}-object representing the state of the game, for
   *         example 'GAME_OVER'
   */
  GameState getGameState();

}
