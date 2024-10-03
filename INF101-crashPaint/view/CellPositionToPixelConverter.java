package view;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import model.grid.CellPosition;
import model.grid.GridDimension;



public class CellPositionToPixelConverter {
  private final Rectangle2D box;
  private final double margin;
  private final double cellW;
  private final double cellH;
  
  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.margin = margin;
    cellW = (box.getWidth() - margin * gd.cols() - margin) / gd.cols();
    cellH = (box.getHeight() - margin * gd.rows() - margin) / gd.rows();
  }
  
  public Rectangle2D getBoundsForCell(CellPosition cellPosition) {
    double cellX = box.getX() + margin + (cellW + margin) * cellPosition.col();
    double cellY = box.getY() + margin + (cellH + margin) * cellPosition.row();
    return new Rectangle2D.Double(cellX, cellY, cellW, cellH);
  }

  public CellPosition pointToCellPosition(Point2D point) {
    double col = (point.getX() - box.getX() - margin) / (cellW + margin);
    double row = (point.getY() - box.getY() - margin) / (cellH + margin);
    return new CellPosition((int) row, (int) col);
  }
}
