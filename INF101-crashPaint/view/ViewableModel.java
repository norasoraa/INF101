package view;

import java.awt.Color;

import model.grid.CellPosition;
import model.grid.GridCell;
import model.grid.GridDimension;

public interface ViewableModel {
    GridDimension getDimension();
    Iterable<GridCell<Color>> getBoard();
}
