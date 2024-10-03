package no.uib.inf101.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.colorgrid.CellColor;
import no.uib.inf101.colorgrid.CellColorCollection;
import no.uib.inf101.colorgrid.IColorGrid;

public class GridView extends JPanel {
  
  private IColorGrid colorGrid;
  private static final double MARGIN = 30;
  private static final Color MARGINCOLOR = Color.LIGHT_GRAY;

  public GridView(IColorGrid colorGrid) {
    this.colorGrid = colorGrid;
    this.setPreferredSize(new Dimension(400, 300));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGrid(g2);
  }

  private void drawGrid(Graphics2D g2) {
    double x = MARGIN;
    double y = MARGIN;
    double width = this.getWidth() - 2 * MARGIN;
    double height = this.getHeight() - 2 * MARGIN;
    Rectangle2D box = new Rectangle2D.Double(x, y, width, height);
    g2.setColor(MARGINCOLOR);
    g2.fill(box);
    CellPositionToPixelConverter converter = new CellPositionToPixelConverter(box, colorGrid, MARGIN);
    drawCells(g2, colorGrid, converter);
  }

  private static void drawCells(Graphics2D g2, CellColorCollection collection, CellPositionToPixelConverter converter) {
    for (CellColor cellColor : collection.getCells()) {
      Rectangle2D cell = converter.getBoundsForCell(cellColor.cellPosition());
      if (cellColor.color() == null) {
        g2.setColor(Color.DARK_GRAY);
      }
      else {
        g2.setColor(cellColor.color());
      }
      g2.fill(cell);
    }
  }
}
