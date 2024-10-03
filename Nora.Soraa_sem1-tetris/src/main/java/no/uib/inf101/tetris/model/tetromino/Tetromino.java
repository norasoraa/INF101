package no.uib.inf101.tetris.model.tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

/**
 * Class that represents a tetromino. This class is immutable, that is, once an
 * object is created it cannot be mutated.
 */
public final class Tetromino implements Iterable<GridCell<Character>> {

  private final char symbol;
  private final boolean[][] shape;
  private final CellPosition pos;

  /**
   * Constructor that represents a tetromino.
   * 
   * @param symbol represents the symbol of the tetromino
   * @param shape  represents the shape of the tetromino
   * @param pos    represents the position of the top left corner of the tetromino
   *               (this position is not actually part of the tetromino if the top
   *               left corner of the shape is false, but describes where on the
   *               game board "the shape is attached").
   */
  private Tetromino(char symbol, boolean[][] shape, CellPosition pos) {
    this.symbol = symbol;
    this.shape = shape;
    this.pos = pos;
  }

  /**
   * A package-private class method that takes a {@code char} as a parameter and
   * returns a new {@link Tetromino}-object with a shape based on the symbol
   * given. The position should be (0, 0).
   * 
   * @param symbol of the new tetromino
   * @return a new tetromino based on the symbol
   * @throws IllegalArgumentException if an unknown symbol is encountered
   */
  static Tetromino newTetromino(char symbol) {
    boolean[][] tetroShape;
    CellPosition pos = new CellPosition(0, 0);
    switch (symbol) {
    case 'L':
      tetroShape = new boolean[][] { 
        {false, false, false}, 
        { true,  true,  true}, 
        { true, false, false} 
      };
      break;

    case 'J':
      tetroShape = new boolean[][] { 
        {false, false, false},
        { true,  true,  true}, 
        {false, false,  true}
      };
      break;

    case 'S':
      tetroShape = new boolean[][] {
        {false, false, false},
        {false,  true,  true},
        { true,  true, false}
      };
      break;

    case 'Z':
      tetroShape = new boolean[][] {
        {false, false, false},
        { true,  true, false},
        {false,  true,  true}
      };
      break;

    case 'T':
      tetroShape = new boolean[][] {
        {false, false, false}, 
        { true,  true,  true}, 
        {false,  true, false}
      };
      break;

    case 'I':
      tetroShape = new boolean[][] {
        {false, false, false, false},
        { true,  true,  true,  true},
        {false, false, false, false},
        {false, false, false, false} 
      };
      break;

    case 'O':
      tetroShape = new boolean[][] {
        {false, false, false, false}, 
        {false,  true,  true, false},
        {false,  true,  true, false}, 
        {false, false, false, false}
      };
      break;

    default:
      throw new IllegalArgumentException("The symbol '" + symbol + "' is unknown and is not a valid tetromino-family ");
    }
    return new Tetromino(symbol, tetroShape, pos);
  }

  /**
   * A method that has two int parameters that indicate how far the copy should be
   * moved in relation to the current location. The method creates a copy of
   * itself, except the position has been moved.
   * 
   * @param deltaRow the number of rows you want to move the tetromino
   * @param deltaCol the number of columns you want to move the tetromino
   * @return a copy of itself, where the position has been moved.
   */
  public Tetromino shiftedBy(int deltaRow, int deltaCol) {
    CellPosition newPos = new CellPosition(pos.row() + deltaRow, pos.col() + deltaCol);
    return new Tetromino(symbol, shape, newPos);
  }

  /**
   * A method creates a shifted copy centered around the middle or the middle two
   * columns of a grid of the given dimensions, such that the top real cell in the
   * tetromino comes in row 0.
   * 
   * @param grid to center the tetromino on, represented as a
   *             {@link GridDimension}-object
   * @return a copy of itself, where it has been centered to the top of the grid
   */
  public Tetromino shiftedToTopCenterOf(GridDimension grid) {
    int firstRealRow = -1;
    int middleCol = (grid.cols() - shape.length) / 2;
    return shiftedBy(firstRealRow, middleCol);
  }

  /**
   * A method that creates a rotated copy of itself. It rotates in a
   * counter-clockwise direction.
   * 
   * @return a copy of itself, where it has been rotated
   */
  public Tetromino rotate() {
    boolean[][] newShape = new boolean[shape.length][shape.length];
    int width = newShape.length;
    for (int row = 0; row < width; row++) {
      for (int col = 0; col < width; col++) {
        newShape[row][col] = shape[col][width - row - 1];
      }
    }
    return new Tetromino(symbol, newShape, pos);
  }

  @Override
  public Iterator<GridCell<Character>> iterator() {
    List<GridCell<Character>> cells = new ArrayList<>();
    for (int row = 0; row < shape.length; row++) {
      for (int col = 0; col < shape[row].length; col++) {
        if (shape[row][col] == true) {
          CellPosition posOnBoard = new CellPosition(pos.row() + row, pos.col() + col);
          cells.add(new GridCell<Character>(posOnBoard, symbol));
        }
      }
    }
    return cells.iterator();
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, Arrays.deepHashCode(shape), pos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Tetromino other = (Tetromino) obj;
    if (symbol != other.symbol)
      return false;
    if (!Arrays.deepEquals(shape, other.shape))
      return false;
    if (pos == null) {
      if (other.pos != null)
        return false;
    } else if (!pos.equals(other.pos))
      return false;
    return true;
  }
}
