package no.uib.inf101.tetris.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;

/**
 * Class responsible for converting a {@link CellPosition} to pixel coordinates.
 */
public class CellPositionToPixelConverter {

  private Rectangle2D box;
  private GridDimension gd;
  private double margin;

  /**
   * Constructs a CellPositionToPixelConverter object with the given parameters.
   * 
   * @param box    {@link Rectangle2D}-object that represents within which area
   *               the grid is to be drawn
   * @param gd     {@link GridDimension}-object that describes the size of the
   *               grid that the cells will be a part of
   * @param margin {@code double} that describes how big the distance between the
   *               cells should be
   */
  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.gd = gd;
    this.margin = margin;
  }

  /**
   * Method that calculates the pixel coordinates of a cell based on its position
   * in the grid.
   * 
   * @param pos the position of the cell in the grid, represented as a
   *            {@link CellPosition}-object
   * @return a rectangle represented as a {@link Rectangle2D}-object with position
   *         and size described as pixels for use on a canvas
   */
  public Rectangle2D getBoundsForCell(CellPosition pos) {
    double cellWidth = (box.getWidth() - ((gd.cols() + 1) * margin)) / gd.cols();
    double cellHeight = (box.getHeight() - ((gd.rows() + 1) * margin)) / gd.rows();
    double cellX = box.getX() + (pos.col() * cellWidth) + ((pos.col() + 1) * margin);
    double cellY = box.getY() + (pos.row() * cellHeight) + ((pos.row() + 1) * margin);
    Rectangle2D cellBounds = new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
    return cellBounds;
  }
}
