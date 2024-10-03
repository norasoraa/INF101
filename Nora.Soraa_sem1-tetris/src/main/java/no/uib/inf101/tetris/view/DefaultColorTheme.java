package no.uib.inf101.tetris.view;

import java.awt.Color;

/**
 * Class that contains methods for extracting the colors used in
 * {@link TetrisView} to draw the game.
 */
public class DefaultColorTheme implements ColorTheme {

  @Override
  public Color getCellColor(Character c) {
    Color color = switch (c) {
      case 'L' -> Color.RED;
      case 'J' -> Color.GREEN;
      case 'S' -> Color.BLUE;
      case 'Z' -> Color.PINK;
      case 'T' -> Color.YELLOW;
      case 'I' -> Color.CYAN;
      case 'O' -> Color.MAGENTA;
      case '-' -> Color.BLACK;
      default -> throw new IllegalArgumentException("No available color for '" + c + "'");
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
  public Color getGameOverScreenColor() {
    return new Color(0, 0, 0, 128);
  }

  @Override
  public Color getGameOverStringColor() {
    return Color.WHITE;
  }

}
