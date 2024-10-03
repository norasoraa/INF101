package no.uib.inf101.gridview;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.colorgrid.CellPosition;
import no.uib.inf101.colorgrid.GridDimension;

public class CellPositionToPixelConverter {
  
  private Rectangle2D box;
  private GridDimension gd;
  private double margin;

  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.gd = gd;
    this.margin = margin;
  }

  public Rectangle2D getBoundsForCell(CellPosition pos) {
    double cellWidth = (box.getWidth() - ((gd.cols() + 1) * margin)) / gd.cols();
    double cellHeight = (box.getHeight() - ((gd.rows() + 1) * margin)) / gd.rows();
    double cellX = box.getX() + (pos.col() * cellWidth) + ((pos.col() + 1) * margin);
    double cellY = box.getY() + (pos.row() * cellHeight) + ((pos.row() + 1) * margin);
    Rectangle2D cellBounds = new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
    return cellBounds;
  }
}
