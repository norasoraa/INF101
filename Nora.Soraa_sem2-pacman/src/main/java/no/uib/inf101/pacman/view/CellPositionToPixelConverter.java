package no.uib.inf101.pacman.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;

/**
 * Class responsible for converting a {@link CellPosition} to pixel coordinates.
 */
public class CellPositionToPixelConverter {

  private final Rectangle2D box;
  private final GridDimension gd;
  private final double margin;

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
    double cellWidth = (box.getWidth() - margin * gd.cols() - margin) / gd.cols();
    double cellHeight = (box.getHeight() - margin * gd.rows() - margin) / gd.rows();
    double cellX = box.getX() + margin + (cellWidth + margin) * pos.col();
    double cellY = box.getY() + margin + (cellHeight + margin) * pos.row();
    Rectangle2D cellBounds = new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
    return cellBounds;
  }
}
