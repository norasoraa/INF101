package no.uib.inf101.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.datastructure.IGrid;
import no.uib.inf101.datastructure.GridCell;
import no.uib.inf101.datastructure.GridCellCollection;

public class ColorGridView extends JPanel {

	private IGrid<Color> grid;
	private static final double OUTERMARGIN = 20;
	private static final double INNERMARGIN = 30;
	private static final Color MARGINCOLOR = Color.LIGHT_GRAY;

	public ColorGridView(IGrid<Color> colorGrid) {
		this.grid = colorGrid;
		this.setPreferredSize(new Dimension(400, 300));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGrid(g2);
	}

	private void drawGrid(Graphics2D g2) {
		Rectangle2D box = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN, this.getWidth() - OUTERMARGIN * 2,
				this.getHeight() - OUTERMARGIN * 2);

		g2.setColor(MARGINCOLOR);
		g2.fill(box);

		CellPositionToPixelConverter converter = new CellPositionToPixelConverter(box, grid, INNERMARGIN);
		drawCells(g2, grid, converter);

	}

	private static void drawCells(Graphics2D g2, GridCellCollection<Color> cellCollection,
			CellPositionToPixelConverter converter) {
		for (GridCell<Color> cell : cellCollection.getCells()) {
			Rectangle2D box = converter.getBoundsForCell(cell.pos());
			Color color = cell.elem();
			if (color == null)
				color = Color.DARK_GRAY;
			g2.setColor(color);
			g2.fill(box);
		}
	}

}
