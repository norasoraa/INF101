package no.uib.inf101.grid;

/**
 * The GridDimension interface represents the dimensions of a grid in terms of
 * rows and columns. It provides methods to retrieve the number of rows and
 * columns in a GridDimension object.
 */
public interface GridDimension {

  /** Number of rows in the grid */
  int rows();

  /** Number of columns in the grid */
  int cols();
}
