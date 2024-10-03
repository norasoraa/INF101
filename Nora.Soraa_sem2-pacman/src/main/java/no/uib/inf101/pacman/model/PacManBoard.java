package no.uib.inf101.pacman.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;
import no.uib.inf101.pacman.model.entities.Ghost;
import no.uib.inf101.pacman.model.entities.PacMan;
import no.uib.inf101.pacman.utilities.Constants;

/**
 * Class that represents a board with tiles. This is a grid of characters
 * organized in rows and columns. The board is created based on a given text
 * file.
 * <p>
 * This class extends the {@link Grid} class to provide additional functionality
 * for accessing the board.
 */
public class PacManBoard extends Grid<Character> {

  private PacMan pacman;
  private List<Ghost> ghosts;

  /**
   * Constructs a new pacman board with the given rows and columns. The board is
   * created from the given text file stored in recources. Each character
   * represents a cell on the board. While looping through the textfile, it uses
   * the cellpositions to create the entities.
   * <p>
   * The final board is a 2D-list where the cell is either a cell containing a dot
   * (the food for the pacman), or part of the wall. All other entities are drawn
   * on top of the board.
   * 
   * @param rows  {@code int} that represents the number of rows on the board
   * @param cols  {@code int} that represents the number of columns on the board
   * @param level {@code String} that represents the name of the text file
   * @throws IOException if an error occur
   */
  public PacManBoard(int rows, int cols, String level) throws IOException {
    super(rows, cols, Constants.EMPTY_CELL);
    this.ghosts = new ArrayList<>();
    formatGrid(readBoardFromFile(level));
  }

  private void formatGrid(List<String> stringBoard) {
    for (int row = 0; row < this.rows(); row++) {
      char[] currentRow = stringBoard.get(row).toCharArray();

      for (int col = 0; col < this.cols(); col++) {
        addToGrid(currentRow[col], new CellPosition(row, col));
        getEntities(currentRow[col], new CellPosition(row, col));
      }
    }
  }

  private void addToGrid(char value, CellPosition pos) {
    if (value == Constants.WALL) {
      this.set(pos, Constants.WALL);
    } else {
      this.set(pos, Constants.DOT);
    }
  }

  private void getEntities(char value, CellPosition pos) {
    switch (value) {
    case Constants.PACMAN -> pacman = new PacMan(pos, Direction.RIGHT, Constants.DEFAULT_PACMAN_HP);
    case Constants.GHOST -> ghosts.add(new Ghost(pos, Direction.UP));
    }
  }

  // Source: https://inf101v23.stromme.me/notat/inputoutput/#ressurser
  private List<String> readBoardFromFile(String level) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(PacManBoard.class.getResourceAsStream(level), StandardCharsets.UTF_8));

    List<String> lines = reader.lines().toList();
    reader.close();
    return lines;
  }

  /** Returns the PacMan found on the board upon initial creation. */
  public PacMan getPacMan() {
    return pacman;
  }

  /**
   * Returns a list of all the ghosts that exist on the board upon initial
   * creation.
   */
  public List<Ghost> getGhosts() {
    return ghosts;
  }

  /**
   * A method that creates a String-representation of the {@link PacManBoard} in a
   * pretty way. For test purposes.
   * 
   * @return A string representation of the board
   */
  protected String prettyString() {
    String stringBoard = "";
    for (int row = 0; row < this.rows(); row++) {
      for (int col = 0; col < this.cols(); col++) {
        stringBoard += this.get(new CellPosition(row, col));
      }
      if (row < this.rows() - 1) {
        stringBoard += "\n";
      }
    }
    return stringBoard;
  }

}
