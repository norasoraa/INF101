package no.uib.inf101.gridview;

import java.awt.Color;

import javax.swing.JFrame;

import no.uib.inf101.colorgrid.CellPosition;
import no.uib.inf101.colorgrid.ColorGrid;
import no.uib.inf101.colorgrid.IColorGrid;

public class Main {
  public static void main(String[] args) {
    IColorGrid colorGrid = new ColorGrid(3, 4);
    colorGrid.set(new CellPosition(0, 0), Color.RED);
    colorGrid.set(new CellPosition(0, 3), Color.BLUE);
    colorGrid.set(new CellPosition(2, 0), Color.YELLOW);
    colorGrid.set(new CellPosition(2, 3), Color.GREEN);
    GridView gridView = new GridView(colorGrid);
    JFrame frame = new JFrame();
    frame.setTitle("INF101");
    frame.setContentPane(gridView);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
