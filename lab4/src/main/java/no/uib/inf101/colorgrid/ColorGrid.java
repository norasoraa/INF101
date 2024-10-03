package no.uib.inf101.colorgrid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorGrid implements IColorGrid {

  private int rows;
  private int cols;
  private List<List<CellColor>> grid;

  public ColorGrid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.grid = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      this.grid.add(new ArrayList<>());
      for (int col = 0; col < cols; col++) {
        this.grid.get(row).add(new CellColor(new CellPosition(row, col), null));
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
  public List<CellColor> getCells() {
    List<CellColor> cells = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        cells.add(new CellColor(new CellPosition(row, col), grid.get(row).get(col).color()));
      }
    }
    return cells;
  }

  @Override
  public Color get(CellPosition pos) {
    return grid.get(pos.row()).get(pos.col()).color();
  }

  @Override
  public void set(CellPosition pos, Color color) {
    grid.get(pos.row()).set(pos.col(), new CellColor(pos, color));
  }
}
