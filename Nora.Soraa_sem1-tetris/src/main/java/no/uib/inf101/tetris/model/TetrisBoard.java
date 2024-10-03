package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;
import no.uib.inf101.grid.GridCell;

/**
 * Class that represents a board with tiles. This is a grid. All objects in this
 * class is a {@link Grid}-object.
 */
public class TetrisBoard extends Grid<Character> {

  /**
   * Constructor that creates a board with the given rows and columns. All of the
   * cells in the board has the value {@code '-'}, which represents an empty cell.
   * 
   * @param rows {@code int} that represents the number of rows on the board
   * @param cols {@code int} that represents the number of columns on the board
   */
  public TetrisBoard(int rows, int cols) {
    super(rows, cols, '-');
  }

  /**
   * A method that creates a String-representation of the {@link TetrisBoard} in a
   * pretty way.
   * 
   * @return A string representation of the board
   */
  public String prettyString() {
    String stringBoard = "";
    for (int row = 0; row < this.rows(); row++) {
      for (int col = 0; col < this.cols(); col++) {
        stringBoard += this.get(new CellPosition(row, col));
      }
      if (row < this.rows() - 1) {
        stringBoard += "\n";
      }
    }
    return stringBoard;
  }

  /**
   * A method that removes all full rows from the board, and keeps count of how
   * many rows were removed.
   * 
   * @return {@code int} that represents the number of rows that has been removed
   */
  public int removeFullRows() {
    int discardedRows = 0;
    int a = this.rows() - 1;
    int b = this.rows() - 1;

    while (a >= 0) {
      while (b >= 0 && !elementExistsInRow(b, '-')) {
        discardedRows++;
        b--;
      }
      if (b >= 0) {
        copyAllValuesToRow(b, a);
      } else {
        setAllCellsInRowToValue(a, '-');
      }
      a--;
      b--;
    }
    return discardedRows;
  }

  private boolean elementExistsInRow(int row, char element) {
    for (GridCell<Character> cell : this) {
      if (cell.pos().row() != row) {
        continue;
      }
      if (cell.value() == element) {
        return true;
      }
    }
    return false;
  }

  private void setAllCellsInRowToValue(int row, char value) {
    for (int col = 0; col < this.cols(); col++) {
      this.set(new CellPosition(row, col), value);
    }
  }

  private void copyAllValuesToRow(int rowToCopyFrom, int rowToCopyTo) {
    for (int col = 0; col < this.cols(); col++) {
      char value = this.get(new CellPosition(rowToCopyFrom, col));
      this.set(new CellPosition(rowToCopyTo, col), value);
    }
  }
}
