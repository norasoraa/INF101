package no.uib.inf101.pacman.view;

import javax.swing.JPanel;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.pacman.model.GameState;
import no.uib.inf101.pacman.utilities.Constants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * This class is responsible for drawing the PacMan-model. PacManView first
 * draws the PacMan board, and then draws the entities "over" the board.
 */
public class PacManView extends JPanel {

  private static final int MARGIN = 15;
  private static final int CELLMARGIN = 0;
  private static final int PREFERRED_SIDE_SIZE = 30;
  private static final int SPACE_FOR_INFO = 300;
  private static final Font POPUP_FONT = new Font("Monospaced", Font.BOLD, 50);

  private ViewablePacManModel model;
  private ColorTheme colorTheme;

  /**
   * Constructor that initializes the model, sets the colortheme, sets the
   * preffered size of the window and the color of the background.
   * 
   * @param viewablePacManModel the model to be drawn, represented as a
   *                            {@link ViewablePacManModel}
   */
  public PacManView(ViewablePacManModel viewablePacManModel) {
    this.model = viewablePacManModel;

    this.colorTheme = new DefaultColorTheme();
    this.setBackground(colorTheme.getBackgroundColor());

    this.setPreferredSize(getDefaultSize(viewablePacManModel.getDimension()));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

  private void drawGame(Graphics2D g2) {
    double width = this.getWidth() - (2 * MARGIN + SPACE_FOR_INFO);
    double height = this.getHeight() - 2 * MARGIN;
    Rectangle2D box = new Rectangle2D.Double(MARGIN, MARGIN, width, height);
    g2.setColor(colorTheme.getBackgroundColor());
    g2.fill(box);

    CellPositionToPixelConverter converter = new CellPositionToPixelConverter(box, model.getDimension(), CELLMARGIN);

    drawCells(g2, model.getTilesOnBoard(), converter, colorTheme);
    if (model.getHealthPoints() > 0) {
      drawEntity(g2, converter, colorTheme, model.getPacMan());
    }
    for (ViewableEntity ghost : model.getGhosts()) {
      drawEntity(g2, converter, colorTheme, ghost);
    }

    drawInfo(g2, box);

    if (model.getGameState() == GameState.START_GAME) {
      drawStartScreen(g2);
    } else if (model.getGameState() == GameState.GAME_OVER) {
      drawGameOver(g2);
    } else if (model.getGameState() == GameState.LEVEL_FINISHED) {
      drawLevelFinished(g2);
    }
  }

  private void drawInfo(Graphics2D g2, Rectangle2D box) {
    Rectangle2D infoBox = new Rectangle2D.Double(box.getMaxX(), MARGIN, this.getWidth() - box.getMaxX(),
        box.getHeight());
    g2.setColor(getBackground());
    g2.fill(infoBox);

    g2.setColor(colorTheme.getGameInfoColor());

    String healthPointsString = "HEALTH POINTS: " + Integer.toString(model.getHealthPoints());
    Inf101Graphics.drawCenteredString(g2, healthPointsString,
        new Point.Double(infoBox.getCenterX(), infoBox.getCenterY() - 50));

    String scoreString = "SCORE: " + Integer.toString(model.getScore());
    Inf101Graphics.drawCenteredString(g2, scoreString,
        new Point.Double(infoBox.getCenterX(), infoBox.getCenterY() + 50));
  }

  private void drawStartScreen(Graphics2D g2) {
    Rectangle2D box = new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight());
    g2.setColor(colorTheme.getPopUpColor());
    g2.fill(box);

    g2.setColor(colorTheme.getPopUpTextColor());
    g2.setFont(POPUP_FONT);
    Inf101Graphics.drawCenteredString(g2, "Press SPACE to start", box);
  }

  private void drawGameOver(Graphics2D g2) {
    Rectangle2D box = new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight());
    g2.setColor(colorTheme.getPopUpColor());
    g2.fill(box);

    g2.setColor(colorTheme.getPopUpTextColor());
    g2.setFont(POPUP_FONT);
    Inf101Graphics.drawCenteredString(g2, "GAME OVER", getBounds());
  }

  private void drawLevelFinished(Graphics2D g2) {
    Rectangle2D box = new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight());
    g2.setColor(colorTheme.getPopUpColor());
    g2.fill(box);

    g2.setColor(colorTheme.getPopUpTextColor());
    g2.setFont(POPUP_FONT);
    Inf101Graphics.drawCenteredString(g2, "YOU WON!", getBounds());
  }

  private static void drawCells(Graphics2D g2, Iterable<GridCell<Character>> cells,
      CellPositionToPixelConverter converter, ColorTheme colorTheme) {
    for (GridCell<Character> cell : cells) {
      Rectangle2D rectangle = converter.getBoundsForCell(cell.pos());
      g2.setColor(colorTheme.getCellColor(cell.value()));
      g2.fill(rectangle);
      if (cell.value() == Constants.DOT) {
        scaleAndDrawImage(g2, colorTheme.getDotImage(), rectangle, colorTheme);
      }
    }
  }

  private static void drawEntity(Graphics2D g2, CellPositionToPixelConverter converter, ColorTheme colorTheme,
      ViewableEntity entity) {
    Rectangle2D tile = converter.getBoundsForCell(entity.getPos());
    scaleAndDrawImage(g2, colorTheme.getEntityImage(entity.getSymbol(), entity.getDirection()), tile, colorTheme);
  }

  private static void scaleAndDrawImage(Graphics2D g2, BufferedImage cellImage, Rectangle2D tile,
      ColorTheme colorTheme) {
    g2.setColor(colorTheme.getFrameColor());
    Image scaledImage = cellImage.getScaledInstance((int) tile.getWidth(), (int) tile.getHeight(), Image.SCALE_DEFAULT);
    Inf101Graphics.drawCenteredImage(g2, scaledImage, tile.getCenterX(), tile.getCenterY(), 1.0);
    g2.fill(tile);
  }

  private static Dimension getDefaultSize(GridDimension gd) {
    int width = (int) (PREFERRED_SIDE_SIZE * gd.cols() + CELLMARGIN * (gd.cols() + 1) + 2 * MARGIN + SPACE_FOR_INFO);
    int height = (int) (PREFERRED_SIDE_SIZE * gd.rows() + CELLMARGIN * (gd.cols() + 1) + 2 * MARGIN);
    return new Dimension(width, height);
  }

}
