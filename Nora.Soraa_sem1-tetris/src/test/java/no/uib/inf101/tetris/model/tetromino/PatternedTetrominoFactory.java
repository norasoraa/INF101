package no.uib.inf101.tetris.model.tetromino;

/** Class used in tests to represents a Tetromino Factory. */
public class PatternedTetrominoFactory implements TetrominoFactory {

  private String tetrominoFamilies;
  private int index;

  /**
   * Constructs a Tetromino Factory. The factory produces tetrominos that belongs
   * to the different tetromino families that is given as input. A call to
   * {@link #getNext()} gives the next tetromino with the symbol that is next in
   * line.
   * 
   * @param tetrominoFamilies the possible families a tetromino can belong to
   */
  public PatternedTetrominoFactory(String tetrominoFamilies) {
    this.tetrominoFamilies = tetrominoFamilies;
    this.index = 0;
  }

  @Override
  public Tetromino getNext() {
    char symbol = tetrominoFamilies.charAt(index % tetrominoFamilies.length());
    index++;
    return Tetromino.newTetromino(symbol);
  }

}
