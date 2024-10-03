package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import model.grid.GridCell;

public class View extends JPanel {
  
  private static final double OUTERMARGIN = 10;
  private static final double INNERMARGIN = 3;
  private ViewableModel model;

  /// Constructor
  public View(ViewableModel model) {
    this.model = model;
    this.setFocusable(true);
    this.setPreferredSize(new Dimension(300, 400));
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    drawGame(g2);
  }

  private Rectangle2D getDimensionedBox() {
    return new Rectangle2D.Double(
      OUTERMARGIN,
      OUTERMARGIN,
      this.getWidth() - OUTERMARGIN * 2,
      this.getHeight() - OUTERMARGIN * 2
    );
  }

  public CellPositionToPixelConverter getPixelConverter() {
    return new CellPositionToPixelConverter(
      getDimensionedBox(), this.model.getDimension(), INNERMARGIN
    );
  }


  private void drawGame(Graphics2D g2) {
    Rectangle2D box = getDimensionedBox();
    g2.setColor(Color.BLACK);
    g2.fill(box);

    drawCells(g2, this.model.getBoard(), getPixelConverter()); 
  }

  private void drawCells(Graphics2D g2, Iterable<GridCell<Color>> cells, CellPositionToPixelConverter converter) {
    for (GridCell<Color> cell : cells) {
      Rectangle2D box = converter.getBoundsForCell(cell.pos());

      Color color = (cell.value() == null) ? Color.DARK_GRAY : cell.value();
      g2.setColor(color);
      g2.fill(box);
    }
  }
}
