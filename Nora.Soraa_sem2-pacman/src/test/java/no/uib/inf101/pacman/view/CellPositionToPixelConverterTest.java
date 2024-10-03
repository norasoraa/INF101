package no.uib.inf101.pacman.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Rectangle2D;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.pacman.model.PacManBoard;

public class CellPositionToPixelConverterTest {

  @Test
  public void sanityTest() throws IOException {
    GridDimension gd = new PacManBoard(3, 4, "pacManBoard.txt");
    CellPositionToPixelConverter converter = new CellPositionToPixelConverter(new Rectangle2D.Double(29, 29, 340, 240),
        gd, 30);
    Rectangle2D expected = new Rectangle2D.Double(214, 129, 47.5, 40);
    assertEquals(expected, converter.getBoundsForCell(new CellPosition(1, 2)));
  }

}
