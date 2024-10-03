package no.uib.inf101.pacman.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

import no.uib.inf101.pacman.model.Direction;
import no.uib.inf101.pacman.utilities.Constants;

/**
 * Class that contains methods for extracting the colors and images used in
 * {@link PacManView} to draw the game.
 */
public class DefaultColorTheme implements ColorTheme {

  @Override
  public BufferedImage getEntityImage(Character entitySymbol, Direction entityDirection) {
    String filename = "images/";
    switch (entitySymbol) {
    case Constants.GHOST:
      switch (entityDirection) {
      case LEFT -> filename += "ghostLeft.png";
      case RIGHT -> filename += "ghostRight.png";
      case DOWN -> filename += "ghostDown.png";
      case UP -> filename += "ghostUp.png";
      }
      break;
    case Constants.PACMAN:
      switch (entityDirection) {
      case LEFT -> filename += "pacManLeft.png";
      case RIGHT -> filename += "pacManRight.png";
      case DOWN -> filename += "pacManDown.png";
      case UP -> filename += "pacManUp.png";
      }
      break;
    default:
      throw new IllegalArgumentException("No available image for '" + entitySymbol + "'");
    }
    return getImage(filename);
  }

  @Override
  public BufferedImage getDotImage() {
    return getImage("images/dot.png");
  }

  private BufferedImage getImage(String filename) {
    return Inf101Graphics.loadImageFromResources(filename);
  }

  @Override
  public Color getCellColor(Character c) {
    Color color = switch (c) {
      case Constants.WALL -> Color.BLUE;
      default -> Color.BLACK;
    };
    return color;
  }

  @Override
  public Color getFrameColor() {
    return new Color(0, 0, 0, 0);
  }

  @Override
  public Color getBackgroundColor() {
    return null;
  }

  @Override
  public Color getPopUpColor() {
    return new Color(0, 0, 0, 128);
  }

  @Override
  public Color getPopUpTextColor() {
    return Color.WHITE;
  }

  @Override
  public Color getGameInfoColor() {
    return Color.BLACK;
  }

}
