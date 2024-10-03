package no.uib.inf101.gridview;

import java.awt.Color;

import javax.swing.JFrame;

import no.uib.inf101.datastructure.CellPosition;
import no.uib.inf101.datastructure.Grid;

public class Main {

	public static void main(String[] args) {

		Grid<Color> colorGrid = new Grid<>(3, 4);
		colorGrid.set(new CellPosition(0, 0), Color.RED);
		colorGrid.set(new CellPosition(0, 3), Color.BLUE);
		colorGrid.set(new CellPosition(2, 0), Color.YELLOW);
		colorGrid.set(new CellPosition(2, 3), Color.GREEN);

		Grid<String> textGrid = new Grid<>(8, 8);
		textGrid.set(new CellPosition(0, 1), "Mandag");
		textGrid.set(new CellPosition(0, 2), "Tirsdag");
		textGrid.set(new CellPosition(0, 3), "Onsdag"); 
		textGrid.set(new CellPosition(0, 4), "Torsdag");
		textGrid.set(new CellPosition(0, 5), "Fredag");
		textGrid.set(new CellPosition(0, 6), "Lørdag"); 
		textGrid.set(new CellPosition(0, 7), "Søndag");
		textGrid.set(new CellPosition(1, 0), "08-10");
		textGrid.set(new CellPosition(2, 0), "10-12");
		textGrid.set(new CellPosition(3, 0), "12-14");
		textGrid.set(new CellPosition(4, 0), "14-16");

		//ColorGridView view = new ColorGridView(colorGrid);
		TextGridView view = new TextGridView(textGrid);

		JFrame frame = new JFrame();
		frame.setContentPane(view);
		frame.setTitle("ColorGrid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
