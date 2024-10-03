package no.uib.inf101.tetris.view;

import java.awt.Color;

/**
 * A color theme is the part of the program that translates information in the
 * model into a color that is displayed to the user. We use this interface to
 * make it easy to switch color themes.
 */
public interface ColorTheme {

  /**
   * A method that gets the color of the cell. This color can not be null.
   * 
   * @param c the element in the cell
   * @return the color of the cell
   */
  Color getCellColor(Character c);

  /**
   * A method that gets the color of the frame. This color should not be null, but
   * it is possible to use a completely transparent color (new Color(0, 0, 0, 0))
   * if you do not want to have a separate frame around the cells.
   * 
   * @return the color of the frame
   */
  Color getFrameColor();

  /**
   * A method that gets the color of the background. This color cannot be
   * transparent, but it can be null if you want to use the default background
   * color from Java.
   * 
   * @return the color of the background
   */
  Color getBackgroundColor();

  /**
   * A method that gets the color of the cell that covers the entire screen when
   * the state of the game is GAME_OVER. This cell could have a transparent color;
   * Color(0, 0, 0, 128).
   * 
   * @return the color of the cell over the board
   */
  Color getGameOverScreenColor();

  /**
   * A method that gets the color of the string which says "GAME OVER" on the
   * screen, when the state of the game is GAME_OVER.
   * 
   * @return the color of the string
   */
  Color getGameOverStringColor();

}
