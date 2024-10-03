package no.uib.inf101.tetris.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.GameState;

/**
 * This class is responsible for drawing the Tetris-model. TetrisView first
 * draws the Tetris board, and then draws the falling piece "over" the board.
 */
public class TetrisView extends JPanel {

  private ViewableTetrisModel model;
  private ColorTheme colorTheme;
  private static final double MARGIN = 2;
  private static final double CELLSIZE = 40;
  private static final String GAME_OVER_STRING = "GAME OVER";
  private static final Font GAME_OVER_FONT = new Font("Arial", Font.BOLD, 40);

  /**
   * Constructor that initializes the model, sets the colortheme, sets the preffered
   * size of the window and the color of the background.
   * 
   * @param model the model to be drawn, represented as a {@link ViewableTetrisModel}
   */
  public TetrisView(ViewableTetrisModel model) {
    this.model = model;
    this.colorTheme = new DefaultColorTheme();
    int width = (int) ((CELLSIZE + MARGIN) * this.model.getDimension().cols() + MARGIN);
    int height = (int) ((CELLSIZE + MARGIN) * this.model.getDimension().rows() + MARGIN);
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(this.colorTheme.getBackgroundColor());
  }

  // The paintComponent method is called by the Java Swing framework every time
  // either the window opens or resizes, or we call .repaint() on this object.
  // Note: NEVER call paintComponent directly yourself
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);

  }

  private void drawGame(Graphics2D g2) {
    double x = MARGIN;
    double y = MARGIN;
    double width = this.getWidth() - 2 * MARGIN;
    double height = this.getHeight() - 2 * MARGIN;
    Rectangle2D box = new Rectangle2D.Double(x, y, width, height);
    g2.setColor(this.colorTheme.getFrameColor());
    g2.fill(box);
    CellPositionToPixelConverter converter = new CellPositionToPixelConverter(box, model.getDimension(), MARGIN);
    drawCells(g2, model.getTilesOnBoard(), converter, colorTheme);
    drawCells(g2, model.fallingTetromino(), converter, colorTheme);

    if (model.getGameState() == GameState.GAME_OVER) {
      g2.setColor(colorTheme.getGameOverScreenColor());
      g2.fill(box);
      g2.setFont(GAME_OVER_FONT);
      g2.setColor(colorTheme.getGameOverStringColor());
      Inf101Graphics.drawCenteredString(g2, GAME_OVER_STRING, box);
    }
  }

  private static void drawCells(Graphics2D g2, Iterable<GridCell<Character>> cells,
      CellPositionToPixelConverter converter, ColorTheme colorTheme) {
    for (GridCell<Character> cell : cells) {
      Rectangle2D rectangle = converter.getBoundsForCell(cell.pos());
      g2.setColor(colorTheme.getCellColor(cell.value()));
      g2.fill(rectangle);
    }
  }
}
