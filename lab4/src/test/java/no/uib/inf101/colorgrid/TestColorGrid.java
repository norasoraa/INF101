package no.uib.inf101.colorgrid;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestColorGrid {

  @Test
  public void sanityTest() {
    IColorGrid grid = new WColorGrid(3, 4);

    // Check that number of rows and cols match up
    assertEquals(3, grid.rows());
    assertEquals(4, grid.cols());

    // Check that default value is null
    assertEquals(null, grid.get(new CellPosition(1, 2)));

    // Check that we can set a value and retrieve it again
    grid.set(new CellPosition(1, 2), Color.RED);
    assertEquals(Color.RED, grid.get(new CellPosition(1, 2)));
    assertEquals(null, grid.get(new CellPosition(2, 1)));

    // Check that we can set a new value and retrieve it again
    grid.set(new CellPosition(1, 2), Color.GREEN);
    assertEquals(Color.GREEN, grid.get(new CellPosition(1, 2)));
  }

  @Test
  public void testDimension() {
    GridDimension gd = new WColorGrid(10, 20);
    assertEquals(10, gd.rows());
    assertEquals(20, gd.cols());

    gd = new WColorGrid(1, 1);
    assertEquals(1, gd.rows());
    assertEquals(1, gd.cols());
  }

  @Test
  public void testGetDefaultValue() {
    IColorGrid grid = new WColorGrid(10, 20);
    assertNull(grid.get(new CellPosition(0, 0)));
    assertNull(grid.get(new CellPosition(2, 3)));
  }

  @Test
  public void testSetGetInCorners() {
    IColorGrid grid = new WColorGrid(10, 20);
    // Set color in corners
    grid.set(new CellPosition(0, 0), Color.RED);
    grid.set(new CellPosition(0, 19), Color.GREEN);
    grid.set(new CellPosition(9, 0), Color.BLUE);
    grid.set(new CellPosition(9, 19), Color.YELLOW);

    // Get color in corners
    assertEquals(Color.RED, grid.get(new CellPosition(0, 0)));
    assertEquals(Color.GREEN, grid.get(new CellPosition(0, 19)));
    assertEquals(Color.BLUE, grid.get(new CellPosition(9, 0)));
    assertEquals(Color.YELLOW, grid.get(new CellPosition(9, 19)));
  }

  @Test
  public void testGetCells() {
    IColorGrid grid = new WColorGrid(2, 2);

    grid.set(new CellPosition(0, 0), Color.RED);
    grid.set(new CellPosition(0, 1), Color.GREEN);
    grid.set(new CellPosition(1, 0), Color.BLUE);
    grid.set(new CellPosition(1, 1), Color.BLACK);

    List<CellColor> expected = Arrays.asList(
        new CellColor(new CellPosition(0, 0), Color.RED),
        new CellColor(new CellPosition(0, 1), Color.GREEN),
        new CellColor(new CellPosition(1, 0), Color.BLUE),
        new CellColor(new CellPosition(1, 1), Color.BLACK)
    );
    List<CellColor> actual = grid.getCells();

    assertEquals(expected.size(), actual.size());
    for (CellColor cp : actual) {
      assertTrue(expected.contains(cp));
    }
    for (CellColor cp : expected) {
      assertTrue(actual.contains(cp));
    }
  }

  @Test
  public void testGetCellsWithNull() {
    IColorGrid grid = new WColorGrid(3, 1);

    grid.set(new CellPosition(2, 0), Color.GREEN);

    List<CellColor> expected = Arrays.asList(
        new CellColor(new CellPosition(0, 0), null),
        new CellColor(new CellPosition(1, 0), null),
        new CellColor(new CellPosition(2, 0), Color.GREEN)
    );
    List<CellColor> actual = grid.getCells();

    assertEquals(expected.size(), actual.size());
    for (CellColor cp : actual) {
      assertTrue(expected.contains(cp));
    }
    for (CellColor cp : expected) {
      assertTrue(actual.contains(cp));
    }
  }

  @Test
  public void testIndexOutOfBoundsException() {
    IColorGrid grid = new WColorGrid(10, 20);

    // Test out of bounds for get
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(-1, 0)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(0, -1)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(10, 0)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(0, 20)));

    // Test out of bounds for set
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(-1, 0), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(0, -1), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(10, 0), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(0, 20), Color.RED));
  }
}
