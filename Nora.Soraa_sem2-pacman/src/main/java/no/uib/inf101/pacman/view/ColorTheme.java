package no.uib.inf101.pacman.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

import no.uib.inf101.pacman.model.Direction;

/**
 * A color theme is the part of the program that translates information in the
 * model into a color or image that is displayed to the user. We use this
 * interface to make it easy to switch color themes.
 */
public interface ColorTheme {

  /**
   * Gets the image of a given character that represents an entity. The image
   * depends on the current direction of the entity.
   *
   * @param entitySymbol    the symbol of the entity to find the image of
   * @param entityDirection the direction of the entity, needed for getting the
   *                        right image for each direction
   * @return an image, represented as {@link BufferedImage}
   */
  BufferedImage getEntityImage(Character entitySymbol, Direction entityDirection);

  /**
   * Gets the image for all the dots (pacmans food) on the board.
   * 
   * @return an image, represented as {@link BufferedImage}
   */
  BufferedImage getDotImage();

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
   * A method that gets the color of the cell that covers the entire screen in pop
   * up. This cell could have a transparent color; Color(0, 0, 0, 128).
   * 
   * @return the color of the cell over the board
   */
  Color getPopUpColor();

  /**
   * A method that gets the color of the strings in pop up.
   * 
   * @return the color of the string
   */
  Color getPopUpTextColor();

  /**
   * The color of the game info text
   * 
   * @return a color
   */
  Color getGameInfoColor();

}
