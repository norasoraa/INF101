package inf101.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * A Grid contains a values in a 2D rectangular layout.
 */
public class Grid<T> implements IGrid<T> {
	private final List<T> cells;
	private final int columns;
	private final int rows;

	/**
	 * Construct a grid with the given dimensions.
	 * <p>
	 * The initialiser function will be called with the (x,y) position of an
	 * element, and is expected to return the element to place at that position. For
	 * example:
	 *
	 * <pre>
	 * // fill all cells with the position as a string (e.g., "(2,2)")
	 * new Grid(10, 10, ((x, y) -> String.format("(%d,%d)", x, y));
	 * </pre>
	 *
	 * @param width
	 * @param height
	 * @param initialiser The initialiser function
	 */
	public Grid(int width, int height, Function<Location, T> initialiser) {
		this(width, height);
		fill(initialiser);
	}

	/**
	 * Construct a grid with the given dimensions.
	 *
	 * @param width
	 * @param height
	 * @param initElement What the cells should initially hold (possibly null)
	 */
	public Grid(int width, int height, T initElement) {
		this(width, height);
		fill(initElement);
	}

	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.cells = new ArrayList<>(rows * columns);
		for (int i = 0; i < rows * columns; i++) {
			cells.add(null);
		}
	}

	@Override
	public int numColumns() {
		return columns;
	}

	@Override
	public int numRows() {
		return rows;
	}

	@Override
	public void set(Location loc, T elem) {
		checkLocation(loc);

		cells.set(locationToIndex(loc), elem);
	}

	/**
	 * This method checks if a given Location is within the bounds of this grid.
	 * If it is not, an IndexOutOfBoundsException is thrown.
	 *
	 * @param loc the location to check
	 */
	public void checkLocation(Location loc) {
		if (!isOnGrid(loc)) {
			throw new IndexOutOfBoundsException("Row and column indices must be within bounds");
		}
	}

	@Override
	public boolean isOnGrid(Location loc) {
		if (loc == null) {
			return false;
		}
		if (loc.row < 0 || loc.row >= rows) {
			return false;
		}

		return loc.col >= 0 && loc.col < columns;
	}

	/**
	 * This method computes which index in the list belongs to a given Location
	 */
	private int locationToIndex(Location loc) {
		return loc.col + loc.row * columns;
	}

	@Override
	public T get(Location loc) {
		checkLocation(loc);

		return cells.get(locationToIndex(loc));
	}

	@Override
	public GridLocationIterator locations() {
		return new GridLocationIterator(numRows(), numColumns());
	}

	@Override
	public IGrid<T> copy() {
		Grid<T> newGrid = new Grid<>(numRows(), numColumns());
		fillCopy(newGrid);
		return newGrid;
	}

	public void fillCopy(Grid<T> newGrid) {
		for (Location loc : locations()) {
			newGrid.set(loc, this.get(loc));
		}
	}

	@Override
	public void fill(Function<Location, T> initialiser) {
		if (initialiser == null) {
			throw new NullPointerException();
		}

		for (Location loc : locations()) {
			set(loc, initialiser.apply(loc));
		}
	}

	@Override
	public void fill(T element) {
		Collections.fill(cells, element);
	}

	@Override
	public Iterator<T> iterator() {
		return cells.iterator();
	}

	@Override
	public boolean canGo(Location from, GridDirection dir) {
		return isOnGrid(from.getNeighbor(dir));
	}

	public boolean contains(Object obj) {
		return cells.contains(obj);
	}

	/**
	 * Finds the location containing a given object.
	 * 
	 * If no such object has been found, an IllegalArgumentException will be thrown.
	 *
	 * @param obj - the Object to find.
	 * @return A Location loc such that get(loc).equals(obj) is true;
	 */
	public Location locationOf(Object obj) {
		for (Location loc : locations()) {
			if (get(loc).equals(obj)) {
				return loc;
			}
		}

		throw new IllegalArgumentException("Can not find element.");
	}

	public void clear() {
		Collections.fill(cells, null);
	}

	@Override
	public List<Location> getNeighbourhood(Location loc) {
		return getNeighbourhood(loc, 1);
	}

	@Override
	public List<Location> getNeighbourhood(Location loc, int dist) {
		if (dist < 0 || loc == null)
			throw new IllegalArgumentException();
		else if (dist == 0)
			return new ArrayList<>(); // empty!

		List<Location> neighbors = new ArrayList<Location>();
		for (int x = -dist; x <= dist; x++) {
			for (int y = -dist; y <= dist; y++) {
				int newRow = loc.row + x;
				int newCol = loc.col + y;
				Location neigbor = new Location(newRow, newCol);
				if (isOnGrid(neigbor))
					neighbors.add(neigbor);
			}
		}
		neighbors.remove(loc);
		Collections.sort(neighbors, new LocationComparator(loc));
		return neighbors;
	}
}
