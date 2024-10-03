package no.uib.inf101.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.inf101.datastructure.GridCell;
import no.uib.inf101.datastructure.GridCellCollection;
import no.uib.inf101.datastructure.IGrid;

public class TextGridView extends JPanel {

	private IGrid<String> grid;
	private static final double OUTERMARGIN = 20;
	private static final double INNERMARGIN = 5;
	private static final Color MARGINCOLOR = Color.LIGHT_GRAY;

	public TextGridView(IGrid<String> textGrid) {
		this.grid = textGrid;
		this.setPreferredSize(new Dimension(1000, 300));
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

	private static void drawCells(Graphics2D g2, GridCellCollection<String> cellCollection,
			CellPositionToPixelConverter converter) {

		for (GridCell<String> cell : cellCollection.getCells()) {
			// Draw box for text
			Rectangle2D box = converter.getBoundsForCell(cell.pos());
			g2.setColor(Color.BLUE);
			g2.fill(box);

			// check text content
			String text = cell.elem();
			if (text == null)
				continue;

			// draw text
			g2.setColor(Color.WHITE);
			Inf101Graphics.drawScaledCenteredString(g2, text, box);
		}
	}
}
