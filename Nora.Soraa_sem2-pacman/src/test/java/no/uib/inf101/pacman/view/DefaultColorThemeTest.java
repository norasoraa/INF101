package no.uib.inf101.pacman.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

public class DefaultColorThemeTest {

  @Test
  public void sanityDefaultColorThemeTest() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(null, colors.getBackgroundColor());
    assertEquals(new Color(0, 0, 0, 0), colors.getFrameColor());
    assertEquals(new Color(0, 0, 0, 128), colors.getPopUpColor());
    assertEquals(Color.WHITE, colors.getPopUpTextColor());
    assertEquals(Color.BLACK, colors.getGameInfoColor());
    assertThrows(IllegalArgumentException.class, () -> colors.getEntityImage('\n', null));
  }

  @Test
  public void getCellColorTest() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(Color.BLUE, colors.getCellColor('O'));
    assertEquals(Color.BLACK, colors.getCellColor('-'));
  }

}
