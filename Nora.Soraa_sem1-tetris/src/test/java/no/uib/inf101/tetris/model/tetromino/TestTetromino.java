package no.uib.inf101.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.TetrisBoard;

public class TestTetromino {

  @Test
  public void testHashCodeAndEquals() {
    Tetromino t1 = Tetromino.newTetromino('T');
    Tetromino t2 = Tetromino.newTetromino('T');
    Tetromino t3 = Tetromino.newTetromino('T').shiftedBy(1, 0);
    Tetromino s1 = Tetromino.newTetromino('S');
    Tetromino s2 = Tetromino.newTetromino('S').shiftedBy(0, 0);

    assertEquals(t1, t2);
    assertEquals(s1, s2);
    assertEquals(t1.hashCode(), t2.hashCode());
    assertEquals(s1.hashCode(), s2.hashCode());
    assertNotEquals(t1, t3);
    assertNotEquals(t1, s1);
  }

  @Test
  public void tetrominoIterationOfT() {
    // Create a standard 'T' tetromino placed at (10, 100) to test
    Tetromino tetro = Tetromino.newTetromino('T');
    tetro = tetro.shiftedBy(10, 100);

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
      objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 100), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 102), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'T')));
  }

  @Test
  public void tetrominoIterationOfS() {
    // Create a standard 'S' tetromino placed at (12, 50) to test
    Tetromino tetro = Tetromino.newTetromino('S');
    tetro = tetro.shiftedBy(12, 50);

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
      objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(13, 51), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(13, 52), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(14, 50), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(14, 51), 'S')));
  }

  @Test
  void testShiftedToTopCenterOfWith4x4Tetromino() {
    // Create a standard 'O' tetromino on the board
    TetrisBoard board = new TetrisBoard(15, 10);
    Tetromino tetromino = Tetromino.newTetromino('O');
    tetromino = tetromino.shiftedToTopCenterOf(board);

    // Collect which objects are iterated through
    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> cell : tetromino) {
      tetroCells.add(cell);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'O')));
  }

  @Test
  void testShiftedToTopCenterOfWith3x3Tetromino() {
    // Create a standard 'L' tetromino on the board
    TetrisBoard board = new TetrisBoard(15, 10);
    Tetromino tetromino = Tetromino.newTetromino('L');
    tetromino = tetromino.shiftedToTopCenterOf(board);

    // Collect which objects are iterated through
    List<GridCell<Character>> tetroCells = new ArrayList<>();
    for (GridCell<Character> cell : tetromino) {
      tetroCells.add(cell);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, tetroCells.size());
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'L')));
    assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 3), 'L')));
  }

  @Test
  public void twoEqualMovesEqualsTwiceAsFar() {
    // Create a standard 'I' tetromino on the board
    TetrisBoard board = new TetrisBoard(15, 10);
    Tetromino tetromino = Tetromino.newTetromino('I');
    tetromino = tetromino.shiftedToTopCenterOf(board);

    int moveRow = 3;
    int moveCol = 0;

    // Move tetromino
    tetromino = tetromino.shiftedBy(moveRow, moveCol);

    // Iterate through tetromino after 1 move
    List<GridCell<Character>> tetroCells1 = new ArrayList<>();
    for (GridCell<Character> cell : tetromino) {
      tetroCells1.add(cell);
    }

    // Move tetromino again with same distance
    tetromino = tetromino.shiftedBy(moveRow, moveCol);

    // Iterate through tetromino after 2 equal moves
    List<GridCell<Character>> tetroCells2 = new ArrayList<>();
    for (GridCell<Character> cell : tetromino) {
      tetroCells2.add(cell);
    }

    /*
     * Check that if you move the piece twice the same distance, you will have moved
     * twice as far as if you moved the piece once.
     */
    for (GridCell<Character> cell : tetroCells1) {
      CellPosition posAfter2EqualMoves = new CellPosition(cell.pos().row() * 2, cell.pos().col());
      assertTrue(tetroCells2.contains(new GridCell<>(posAfter2EqualMoves, cell.value())));
    }
  }

  @Test
  public void tetrominoRotationOfT() {
    // Create a standard 'T' tetromino placed at (10, 10) to test
    Tetromino tetro = Tetromino.newTetromino('T');
    tetro = tetro.shiftedBy(10, 10);
    tetro = tetro.rotate();

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
      objs.add(gc);
    }

    assertTrue(objs.contains(new GridCell<>(new CellPosition(10, 11), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 11), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 12), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 11), 'T')));
  }
}
