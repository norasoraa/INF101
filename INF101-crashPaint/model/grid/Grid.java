package model.grid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<T> implements IGrid<T> {

  private final int rows;
  private final int cols;
  private final List<List<T>> grid;

  public Grid(int rows, int cols) {
    this(rows, cols, null);
  }

  public Grid(int rows, int cols, T value) {
    this.rows = rows;
    this.cols = cols;
    this.grid = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      List<T> rowList = new ArrayList<>();
      for (int col = 0; col < cols; col++) {
        rowList.add(value);
      }
      this.grid.add(rowList);
    }
  }

  @Override
  public int rows() {
    return this.rows;
  }

  @Override
  public int cols() {
    return this.cols;
  }

  @Override
  public T get(CellPosition pos) {
    return this.grid.get(pos.row()).get(pos.col());
  }

  @Override
  public void set(CellPosition pos, T value) {
    this.grid.get(pos.row()).set(pos.col(), value);
  }

@Override
public Iterator<GridCell<T>> iterator() {
    List<GridCell<T>> cells = new ArrayList<>();
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.cols; col++) {
        CellPosition pos = new CellPosition(row, col);
        T value = this.get(pos);
        cells.add(new GridCell<>(pos, value));
      }
    }
    return cells.iterator();
}

@Override
public boolean positionIsOnGrid(CellPosition pos) {
    if (pos.row() < 0 || pos.row() >= rows){return false;}
    if (pos.col() < 0 || pos.col() >= cols){return false;}
    return true;
}

  
}
