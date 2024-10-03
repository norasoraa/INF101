package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;

public class TestTetrisBoard {

  @Test
  public void prettyStringTest() {
    TetrisBoard board = new TetrisBoard(3, 4);
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 3), 'y');
    board.set(new CellPosition(2, 0), 'r');
    board.set(new CellPosition(2, 3), 'b');
    String expected = String.join("\n", new String[] {
        "g--y",
        "----",
        "r--b"
    });
    assertEquals(expected, board.prettyString());
  }
  
  private TetrisBoard getTetrisBoardWithContents(String[] strings) {
    int rows = strings.length;
    int cols = strings[0].length();
    TetrisBoard board = new TetrisBoard(rows, cols);
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        board.set(new CellPosition(row, col), strings[row].charAt(col));
      }
    }
    return board;
  }

  @Test
  public void testRemoveFullRows() {
    TetrisBoard board = getTetrisBoardWithContents(new String[] {
      "-T",
      "TT",
      "LT",
      "L-",
      "LL"
    });
    assertEquals(3, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "--",
      "--",
      "-T",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }

  @Test
  public void testRemoveFullRowsKeepBottomRow() {
    TetrisBoard board = getTetrisBoardWithContents(new String[] {
      "LT",
      "TT",
      "LT",
      "LL",
      "L-"
    });
    assertEquals(4, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "--",
      "--",
      "--",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }

  @Test
  public void testRemoveFullRowsRemoveTopRow() {
    TetrisBoard board = getTetrisBoardWithContents(new String[] {
      "LT",
      "L-",
      "-T",
      "L-",
      "L-"
    });
    assertEquals(1, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "--",
      "L-",
      "-T",
      "L-",
      "L-"
    });
    assertEquals(expected, board.prettyString());
  }

  @Test
  public void testRemoveFullRowsWithDifferentDimension() {
    TetrisBoard board = getTetrisBoardWithContents(new String[] {
      "TTTTTT",
      "TT--TL",
      "LT----",
      "LLLLLL",
      "LL----"
    });
    assertEquals(2, board.removeFullRows());
    String expected = String.join("\n", new String[] {
      "------",
      "------",
      "TT--TL",
      "LT----",
      "LL----"
    });
    assertEquals(expected, board.prettyString());
  }

}
