package no.uib.inf101.tetris.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class DefaultColorThemeTest {

  @Test
  public void sanityDefaultColorThemeTest() {
  ColorTheme colors = new DefaultColorTheme();
  assertEquals(null, colors.getBackgroundColor());
  assertEquals(new Color(0, 0, 0, 0), colors.getFrameColor());
  assertEquals(Color.BLACK, colors.getCellColor('-'));
  assertEquals(Color.RED, colors.getCellColor('L'));
  assertEquals(Color.BLUE, colors.getCellColor('S'));
  assertEquals(Color.GREEN, colors.getCellColor('J'));
  assertEquals(Color.PINK, colors.getCellColor('Z'));
  assertEquals(Color.YELLOW, colors.getCellColor('T'));
  assertEquals(Color.CYAN, colors.getCellColor('I'));
  assertEquals(Color.MAGENTA, colors.getCellColor('O'));
  assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));
  }

  @Test
  public void testGetGameOverScreenColor() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(new Color(0, 0, 0, 128), colors.getGameOverScreenColor());
  }

  @Test
  public void testGetGameOverStringColor() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(Color.WHITE, colors.getGameOverStringColor());
  }
}
