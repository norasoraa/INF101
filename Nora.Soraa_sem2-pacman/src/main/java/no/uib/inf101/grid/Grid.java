package no.uib.inf101.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class representing a grid. The grid is a 2D-list that represents rows and
 * columns, where each element is a value representing the content of the cell
 * in the grid.
 */
public class Grid<E> implements IGrid<E> {

  private int rows;
  private int cols;
  private List<List<E>> grid;

  /**
   * Constructor that creates a grid with the given rows and columns. The cells in
   * this grid has the default value "null".
   * 
   * @param rows the number of rows in the grid
   * @param cols the number of columns in the grid
   */
  public Grid(int rows, int cols) {
    this(rows, cols, null);
  }

  /**
   * Constructor that creates a grid with the given rows and columns. The cells in
   * this grid has the default value given as argument.
   * 
   * @param row   the number of rows in the grid
   * @param col   the number of columns in the grid
   * @param value the value of the cells in the grid
   */
  public Grid(int rows, int cols, E defaultValue) {
    this.rows = rows;
    this.cols = cols;

    this.grid = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      grid.add(row, new ArrayList<>());
      for (int col = 0; col < cols; col++) {
        grid.get(row).add(defaultValue);
      }
    }
  }

  @Override
  public int rows() {
    return rows;
  }

  @Override
  public int cols() {
    return cols;
  }

  @Override
  public Iterator<GridCell<E>> iterator() {
    ArrayList<GridCell<E>> gridCells = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        CellPosition currentPos = new CellPosition(row, col);
        E currentValue = get(currentPos);
        GridCell<E> cell = new GridCell<E>(currentPos, currentValue);
        gridCells.add(cell);
      }
    }
    return gridCells.iterator();
  }

  @Override
  public void set(CellPosition pos, E value) {
    if (!positionIsOnGrid(pos)) {
      throw new IndexOutOfBoundsException("The position does not exist in the grid: (" + pos.row() + ", " + pos.col() + ")");
    }
    grid.get(pos.row()).set(pos.col(), value);
  }

  @Override
  public E get(CellPosition pos) {
    if (!positionIsOnGrid(pos)) {
      throw new IndexOutOfBoundsException("The position does not exist in the grid: (" + pos.row() + ", " + pos.col() + ")");
    }
    return grid.get(pos.row()).get(pos.col());
  }

  @Override
  public boolean positionIsOnGrid(CellPosition pos) {
    return (
      (pos.col() >= 0) && (pos.col() < cols) &&
      (pos.row() >= 0) && (pos.row() < rows)
    );
  }

}
