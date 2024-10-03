package no.uib.inf101.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Class representing a grid. */
public class Grid<E> implements IGrid<E>{

  private int rows;
  private int cols;
  private List<List<E>> grid;

  /**
   * Constructor that creates a grid with the given rows and columns.
   * The cells in this grid has the default value "null".
   * @param rows the number of rows in the grid
   * @param cols the number of columns in the grid
   */
  public Grid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.grid = createGrid(null);;
  }

  /**
   * Constructor that creates a grid with the given rows and columns.
   * The cells in this grid has the value given as argument.
   * @param row the number of rows in the grid
   * @param col the number of columns in the grid
   * @param value the value of the cells in the grid
   */
  public Grid(int row, int col, E value) {
    this.rows = row;
    this.cols = col;
    this.grid = createGrid(value);
  }

  private List<List<E>> createGrid(E value) {
    List<List<E>> grid = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      grid.add(row, new ArrayList<>());
      for (int col = 0; col < cols; col++) {
        grid.get(row).add(value);
      }
    }
    return grid;
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
        E currentValue = this.get(currentPos);
        GridCell<E> cell = new GridCell<E>(currentPos, currentValue);
        gridCells.add(cell);
      }
    }
    return gridCells.iterator();
  }

  @Override
  public void set(CellPosition pos, E value) {
    if (!positionIsOnGrid(pos)) {
      throw new IndexOutOfBoundsException("The position does not exist in the grid");
    }
    grid.get(pos.row()).set(pos.col(), value);
  }

  @Override
  public E get(CellPosition pos) {
    if (!positionIsOnGrid(pos)) {
      throw new IndexOutOfBoundsException("The position does not exist in the grid");
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
